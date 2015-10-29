package com.joe.model.event;

import com.joe.model.Event;

public abstract class EventHandler<T extends Event> {

	public abstract void handle(T event);
	
}
