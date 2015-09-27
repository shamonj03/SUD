package com.joe.io.data;

public class ItemData {

	private String name = "Null Item";
	
	private boolean stackable = false;
	
	private boolean equipable = false;
	
	
	public String getName() {
		return name;
	}
	
	public boolean isStackable() {
		return stackable;
	}
	
	public boolean isEquipable() {
		return isEquipable();
	}
	
	@Override public String toString() {
		return "ItemData(Name: " + name + ", Stackable: " + stackable + ", Equipable: " + equipable + ")";
	}
}
