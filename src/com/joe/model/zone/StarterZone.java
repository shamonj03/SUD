package com.joe.model.zone;

import com.joe.model.Item;
import com.joe.model.Location;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.util.Messages;

public class StarterZone extends Zone {

	private static final int[][] tileMap = {
			{ 1, 1, 1, 1, 1, 1, 1 },

			{ 1, 0, 0, 0, 0, 0, 1 },

			{ 1, 0, 0, 0, 0, 0, 1 },

			{ 1, 0, 0, 0, 0, 0, 1 },

			{ 1, 0, 0, 0, 0, 0, 1 },

			{ 1, 0, 0, 0, 0, 0, 2 },

			{ 1, 1, 1, 1, 1, 1, 1 } };
	
	

	@Override public void initialize() {
		Npc test = new Npc(0, new Location(3, 3));
		register(test);
		
		GroundItem sword = new GroundItem(new Item(1, 1), new Location(1, 1));
		register(sword);
	}

	@Override public void handleObjectInteraction(GameObject object) {
		System.out.println(object);
	}
	
	@Override public void handleNpcInteraction(Npc npc) {
		switch(npc.getId()) {
			case 0:
				Messages.hintMessageGuide();
				break;
		}
	}

	
	@Override public int[][] getDefaultObjectMap() {
		return tileMap;
	}
}
