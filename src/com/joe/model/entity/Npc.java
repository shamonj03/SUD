package com.joe.model.entity;

import com.joe.io.data.NpcData;
import com.joe.io.definition.NpcDefinition;
import com.joe.io.definition.ObjectDefinition;
import com.joe.model.EntityType;
import com.joe.model.Location;

public class Npc extends Character {
	
	private int id;
	
	private NpcData data;
	
	public Npc(int id, Location location) {
		this.location.set(location);
		this.setId(id);
	}
	
	public void setId(int id) {
		this.id = id;
		this.data = NpcDefinition.forId(id);
		this.name = data.getName();
	}
	
	public int getId() {
		return id;
	}
	
	public NpcData getData() {
		return data;
	}

	@Override public EntityType getType() {
		return EntityType.NPC;
	}

	@Override public String toString() {
		return "Npc(ID: " + id + ", Data: " + getData() + ", "
				+ super.toString() + ")";
	}

	@Override public boolean equals(Object o) {
		if (!(o instanceof Npc)) {
			return false;
		}
		Npc other = (Npc) o;
		return super.equals(o) && getType().equals(other.getType()) && id == other.getId();
	}
}
