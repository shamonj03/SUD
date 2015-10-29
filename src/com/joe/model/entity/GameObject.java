package com.joe.model.entity;

import com.joe.io.ObjectData;
import com.joe.io.definition.ObjectDefinition;
import com.joe.model.Entity;
import com.joe.model.Location;
import com.joe.model.Zone;

public class GameObject extends Entity<ObjectData> {

	private int id;

	public GameObject(int id, Location location) {
		this.location.set(location);
		this.setId(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override public ObjectData getData() {
		return ObjectDefinition.forId(id);
	}

	@Override public String toString() {
		return "GameObject(ID: " + id + ", Data: " + getData() + ", " + super.toString() + ")";
	}

	@Override public boolean equals(Object o) {
		if (!(o instanceof Player)) {
			return false;
		}
		GameObject other = (GameObject) o;
		return super.equals(o) && getData().getEntityType().equals(other.getData().getEntityType()) && id == other.getId();
	}

	public int getId() {
		return id;
	}
}
