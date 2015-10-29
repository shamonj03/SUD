package com.joe.model;

import com.joe.io.EntityData;
import com.joe.io.definition.ZoneDefinition;
import com.joe.model.event.EventDispatcher;

public abstract class Entity<T extends EntityData> {

	public abstract T getData();

	protected int zoneId;

	protected Location location = new Location(0, 0);

	public void setZone(int zoneId) {
		this.zoneId = zoneId;
	}

	public Location getLocation() {
		return location;
	}

	public Zone getZone() {
		return ZoneDefinition.forId(zoneId);
	}

	public int getZoneId() {
		return zoneId;
	}
}
