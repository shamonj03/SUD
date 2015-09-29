package com.joe.model.entity;

import com.joe.io.data.ObjectData;
import com.joe.io.definition.ObjectDefinition;
import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Location;

public class GameObject extends Entity {

	private int id;

	
	public GameObject(int id, Location location) {
		this.location.set(location);
		this.setId(id);
	}
	
	public void setId(int id) {
		this.id = id;
		this.name = getData().getName();
	}

	public ObjectData getData() {
		return ObjectDefinition.forId(id);
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
