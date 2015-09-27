package com.joe.model.entity;

import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Item;
import com.joe.model.Location;

public class GroundItem extends Entity {
	
	private Item item;
	
	public GroundItem(Item item, Location location) {
		this.item = item;
		this.location.set(location);
		this.name = item.getData().getName();
	}

	@Override public EntityType getType() {
		return EntityType.ITEM;
	}
	
	public Item getItem() {
		return item;
	}
	
	@Override public String toString() {
		return "GroundItem(Item: " + item + ", " + super.toString() + ")";
	}
}
