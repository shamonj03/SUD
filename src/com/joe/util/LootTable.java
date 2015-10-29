package com.joe.util;

import java.util.function.Consumer;

import com.joe.Game;
import com.joe.model.Item;
import com.joe.model.Loot;
import com.joe.model.entity.Player;

public class LootTable {

	public static boolean rewardLoot(Loot[][] lootTable, Consumer<Item> consumer) {

		boolean foundLoot = false;

		for (int slot = 0; slot < lootTable.length; slot++) {

			int item = (int) randomInRange(0, lootTable[slot].length);
			Loot loot = lootTable[slot][item];

			double chance = randomInRange(0, 100);
			//System.out.println("Rolling for: " + loot.getItem().getName() + " rolled @ " + chance + " need " + loot.getChance());
			if (chance <= loot.getChance()) {
				Item lootedItem = loot.getItem();

				int amount = (int) randomInRange(1, lootedItem.getAmount());
				lootedItem.setAmount(amount);

				consumer.accept(lootedItem);
				foundLoot = true;
			}
		}
		return foundLoot;
	}

	public static boolean basicRewardLoot(Loot[][] lootTable) {
		Player player = Game.getPlayer();

		return rewardLoot(
				lootTable,
				item -> {
					Util.streamMessageLn("You find: "
							+ item.getData().getName() + " x "
							+ item.getAmount());
					//Util.pressEnterToContinue();
					player.addItemToInv(item);
				});
	}

	private static double randomInRange(int min, int max) {
		return min + (Math.random() * (max - min));
	}
}
