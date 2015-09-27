package com.joe.model;

import java.util.ArrayList;

import com.joe.Game;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.util.Messages;
import com.joe.util.Util;

public abstract class Zone extends EntityManager {

	/**
	 * The tiles containing everything in the map.
	 */
	private char[][] tileMap;

	/**
	 * Create a new zone.
	 */
	public Zone() {
		initialize();
		registerObjects();
	}
	
	/**
	 * @return The the map containing the objects of the zone;
	 */
	public abstract int[][] getDefaultObjectMap();

	/**
	 * Initialize all the entities in the zone.
	 */
	public abstract void initialize();
	
	public abstract void handleObjectInteraction(GameObject object);
	
	public abstract void handleNpcInteraction(Npc npc);

	public void handleGroundItemInteraction(GroundItem item) {
		Player player = Game.getPlayer();
		
		player.getInventory().add(item.getItem());
		
		Util.streamMessageLn("You picked up: " + item.getName() + " x " + item.getItem().getAmount() +".");
		Messages.pressEnterToContinue();
		unregister(item);
	}

	/**
	 * Reset the tile map to the default map;
	 */
	private void registerObjects() {
		int[][] map = getDefaultObjectMap();
		tileMap = new char[map.length][];

		for (int y = 0; y < map.length; y++) {
			tileMap[y] = new char[map[y].length];
			for (int x = 0; x < map[y].length; x++) {
				int id = map[y][x];

				GameObject object = new GameObject(id, new Location(x, y));
				register(object);
			}
		}
	}
	
	private void resetMap() {
		int[][] map = getDefaultObjectMap();

		tileMap = new char[map.length][];

		for (int y = 0; y < map.length; y++) {
			tileMap[y] = new char[map[y].length];
		}
	}

	private void placeEntities() {
		for (Entity entity : getEntities()) {
			if (!checkBounds(entity.getLocation())) {
				continue;
			}
			char tile = getTile(entity.getLocation());

			if (tile == '\u0000') { // Only display objects if the default char is present.
				if (entity.getType() == EntityType.OBJECT) {
					GameObject object = (GameObject) entity;
					setTile(object.getLocation(), object.getData().getMapChar());
				}
			}

			if (tile != 'P') { // Only display npc if is not ontop of the player.
				if (entity.getType() == EntityType.NPC) {
					Npc npc = (Npc) entity;
					setTile(entity.getLocation(), npc.getData().getMapChar());
				}
				if (entity.getType() == EntityType.ITEM) {
					setTile(entity.getLocation(), 'i');
				}
			}

			if (entity.getType() == EntityType.PLAYER) { // The place player over everything else.
				setTile(entity.getLocation(), 'P');
			}
		}
	}

	public ArrayList<Entity> getEntitiesInReach() {
		ArrayList<Entity> list = new ArrayList<>();

		Player player = Game.getPlayer();

		for (Entity entity : getEntities()) {
			if (entity.getType() == EntityType.PLAYER) {
				continue;
			}
			if (entity.getLocation().withinDistance(player.getLocation(), 1)) {
				list.add(entity);
			}
		}
		return list;
	}

	/**
	 * Print everything in the zone to the screen.
	 */
	public void printZone() {
		resetMap();
		placeEntities();

		for (int y = 0; y < tileMap.length; y++) {
			for (int x = 0; x < tileMap[y].length; x++) {
				System.out.printf("%2c", getTile(x, y));
			}
			System.out.println();
		}
	}

	public void printVisibleZone() {
		resetMap();
		placeEntities();

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
		if (endY >= tileMap.length) {
			endY = tileMap.length - 1;
		}
		if (endX >= tileMap[endY].length) {
			endX = tileMap[endY].length - 1;
		}

		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				System.out.printf("%2c", getTile(x, y));
			}
			System.out.println();
		}
	}

	/**
	 * Validate if a coordinate pair is within the bounds of the map.
	 * 
	 * @param x
	 * @param y
	 * 
	 * @return true if within bounds.
	 */
	public boolean checkBounds(int x, int y) {
		return (y >= 0 && y < tileMap.length)
				&& (x >= 0 && x < tileMap[y].length);
	}

	/**
	 * Set a tile at a coordinate pair within the maps bounds to a character.
	 * 
	 * @param x
	 * @param y
	 * @param c
	 */
	public void setTile(int x, int y, char c) {
		if (!checkBounds(x, y)) {
			return;
		}
		tileMap[y][x] = c;
	}

	/**
	 * Get a tile at a coordinate pair within the maps bounds.
	 * 
	 * @param x
	 * @param y
	 * @return the character at the coordinate pair.
	 */
	public char getTile(int x, int y) {
		if (!checkBounds(x, y)) {
			throw new IndexOutOfBoundsException();
		}
		return tileMap[y][x];
	}

	/**
	 * Checks if a given location is within the bounds of the map.
	 * 
	 * @param location
	 * @return true if within bounds.
	 */
	public boolean checkBounds(Location location) {
		return checkBounds(location.getX(), location.getY());
	}

	/**
	 * Set a tile at a coordinate pair within the maps bounds to a character.
	 * 
	 * @param x
	 * @param y
	 * @param c
	 */
	public void setTile(Location location, char c) {
		setTile(location.getX(), location.getY(), c);
	}

	/**
	 * Checks if a given location is within the bounds of the map.
	 * 
	 * @param location
	 * @return the character at the location.
	 */
	public char getTile(Location location) {
		return getTile(location.getX(), location.getY());
	}
}
