package com.joe.model.event.impl;

import com.joe.model.Event;
import com.joe.model.Item;

public class ItemOnItemEvent extends Event {

	private Item focus;
	private Item target;

	public ItemOnItemEvent(Item focus, Item target) {
		this.focus = focus;
		this.target = target;
	}

	public Item getFocus() {
		return focus;
	}

	public Item getTarget() {
		return target;
	}
}
