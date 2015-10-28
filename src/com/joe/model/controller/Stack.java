package com.joe.model.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.joe.model.Entity;
import com.joe.model.Controller;

public class Stack<T> implements Controller<T>, Iterable<T> {

	private ArrayList<T> items = new ArrayList<>();

	@Override public void register(T entity) {
		items.add(entity);
	}

	@Override public void unregister(T entity) {
		items.remove(entity);
	}
	
	public T getTop() {
		if(items.isEmpty()) {
			return null;
		}
		return items.get(items.size() - 1);
	}

	@Override public Iterator<T> iterator() {
		return items.iterator();
	}
}