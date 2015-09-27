package com.joe.io.data;

import com.joe.model.EquipmentSlot;

public class ItemData {

	private String name = "Null Item";
	
	private boolean stackable = false;
	
	private boolean equipable = false;
	
	private EquipmentSlot slot = EquipmentSlot.NONE;
	
	public String getName() {
		return name;
	}
	
	public EquipmentSlot getSlot() {
		return slot;
	}

	public int getSlotNumber() {
		return slot.getSlot();
	}
	
	public boolean isStackable() {
		return stackable;
	}
	
	public boolean isEquipable() {
		return equipable;
	}
	
	@Override public String toString() {
		return "ItemData(Name: " + name + ", Stackable: " + stackable + ", Equipable: " + equipable + ", Slot: " + slot + ")";
	}
}
