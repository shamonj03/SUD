package com.joe.io.data;

public class NpcData {
	
	private String name = "Null Npc";
	
	private boolean friendly = true;
	
	private boolean solid = false;
	
	private char mapChar = 'N'; 
	
	
	public String getName() {
		return name;
	}
	
	public boolean isFriendly() {
		return friendly;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public char getMapChar() {
		return mapChar;
	}
	
	
	@Override public String toString() {
		return "NpcData(Name: " + name + ", MapChar: " + mapChar + ", Firendly: " + friendly + ", Solid: " + solid + ")";
	}

}
