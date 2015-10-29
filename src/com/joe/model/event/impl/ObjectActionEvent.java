package com.joe.model.event.impl;

import com.joe.model.entity.GameObject;

public class ObjectActionEvent extends EntityEvent<GameObject> {

	public ObjectActionEvent(int zoneId, GameObject entity) {
		super(zoneId, entity);
	}
}
