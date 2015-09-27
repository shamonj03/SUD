package com.joe.model;

public class Loot {

	private Item item;
	private double chance;
	
	public Loot(Item item, double chance) {
		this.item = item;
		this.chance = chance;
	}
	
	public double getChance() {
		return chance;
	}
	
	public Item getItem() {
		return item;
	}
}
