package com.joe.model;

import java.util.ArrayList;

import com.joe.util.Util;

public class EntityManager {

	private ArrayList<Entity> entityList = new ArrayList<>();

	public <T extends Entity> void register(T entity) {
		entityList.add(entity);
		Util.printlnDebug("Registered: " + entity);
	}

	public <T extends Entity> void unregister(T entity) {
		entityList.remove(entity);
		Util.printlnDebug("Unregistered: " + entity);
	}

	public ArrayList<Entity> getEntities() {
		return entityList;
	}
}
