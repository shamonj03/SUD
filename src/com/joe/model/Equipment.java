package com.joe.model;

import com.joe.Game;
import com.joe.model.entity.Player;

public class Equipment {

	private static final int MAX_SLOTS = 8;

	private Item[] items = new Item[MAX_SLOTS];

	public boolean setSlot(Item item) {
		int slot = item.getData().getSlotNumber();

		Item slottedItem = items[slot];

		if (slottedItem != null) {
			Player player = Game.getPlayer();

			if (!player.getInventory().add(slottedItem)) {
				return false;
			}
		}
		items[slot] = item;
		return true;
	}
}
