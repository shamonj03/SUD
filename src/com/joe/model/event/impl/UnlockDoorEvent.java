package com.joe.model.event.impl;

import com.joe.model.Direction;
import com.joe.model.entity.GameObject;
import com.joe.model.event.Event;

public class UnlockDoorEvent extends Event {

	private final GameObject object;
	private final Direction direction;
	private final int keyId;

	public UnlockDoorEvent(GameObject object, Direction direction, int keyId) {
		this.object = object;
		this.direction = direction;
		this.keyId = keyId;
	}

	public int getKeyId() {
		return keyId;
	}

	public GameObject getObject() {
		return object;
	}

	public Direction getDirection() {
		return direction;
	}
}
