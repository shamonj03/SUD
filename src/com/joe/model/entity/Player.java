package com.joe.model.entity;

import com.joe.io.PlayerData;
import com.joe.io.definition.ZoneDefinition;
import com.joe.model.Equipment;
import com.joe.model.Item;
import com.joe.model.ItemContainer;
import com.joe.model.ItemType;
import com.joe.model.Zone;
import com.joe.util.Util;

public class Player extends Character<PlayerData> {

	private PlayerData data = new PlayerData();

	public Player() {
		location.set(2, 3);
		Zone zone = data.getZone();
		//zone.register(this);
	}

	@Override public PlayerData getData() {
		return data;
	}

	public boolean addItemToInv(Item item) {
		ItemContainer inventory = data.getInventory();
		Zone zone = data.getZone();

		if (!inventory.add(item)) {
			zone.getGroundItemController().register(new GroundItem(item, getLocation()));
			Util.streamMessageLn("Your inventory is too full. The item is placed on the ground.");
			//Util.pressEnterToContinue();
			return false;
		}
		return true;
	}

	public boolean equip(Item item) {
		ItemContainer inventory = data.getInventory();
		Equipment equipment = data.getEquipment();

		if (item.getData().getType() != ItemType.EQUIPABLE) {
			return false;
		}
		if (equipment.add(item)) {
			inventory.remove(item);
			Util.streamMessageLn("You equip the " + item.getData().getName() + ".");
			//Util.pressEnterToContinue();
		} else {
			Util.streamMessageLn("Your inventory is too full to equip the " + item.getData().getName() + ".");
			//Util.pressEnterToContinue();
		}
		return true;
	}

	public void setZone(int id) {
		Zone zone = data.getZone();

		if (zone != null) {
			//zone.unregister(this);
		}
		zone = ZoneDefinition.forId(id);
		//zone.register(this);
	}


	@Override public String toString() {
		return "Player(" + super.toString() + ")";
	}

	@Override public boolean equals(Object o) {
		if (!(o instanceof Player)) {
			return false;
		}
		Player other = (Player) o;
		return super.equals(o) && data.getEntityType().equals(other.getData().getEntityType());
	}
}
