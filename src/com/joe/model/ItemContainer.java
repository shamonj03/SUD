package com.joe.model;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemContainer implements Iterable<Item> {

	private final int maxSlots;
	
	private final ArrayList<Item> items = new ArrayList<>();

	public ItemContainer(int maxSlots) {
		this.maxSlots = maxSlots;
	}
	
	public boolean add(Item item) {
		return add(item.getId(), item.getAmount());
	}
	
	public void remove(Item item) {
		remove(item.getId(), item.getAmount());
	}
	
	public Item getItem(int slot) {
		return items.get(slot);
	}
	
	public boolean add(int id, int amount) {
		Item item = new Item(id, amount);
		
		if(item.getData().isStackable()) {
			int slot = getSlotForItem(id);
			
			if(slot == -1) {
				if((items.size() + 1) >= maxSlots) { // Inventory too large.
					return false;
				}
				items.add(item);
			} else {
				Item stackable = items.get(slot);
				stackable.setAmount(stackable.getAmount() + item.getAmount());
			}
		} else {
			if((items.size() + amount) >= maxSlots) { // Inventory too large.
				return false;
			}
			for(int i = 0; i < amount; i++) {
				items.add(new Item(id, 1));
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
			Item stackable = items.get(slot);
			int newAmount = stackable.getAmount() - item.getAmount();
			
			if(newAmount <= 0) {
				items.remove(stackable);
			} else {
				stackable.setAmount(newAmount);
			}
		} else {
			for(int i = 0; i < amount; i++) {
				items.remove(new Item(id, 1));
			}
		}
	}
	
	public int getSlotForItem(int id) {
		for(int slot = 0; slot < items.size(); slot++) {
			Item item = items.get(slot);
			if(item.getId() == id) {
				return slot;
			}
		}
		return -1;
	}
	
	public boolean contains(int id, int amount) {
		for(Item item : items) {
			if(id == item.getId() && amount == item.getAmount()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int id) {
		for(Item item : items) {
			if(id == item.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public boolean contains(Item item) {
		return items.contains(item);
	}
	
	public int getSize() {
		return items.size();
	}

	public int getMaxSlots() {
		return maxSlots;
	}
	
	@Override public Iterator<Item> iterator() {
		return items.iterator();
	}
	
}
