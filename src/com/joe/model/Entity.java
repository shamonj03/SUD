package com.joe.model;

import com.joe.control.ZoneController;
import com.joe.io.EntityData;

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
		return ZoneController.forId(zoneId);
	}

	public int getZoneId() {
		return zoneId;
	}
}
