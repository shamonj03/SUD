package com.joe.model.entity;

import com.joe.io.PlayerData;
import com.joe.model.Entity;
import com.joe.model.Item;
import com.joe.model.item.ItemContainer;
import com.joe.util.Util;

public class Player extends Entity<PlayerData> {

	private PlayerData data;

	public void initialize() {
		data = new PlayerData();
		setZone(0);
		getLocation().set(2, 3);
	}

	public boolean addItemToInv(Item item) {
		ItemContainer inventory = data.getInventory();

		if (!inventory.add(item)) {
			getZone().getGroundItemController().register(new GroundItem(item, getLocation()));
			Util.streamMessageLn("Your inventory is too full. The item is placed on the ground.");
			//Util.pressEnterToContinue();
			return false;
		}
		return true;
	}

	@Override public PlayerData getData() {
		return data;
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
