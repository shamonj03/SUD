package com.joe.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory implements Iterable<Item> {
	
	private static final int MAX_SLOTS = 28;

	private ArrayList<Item> inventory = new ArrayList<>();
	
	public boolean add(int id, int amount) {
		Item item = new Item(id, amount);
		
		if(item.getData().isStackable()) {
			int slot = getSlotForItem(id);
			
			if(slot == -1) {
				if((inventory.size() + 1) >= MAX_SLOTS) { // Inventory too large.
					return false;
				}
				inventory.add(item);
			} else {
				Item stackable = inventory.get(slot);
				stackable.setAmount(stackable.getAmount() + item.getAmount());
			}
		} else {
			if((inventory.size() + amount) >= MAX_SLOTS) { // Inventory too large.
				return false;
			}
			for(int i = 0; i < amount; i++) {
				inventory.add(new Item(id, 1));
			}
		}
		return true;
	}
	
	public void remove(int id, int amount) {
		int slot = getSlotForItem(id);
		
		if(slot == -1) {
			return;
		}

		Item item = new Item(id, amount);
		
		if(item.getData().isStackable()) {
			Item stackable = inventory.get(slot);
			int newAmount = stackable.getAmount() - item.getAmount();
			
			if(newAmount <= 0) {
				inventory.remove(stackable);
			} else {
				stackable.setAmount(newAmount);
			}
		} else {
			for(int i = 0; i < amount; i++) {
				inventory.remove(new Item(id, 1));
			}
		}
	}
	
	public boolean add(Item item) {
		return add(item.getId(), item.getAmount());
	}
	
	public void remove(Item item) {
		remove(item.getId(), item.getAmount());
	}
	
	public Item getItem(int slot) {
		return inventory.get(slot);
	}
	
	public ArrayList<Item> getItems() {
		return inventory;
	}
	
	public int getSlotForItem(int id) {
		for(int slot = 0; slot < inventory.size(); slot++) {
			Item item = inventory.get(slot);
			if(item.getId() == id) {
				return slot;
			}
		}
		return -1;
	}
	
	public int getSize() {
		return inventory.size();
	}

	@Override public Iterator<Item> iterator() {
		return inventory.iterator();
	}
}
