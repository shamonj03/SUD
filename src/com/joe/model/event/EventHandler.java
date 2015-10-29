package com.joe.model.event;

public abstract class EventHandler<T extends Event> {

	public abstract void handle(T event);
	
}
