package com.joe.model;

import com.google.gson.annotations.SerializedName;

public enum ItemType {

	@SerializedName("EQUIPABLE")
	EQUIPABLE("Equip"),
	@SerializedName("CONSUMABLE")
	CONSUMABLE("Consume"),
	@SerializedName("DEFAULT")
	DEFAULT("Inspect");
	
	private String menuOption;
	
	private ItemType(String menuOption) {
		this.menuOption = menuOption;
	}
	
	public String getMenuOption() {
		return menuOption;
	}
}
