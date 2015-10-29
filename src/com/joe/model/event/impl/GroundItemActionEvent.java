package com.joe.model.event.impl;

import com.joe.model.entity.GroundItem;
import com.joe.model.event.Event;

public class GroundItemActionEvent extends EntityEvent<GroundItem> {

	public GroundItemActionEvent(int zoneId, GroundItem entity) {
		super(zoneId, entity);
	}

}
