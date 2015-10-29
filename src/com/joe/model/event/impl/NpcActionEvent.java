package com.joe.model.event.impl;

import com.joe.model.entity.Npc;

public class NpcActionEvent extends EntityEvent<Npc> {

	public NpcActionEvent(int zoneId, Npc entity) {
		super(zoneId, entity);
	}

}
