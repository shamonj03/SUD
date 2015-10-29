package com.joe.io;

import com.joe.model.entity.EntityType;

public class NpcData implements EntityData {

	private String name = "Null Npc";

	private boolean friendly = true;

	private boolean solid = false;
	
	private int id;

	private char mapChar = 'N'; 

	public int getId() {
		return id;
	}
	
	@Override public String getName() {
		return name;
	}

	public boolean isFriendly() {
		return friendly;
	}

	public boolean isSolid() {
		return solid;
	}

	public char getMapChar() {
		return mapChar;
	}

	@Override public EntityType getEntityType() {
		return EntityType.NPC;
	}

	@Override public String toString() {
		return "NpcData(Name: " + name + ", MapChar: " + mapChar + ", Firendly: " + friendly + ", Solid: " + solid + ")";
	}

}
