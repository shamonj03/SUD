package com.joe.model;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.joe.Game;
import com.joe.GameFrame;
import com.joe.model.entity.Character;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.model.controller.BoundedEntityController;
import com.joe.model.controller.BoundedMap;
import com.joe.model.controller.Stack;
import com.joe.model.controller.StackedEntityControler;
import com.joe.model.entity.GameObject;
import com.joe.util.Util;

public abstract class Zone extends BoundedMap<java.lang.Character> {

	private final int width;
	private final int height;

	protected final StackedEntityControler<Npc> npcController;
	protected final BoundedEntityController<GameObject> gameObjectController;
	protected final StackedEntityControler<GroundItem> groundItemController;

	private static final int[][] TILE_OFFSETS = { { -1, 0, }, { 0, -1 }, { 0, 0, }, { 1, 0 }, { 0, 1 } };

	/**
	 * @return The the map containing the objects of the zone;
	 */
	public abstract int[][] getDefaultObjectMap();

	public Zone() {
		height = getDefaultObjectMap().length;
		width = getDefaultObjectMap()[0].length;

		setBounds(width, height);

		npcController = new StackedEntityControler<>(width, height);
		gameObjectController = new BoundedEntityController<>(width, height);
		groundItemController = new StackedEntityControler<>(width, height);

		initialize();
		registerObjects();
	}

	protected abstract void initialize();

	public abstract void handleObjectInteraction(GameObject object);

	public abstract void handleNpcInteraction(Npc npc);

	public void handleGroundItemInteraction(GroundItem item) {
		Player player = Game.getPlayer();

		if (player.getData().getInventory().add(item.getItem())) {
			Util.streamMessageLn("You picked up: " + item.getItem().getName() + " x " + item.getItem().getAmount()
					+ ".");
			//Util.pressEnterToContinue();
			groundItemController.unregister(item);
		} else {
			Util.streamMessageLn("Your inventory is too full to pick this item up.");
			//Util.pressEnterToContinue();
		}
	}

	private void registerObjects() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int id = getDefaultObjectMap()[y][x];

				GameObject object = new GameObject(id, new Location(x, y));
				gameObjectController.register(object);
			}
		}
	}

	private void resetMap() {
		reset();

		gameObjectController.iterate(object -> set(object.getLocation().getX(), object.getLocation().getY(), object
				.getData().getMapChar()));

		npcController.iterateTopTiles(npc -> set(npc.getLocation().getX(), npc.getLocation().getY(), npc.getData()
				.getMapChar()));

		groundItemController.iterateTopTiles(item -> set(item.getLocation().getX(), item.getLocation().getY(), 'i'));

		Player player = Game.getPlayer();
		if (player != null) {
			set(player.getLocation().getX(), player.getLocation().getY(), '@');
		}
	}

	public void drawMap() {
		resetMap();

		GameFrame.getMap().clearText();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				char tile = get(x, y);
				GameFrame.getMap().printf("%2c", tile);
			}
			GameFrame.getMap().println();
		}
	}

	public ArrayList<Entity<?>> getEntitiesInReach(Predicate<Entity<?>> predicate) {
		ArrayList<Entity<?>> list = new ArrayList<>();

		Player player = Game.getPlayer();

		for (int index = 0; index < TILE_OFFSETS.length; index++) {
			int x = player.getLocation().getX() + TILE_OFFSETS[index][0];
			int y = player.getLocation().getY() + TILE_OFFSETS[index][1];

			if (!inBounds(x, y)) {
				continue;
			}
			GameObject object = gameObjectController.get(x, y);

			if (predicate.test(object)) {
				list.add(object);
			}

			Stack<Npc> npcs = npcController.get(x, y);
			for (Npc npc : npcs) {
				if (predicate.test(npc)) {
					list.add(npc);
				}
			}

			Stack<GroundItem> groundItems = groundItemController.get(x, y);
			for (GroundItem item : groundItems) {
				if (predicate.test(item)) {
					list.add(item);
				}
			}
		}
		return list;
	}

	public void printVisibleZone() {
		resetMap();

		Camera camera = Game.getCamera();

		int camX = camera.getLocation().getX();
		int camY = camera.getLocation().getY();
		int startX = camX - (camera.getWidth() / 2);
		int startY = camY - (camera.getHeight() / 2);
		int endX = camX + (camera.getWidth() / 2);
		int endY = camY + (camera.getHeight() / 2);

		if (startY < 0) {
			startY = 0;
		}
		if (startX < 0) {
			startX = 0;
		}
		if (endY >= getHeight()) {
			endY = getHeight() - 1;
		}
		if (endX >= getWidth()) {
			endX = getWidth() - 1;
		}

		GameFrame.getMap().clearText();

		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				GameFrame.getMap().printf("%2c", get(x, y));
			}
			GameFrame.getMap().println();
		}
	}

	public StackedEntityControler<Npc> getNpController() {
		return npcController;
	}

	public BoundedEntityController<GameObject> getGameObjectController() {
		return gameObjectController;
	}

	public StackedEntityControler<GroundItem> getGroundItemController() {
		return groundItemController;
	}
}
