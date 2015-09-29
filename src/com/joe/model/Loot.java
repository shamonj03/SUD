package com.joe.model;

public class Loot {

	private Item item;
	private double chance;

	public Loot(Item item, double chance) {
		this.item = item;
		this.chance = chance;
	}

	public Loot(int id, double chance) {
		this(id, 1, chance);
	}

	public Loot(int id, int amount, double chance) {
		this(new Item(id, amount), chance);
	}

	public double getChance() {
		return chance;
	}

	public Item getItem() {
		return item;
	}
}
