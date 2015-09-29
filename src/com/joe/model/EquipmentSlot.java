package com.joe.model;

import com.google.gson.annotations.SerializedName;
import com.joe.util.Util;

public enum EquipmentSlot {
	@SerializedName("HELMET")
	HELMET(0),
	@SerializedName("CHEST")
	CHEST(1),
	@SerializedName("LEGS")
	LEGS(2),
	@SerializedName("MAIN_HAND")
	MAIN_HAND(3),
	@SerializedName("OFF_HAND")
	OFF_HAND(4),
	@SerializedName("GLOVES")
	GLOVES(5),
	@SerializedName("BOOTS")
	BOOTS(6),
	@SerializedName("AMMO")
	AMMO(7),
	NONE(-1);

	private int slot;
	
	private EquipmentSlot(int slot) {
		this.slot = slot;
	}
	
	public int getSlot() {
		return slot;
	}
	
	private static final EquipmentSlot[] slots = EquipmentSlot.values();
	
	public static EquipmentSlot forId(int slot) {
		return slots[slot];
	}
	
	public String getName() {
		return Util.capitalizeAllFirstLetters(name());
	}
}
