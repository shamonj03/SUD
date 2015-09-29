package com.joe.model.entity;

import com.joe.Game;
import com.joe.io.definition.ZoneDefinition;
import com.joe.model.EntityType;
import com.joe.model.Equipment;
import com.joe.model.Item;
import com.joe.model.ItemContainer;
import com.joe.model.ItemType;
import com.joe.model.Zone;
import com.joe.util.Util;

public class Player extends Character {

	private ItemContainer inventory = new ItemContainer(28);

	private Equipment equipment = new Equipment();

	private Zone zone = ZoneDefinition.forId(0);

	public Player() {
		location.set(2, 3);
		zone.register(this);
	}

	public boolean addItemToInv(Item item) {
		if (!getInventory().add(item)) {
			zone.register(new GroundItem(item, getLocation()));
			Util.streamMessageLn("Your inventory is too full. The item is placed on the ground.");
			Util.pressEnterToContinue();
			return false;
		}
		return true;
	}

	public void consume(Item item) {
		
	}
	
	public boolean equip(Item item) {
		Player player = Game.getPlayer();

		if (item.getData().getType() != ItemType.EQUIPABLE) {
			return false;
		}
		if (player.getEquipment().add(item)) {
			player.getInventory().remove(item);
			Util.streamMessageLn("You equip the " + item.getData().getName()
					+ ".");
			Util.pressEnterToContinue();
		} else {
			Util.streamMessageLn("Your inventory is too full to equip the "
					+ item.getData().getName() + ".");
			Util.pressEnterToContinue();
		}
		return true;
	}

	public void setZone(int id) {
		if (zone != null) {
			zone.unregister(this);
		}
		zone = ZoneDefinition.forId(id);
		zone.register(this);
	}

	@Override public EntityType getType() {
		return EntityType.PLAYER;
	}

	@Override public String toString() {
		return "Player(" + super.toString() + ")";
	}

	@Override public boolean equals(Object o) {
		if (!(o instanceof Player)) {
			return false;
		}
		Player other = (Player) o;
		return super.equals(o) && getType().equals(other.getType());
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
}
