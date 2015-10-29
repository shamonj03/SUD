package com.joe.model.event.impl;

import com.joe.model.Event;
import com.joe.model.Item;

public class ConsumeItemEvent extends Event {
	
	private Item item;

	public ConsumeItemEvent(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}
}
