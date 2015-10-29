package com.joe.model.event.impl;

import com.joe.model.Entity;
import com.joe.model.Zone;

public class DespawnEntityEvent extends EntityEvent<Entity<?>> {

	public DespawnEntityEvent(int zoneId, Entity<?> entity) {
		super(zoneId, entity);
	}

	public DespawnEntityEvent(Zone zone, Entity<?> entity) {
		super(zone, entity);
	}
}
