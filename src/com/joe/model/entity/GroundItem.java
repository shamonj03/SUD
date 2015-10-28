package com.joe.model.entity;

import com.joe.io.ItemData;
import com.joe.model.Entity;
import com.joe.model.Item;
import com.joe.model.Location;

public class GroundItem extends Entity<ItemData> {

	private Item item;

	public GroundItem(Item item, Location location) {
		this.item = item;
		this.location.set(location);
	}

	public Item getItem() {
		return item;
	}

	@Override public String toString() {
		return "GroundItem(Item: " + item + ", " + super.toString() + ")";
	}

	@Override public ItemData getData() {
		return item.getData();
	}

}
