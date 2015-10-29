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
	
	public StarterZone(int id) {
		super(id);
	}

}
