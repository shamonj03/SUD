package com.joe.model;

import com.joe.io.EntityData;

public abstract class Entity<T extends EntityData> {

	public abstract T getData();

	protected Location location = new Location(0, 0);

	public Location getLocation() {
		return location;
	}

}
