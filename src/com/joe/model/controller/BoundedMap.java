package com.joe.model.controller;

import java.util.function.Consumer;

public abstract class BoundedMap<E> {

	private int width;
	private int height;

	private E[][] map;

	public BoundedMap(int width, int height) {
		setBounds(width, height);
	}

	public BoundedMap() {
	}

	@SuppressWarnings("unchecked") public void reset() {
		this.map = (E[][]) new Object[height][width];
	}

	@SuppressWarnings("unchecked") public void setBounds(int width, int height) {
		this.width = width;
		this.height = height;
		this.map = (E[][]) new Object[height][width];
	}

	public boolean inBounds(int x, int y) {
		return (y >= 0 && y < map.length) && (x >= 0 && x < map[y].length);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public E get(int x, int y) {
		if (!inBounds(x, y)) {
			throw new IndexOutOfBoundsException();
		}
		return map[y][x];
	}

	public void set(int x, int y, E t) {
		if (!inBounds(x, y)) {
			throw new IndexOutOfBoundsException();
		}
		map[y][x] = t;
	}

	public void iterate(Consumer<E> c) {
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				E e = get(x, y);
				if (e == null) {
					continue;
				}
				c.accept(e);
			}
		}
	}
}
