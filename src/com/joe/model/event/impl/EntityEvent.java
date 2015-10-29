package com.joe.model.event.impl;

import com.joe.control.ZoneController;
import com.joe.model.Entity;
import com.joe.model.Event;
import com.joe.model.Zone;

public class EntityEvent<T extends Entity<?>> extends Event {
	
	private T entity;
	
	private Zone zone;

	public EntityEvent(int zoneId, T entity) {
		this.zone = ZoneController.forId(zoneId);
		this.entity = entity;
	}
	
	public EntityEvent(Zone zone, T entity) {
		this.zone = zone;
		this.entity = entity;
	}

	public Zone getZone() {
		return zone;
	}
	
	public T getEntity() {
		return entity;
	}

}
