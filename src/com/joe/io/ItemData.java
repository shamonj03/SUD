package com.joe.io;

import com.joe.model.entity.EntityType;
import com.joe.model.item.EquipmentSlot;
import com.joe.model.item.ItemType;

public class ItemData implements EntityData {

	private String name = "Null Item";

	private boolean stackable = false;

	private ItemType type = ItemType.DEFAULT;

	private EquipmentSlot slot = EquipmentSlot.NONE;

	private String examine = "This item is nothing of interest.";

	private String[] actions;
	
	private int id;
	
	public int getId() {
		return id;
	}

	public String[] getActions() {
		return actions;
	}

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
		return "ItemData(ID: " + id + ", Name: " + name + ", Stackable: " + stackable + ", Type: " + type + ", Slot: " + slot + ")";
	}

	@Override public EntityType getEntityType() {
		return EntityType.ITEM;
	}

}
