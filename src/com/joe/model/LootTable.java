package com.joe.model;

import java.util.function.Consumer;

public class LootTable {
	
	public static void rewardLoot(Loot[][] lootTable, Consumer<Loot> consumer) {
		
		for(int slot = 0; slot < lootTable.length; slot++) {
			
			int item = (int) randomInRange(0, lootTable[slot].length);
			Loot loot = lootTable[slot][item];
			
			double chance =  randomInRange(0, 100);
			//System.out.println("Rolling for: " + loot.getItem().getName() + " rolled @ " + chance + " need " + loot.getChance());
			if(chance <= loot.getChance()) {
				consumer.accept(loot);
			}
		}
	}
	
	private static double randomInRange(int min, int max) {
		return min + (Math.random() * (max - min));
	}
}
