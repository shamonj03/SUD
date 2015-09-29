package com.joe.model;

import com.google.gson.annotations.SerializedName;

public enum ItemType {

	@SerializedName("EQUIPABLE")
	EQUIPABLE,
	@SerializedName("CONSUMABLE")
	CONSUMABLE,
	@SerializedName("DEFAULT")
	DEFAULT;
	
}
