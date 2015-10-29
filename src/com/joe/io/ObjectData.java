package com.joe.io;

import com.joe.model.EntityType;

public class ObjectData implements EntityData {

	private String name = "Null Object";

	private boolean solid = true;

	private boolean interactable = false;

	private char mapChar = ' ';

	private int id;

	public int getId() {
		return id;
	}

	@Override public String getName() {
		return name;
	}

	public boolean isSolid() {
		return solid;
	}

	public boolean isInteractable() {
		return interactable;
	}

	public char getMapChar() {
		return mapChar;
	}

	@Override public EntityType getEntityType() {
		return EntityType.OBJECT;
	}

	@Override public String toString() {
		return "ObjectData(Name: " + name + ", MapChar: " + mapChar + ", Solid: " + solid + ", Interactable: "
				+ interactable + ")";
	}
}
