package com.joe.model.event.impl;

import com.joe.model.entity.GroundItem;

public class GroundItemActionEvent extends EntityEvent<GroundItem> {

	public GroundItemActionEvent(int zoneId, GroundItem entity) {
		super(zoneId, entity);
	}

}
