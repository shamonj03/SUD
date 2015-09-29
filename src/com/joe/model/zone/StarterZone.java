package com.joe.model.zone;

import com.joe.Game;
import com.joe.model.Item;
import com.joe.model.Location;
import com.joe.model.Loot;
import com.joe.model.LootTable;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.util.Util;

public class StarterZone extends Zone {

	private static final int[][] tileMap = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },

			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 1 },

			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1 },

			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },

			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },

			{ 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 2 },

			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	private static final Loot[][] potLoot = { { new Loot(1, 3, 75) } };

	@Override public void initialize() {
		Npc test = new Npc(0, new Location(3, 3));
		register(test);

		GroundItem sword = new GroundItem(new Item(0, 1), new Location(1, 1));
		register(sword);
	}

	@Override public void handleObjectInteraction(GameObject object) {
		Player player = Game.getPlayer();

		switch (object.getId()) {
			case 2: // Locked Door
				if (player.getLocation().equals(10, 5)) {
					if (player.getInventory().contains(4, 1)) {
						player.getInventory().remove(4, 1);
						object.setId(3);
						Util.streamMessageLn("You unlock the door.");
						Util.pressEnterToContinue();
					} else {
						Util.streamMessageLn("Looks like you need a key to unlock this door.");
						Util.pressEnterToContinue();
					}
				}
				break;

			case 4: // Pot
				Util.streamMessageLn("You break the pot...");

				if (player.getLocation().withinDistance(new Location(10, 1), 1)) {
					Item key = new Item(4, 1);

					Util.streamMessageLn("You find a key, this could be useful");
					Util.pressEnterToContinue();
					player.addItemToInv(key);
				} else {
					boolean foundLoot = LootTable.basicRewardLoot(potLoot);

					if (!foundLoot) {
						Util.streamMessageLn("The pot was empty.");
						Util.pressEnterToContinue();
					}
				}
				object.setId(0);
				break;
		}
	}

	@Override public void handleNpcInteraction(Npc npc) {
		switch (npc.getId()) {
			case 0:
				Util.hintMessageGuide();
				break;
		}
	}

	@Override public int[][] getDefaultObjectMap() {
		return tileMap;
	}
}
