package com.joe.io;

import com.joe.io.definition.ZoneDefinition;
import com.joe.model.EntityType;
import com.joe.model.Equipment;
import com.joe.model.ItemContainer;
import com.joe.model.Zone;

public class PlayerData implements EntityData {

	private String name;

	private ItemContainer inventory = new ItemContainer(28);

	private Equipment equipment = new Equipment();

	private Zone zone = ZoneDefinition.forId(0);

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

	public Zone getZone() {
		return zone;
	}

	@Override public EntityType getEntityType() {
		return EntityType.PLAYER;
	}
}
