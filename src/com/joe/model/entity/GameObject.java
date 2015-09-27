package com.joe.model.entity;

import com.joe.io.data.ObjectData;
import com.joe.io.definition.ObjectDefinition;
import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Location;

public class GameObject extends Entity {

	private int id;

	private ObjectData data;
	
	public GameObject(int id, Location location) {
		this.id = id;
		this.location.set(location);
		this.data = ObjectDefinition.forId(id);
		this.name = data.getName();
	}

	public ObjectData getData() {
		return data;
	}

	@Override public EntityType getType() {
		return EntityType.OBJECT;
	}

	@Override public String toString() {
		return "GameObject(ID: " + id + ", Data: " + getData() + ", "
				+ super.toString() + ")";
	}

	@Override public boolean equals(Object o) {
		if (!(o instanceof Player)) {
			return false;
		}
		GameObject other = (GameObject) o;
		return super.equals(o) && getType().equals(other.getType())
				&& id == other.getId();
	}

	public int getId() {
		return id;
	}
}
