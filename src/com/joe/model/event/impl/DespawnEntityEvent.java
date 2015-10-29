package com.joe.model.event.impl;

import com.joe.model.Entity;
import com.joe.model.Location;
import com.joe.model.Zone;
import com.joe.model.event.Event;

public class DespawnEntityEvent extends Event {

	private Entity<?> entity;
	
	private Zone zone;

	public DespawnEntityEvent(Zone zone, Entity<?> entity) {
		this.zone = zone;
		this.entity = entity;
	}

	public Zone getZone() {
		return zone;
	}
	
	public Entity<?> getEntity() {
		return entity;
	}


}
