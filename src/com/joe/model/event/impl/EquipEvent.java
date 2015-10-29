package com.joe.model.event.impl;

import com.joe.model.Item;
import com.joe.model.event.Event;

public class EquipEvent extends Event {
	
	private final Item item;
	
	public EquipEvent(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}
}
