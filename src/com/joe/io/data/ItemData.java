package com.joe.io.data;

import com.joe.model.EquipmentSlot;
import com.joe.model.ItemType;

public class ItemData {

	private String name = "Null Item";
	
	private boolean stackable = false;

	private ItemType type = ItemType.DEFAULT;

	private EquipmentSlot slot = EquipmentSlot.NONE;
	
	private String examine = "This item is nothing of interest.";
	
	public String getExamine() {
		return examine;
	}
	
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
	
	public ItemType getType() {
		return type;
	}
	
	@Override public String toString() {
		return "ItemData(Name: " + name + ", Stackable: " + stackable + ", Type: " + type + ", Slot: " + slot + ")";
	}
}
