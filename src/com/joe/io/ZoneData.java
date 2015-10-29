package com.joe.io;

import java.util.ArrayList;

import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;

public class ZoneData {

	private int id;
	
	private String name;
	
	private int[][] objects;

	private ArrayList<GroundItem> items;
	
	private ArrayList<Npc> npcs;
	
	public String getName() {
		return name;
	}
	
	public ArrayList<GroundItem> getItems() {
		return items;
	}
	
	public ArrayList<Npc> getNpcs() {
		return npcs;
	}
	
	public int[][] getObjects() {
		return objects;
	}
	
	public int getId() {
		return id;
	}
	
}
