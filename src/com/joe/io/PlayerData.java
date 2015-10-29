package com.joe.io;

import com.joe.model.entity.EntityType;
import com.joe.model.item.Equipment;
import com.joe.model.item.ItemContainer;

public class PlayerData implements EntityData {

	private String name;

	private ItemContainer inventory = new ItemContainer(28);

	private Equipment equipment = new Equipment();

	public void setName(String name) {
		this.name = name;
	}

	@Override public String getName() {
		return name;
	}

	public ItemContainer getInventory() {
		return inventory;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	@Override public EntityType getEntityType() {
		return EntityType.PLAYER;
	}
}
