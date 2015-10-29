package com.joe.model.event.impl;

import com.joe.model.Event;
import com.joe.model.Item;

public class EquipEvent extends Event {
	
	private final Item item;
	
	public EquipEvent(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}
}
