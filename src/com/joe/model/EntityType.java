package com.joe.model;

import com.joe.util.Util;

public enum EntityType {

	OBJECT, ITEM, NPC, PLAYER;

	public String getName() {
		return Util.capitalizeAllFirstLetters(name());
	}
}
