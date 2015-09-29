package com.joe.model;

public enum EntityType {

	OBJECT, ITEM, NPC, PLAYER;

	
	public String getName() {
		char firstChar = this.name().charAt(0);
		String otherCharacters = name().substring(1, name().length()).toLowerCase();
		
		return firstChar + otherCharacters;
	}
}
