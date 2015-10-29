package com.joe.model;

import com.joe.io.EntityData;
import com.joe.io.definition.ZoneDefinition;
import com.joe.model.event.EventDispatcher;
import com.joe.model.event.impl.DespawnEntityEvent;
import com.joe.model.event.impl.SpawnEntityEvent;

public abstract class Entity<T extends EntityData> {

	public abstract T getData();

	protected Zone zone;

	protected Location location = new Location(0, 0);

	public void setZone(int id) {
		this.zone = ZoneDefinition.forId(id);
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Location getLocation() {
		return location;
	}

	public Zone getZone() {
		return zone;
	}

}
