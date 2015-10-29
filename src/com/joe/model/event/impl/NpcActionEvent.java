package com.joe.model.event.impl;

import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.event.Event;

public class NpcActionEvent extends EntityEvent<Npc> {

	public NpcActionEvent(int zoneId, Npc entity) {
		super(zoneId, entity);
	}

}
