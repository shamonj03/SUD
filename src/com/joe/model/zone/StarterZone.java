package com.joe.model.zone;

import com.joe.Game;
import com.joe.model.Direction;
import com.joe.model.Item;
import com.joe.model.Location;
import com.joe.model.Loot;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.model.event.EventDispatcher;
import com.joe.model.event.impl.SpawnEntityEvent;
import com.joe.model.event.impl.UnlockDoorEvent;
import com.joe.util.GameUtil;
import com.joe.util.Messages;
import com.joe.util.Util;

public class StarterZone extends Zone {

	private static final int[][] tileMap = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },

		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 1 },

		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1 },

		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },

		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },

		{ 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 2 },

		{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	private static final Loot[][] potLoot = { { new Loot(1, 3, 75) } };

	@Override public void initialize() {
		EventDispatcher.dispatch(new SpawnEntityEvent(this, new Npc(0, new Location(3, 3))));
		EventDispatcher.dispatch(new SpawnEntityEvent(this, new GroundItem(new Item(0, 1), new Location(1, 1))));
	}

	@Override public void handleObjectInteraction(GameObject object) {
		Player player = Game.getPlayer();

		switch (object.getId()) {
			case 2: // Locked Door
				EventDispatcher.dispatch(new UnlockDoorEvent(object, Direction.WEST, 4));
				break;

			case 4: // Pot

				if (object.getLocation().equals(10, 1)) {
					GameUtil.customBreakPot(object, p -> {
						if (!player.getData().getInventory().contains(4)) {
							Item key = new Item(4, 1);
							player.addItemToInv(key);

							Util.streamMessageLn("You find a key, this could be useful");
						}
					});
				} else {
					GameUtil.breakPot(potLoot, object);
				}
				break;

			default:
				Messages.nothingInterestingHappens();
				break;
		}
	}

	@Override public void handleNpcInteraction(Npc npc) {
		switch (npc.getId()) {
			case 0:
				Messages.hintMessageGuide();
				break;
		}
	}

	@Override public int[][] getDefaultObjectMap() {
		return tileMap;
	}
}
