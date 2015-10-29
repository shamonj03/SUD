package com.joe.model.event.impl;

import com.joe.model.Entity;
import com.joe.model.Zone;

public class SpawnEntityEvent extends EntityEvent<Entity<?>> {

	public SpawnEntityEvent(int zoneId, Entity<?> entity) {
		super(zoneId, entity);
	}

	public SpawnEntityEvent(Zone zone, Entity<?> entity) {
		super(zone, entity);
	}
}
