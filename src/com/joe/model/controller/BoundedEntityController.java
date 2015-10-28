package com.joe.model.controller;

import java.util.Iterator;

import com.joe.model.Controller;
import com.joe.model.Entity;
import com.joe.model.entity.GameObject;

public class BoundedEntityController<T extends Entity<?>> extends BoundedMap<T> implements Controller<T> { 

	public BoundedEntityController(int mapWidth, int mapHeight) {
		super(mapWidth, mapHeight);
	}

	@Override public void register(T entity) {
		set(entity.getLocation().getX(), entity.getLocation().getY(), entity);
	}

	@Override public void unregister(T entity) {
		set(entity.getLocation().getX(), entity.getLocation().getY(), null);
	}

	public boolean inBounds(T entity) {
		return inBounds(entity.getLocation().getX(), entity.getLocation().getY());
	}

	public T get(T entity) {
		return get(entity.getLocation().getX(), entity.getLocation().getY());
	}

}
