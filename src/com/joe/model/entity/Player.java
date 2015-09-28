package com.joe.model.entity;

import com.joe.Game;
import com.joe.io.definition.ZoneDefinition;
import com.joe.model.EntityType;
import com.joe.model.Equipment;
import com.joe.model.Inventory;
import com.joe.model.Item;
import com.joe.model.ItemType;
import com.joe.model.Zone;

public class Player extends Character {

	private Inventory inventory = new Inventory();

	private Equipment equipment = new Equipment();

	private Zone zone = ZoneDefinition.forId(0);

	public Player() {
		location.set(2, 3);
		zone.register(this);
	}

	public boolean equip(Item item) {
		Player player = Game.getPlayer();

		if (item.getData().getType() != ItemType.EQUIPABLE) {
			return false;
		}
		if (player.getEquipment().add(item)) {
			player.getInventory().remove(item);
			System.out.println("You equip the " + item.getData().getName()
					+ ".");
		} else {
			System.out.println("Your inventory is too full to equip the "
					+ item.getData().getName() + ".");
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

	public Inventory getInventory() {
		return inventory;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public Zone getZone() {
		return zone;
	}
}
