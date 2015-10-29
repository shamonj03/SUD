package com.joe.model.event.impl;

import com.joe.model.Direction;
import com.joe.model.Entity;
import com.joe.model.Event;

public class MoveEvent extends Event {

	private final Direction direction;

	public final Entity<?> entity;

	public MoveEvent(Entity<?> entity, Direction direction) {
		this.entity = entity;
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public Entity<?> getEntity() {
		return entity;
	}
}
