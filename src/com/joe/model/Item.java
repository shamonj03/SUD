package com.joe.model;

import com.joe.io.data.ItemData;
import com.joe.io.definition.ItemDefinition;

public class Item {

	private int id;
	
	private int amount;
	
	public Item(int id, int amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public String getName() {
		return getData().getName();
	}
	
	public ItemData getData() {
		return ItemDefinition.forId(id);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getId() {
		return id;
	}
	
	@Override public boolean equals(Object obj) {
		if(!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		return id == other.id && amount == other.amount;
	}
	
	@Override public String toString() {
		return "Item(ID: " + id + ", Amount: " + amount + ", Data: " + getData() + ")";
	}
}
