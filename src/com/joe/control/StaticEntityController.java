package com.joe.control;

import com.joe.model.Entity;

public class StaticEntityController<E extends Entity<?>> extends BoundedMap<E> implements Controller<E> { 

	public StaticEntityController(int mapWidth, int mapHeight) {
		super(mapWidth, mapHeight);
	}

	@Override public void register(E entity) {
		set(entity.getLocation().getX(), entity.getLocation().getY(), entity);
	}

	@Override public void unregister(E entity) {
		set(entity.getLocation().getX(), entity.getLocation().getY(), null);
	}

	public boolean inBounds(E entity) {
		return inBounds(entity.getLocation().getX(), entity.getLocation().getY());
	}

	public E get(E entity) {
		return get(entity.getLocation().getX(), entity.getLocation().getY());
	}

}
