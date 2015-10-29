package com.joe.io;

import com.joe.model.entity.EntityType;

public interface EntityData extends Data {

	public String getName();

	public EntityType getEntityType();
}
