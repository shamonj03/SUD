package com.joe.model.controller;

import java.util.Iterator;
import java.util.function.Consumer;

import com.joe.model.Entity;
import com.joe.model.Controller;
import com.joe.model.entity.GameObject;

public abstract class BoundedMap<T> {

	private T[][] map;

	public BoundedMap(int width, int height) {
		setBounds(width, height);
	}

	@SuppressWarnings("unchecked") public void setBounds(int width, int height) {
		this.map = (T[][]) new Object[height][width];
	}

	public boolean inBounds(int x, int y) {
		return (y >= 0 && y < map.length) && (x >= 0 && x < map[y].length);
	}
	
	public int getWidth() {
		return map[0].length;
	}
	
	public int getHeight() {
		return map.length;
	}

	public T get(int x, int y) {
		if (!inBounds(x, y)) {
			throw new IndexOutOfBoundsException();
		}
		return map[y][x];
	}

	public void set(int x, int y, T t) {
		if (!inBounds(x, y)) {
			throw new IndexOutOfBoundsException();
		}
		map[y][x] = t;
	}

	public void iterate(Consumer<T> c) {
		for(int y = 0; y <  getHeight(); y++) {
			for(int x = 0; x < getWidth(); x++) {
				T t = get(x, y);
				if(t == null) {
					continue;
				}
				c.accept(t);
			}
		}
	}
}