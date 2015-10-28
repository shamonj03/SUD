package com.joe.model;

import java.util.Arrays;
import java.util.Iterator;

import com.joe.Game;
import com.joe.model.entity.Player;

public class Equipment implements Iterable<Item> {

	public static final int MAX_SLOTS = 8;

	private Item[] items = new Item[MAX_SLOTS];

	public boolean add(Item item) {
		int slot = item.getData().getSlotNumber();

		Item slottedItem = items[slot];

		if (slottedItem != null) {
			Player player = Game.getPlayer();

			if (!player.getData().getInventory().add(slottedItem)) {
				return false;
			}
		}
		items[slot] = item;
		return true;
	}

	public boolean remove(int slot) {
		Item slottedItem = items[slot];

		if (slottedItem == null) {
			return false;
		}

		Player player = Game.getPlayer();
		if (!player.getData().getInventory().add(slottedItem)) {
			return false;
		}
		items[slot] = null;
		return true;
	}

	public Item get(int slot) {
		return items[slot];
	}

	@Override public Iterator<Item> iterator() {
		return Arrays.stream(items).iterator();
	}
}
