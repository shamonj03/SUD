package com.joe.model.zone;

import com.joe.Game;
import com.joe.model.Direction;
import com.joe.model.Item;
import com.joe.model.Location;
import com.joe.model.Loot;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.model.event.EventDispatcher;
import com.joe.model.event.impl.SpawnEntityEvent;
import com.joe.model.event.impl.UnlockDoorEvent;
import com.joe.util.GameUtil;
import com.joe.util.Messages;
import com.joe.util.Util;

public class StarterZone extends Zone {

	private static final int[][] tileMap = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },

		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 1 },

		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1 },

		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },

		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },

		{ 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 2 },

		{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	
	public StarterZone(int id) {
		super(id);
	}

	@Override public void initialize() {
		EventDispatcher.dispatch(new SpawnEntityEvent(this, new Npc(0, new Location(3, 3))));
		EventDispatcher.dispatch(new SpawnEntityEvent(this, new GroundItem(new Item(0, 1), new Location(1, 1))));
	}

	@Override public int[][] getDefaultObjectMap() {
		return tileMap;
	}
}
