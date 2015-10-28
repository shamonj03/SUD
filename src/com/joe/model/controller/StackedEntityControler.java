package com.joe.model.controller;

import java.util.Iterator;
import java.util.function.Consumer;

import com.joe.model.Controller;
import com.joe.model.Entity;
import com.joe.model.entity.GroundItem;

public class StackedEntityControler<T extends Entity<?>> extends BoundedMap<Tile<T>> implements Controller<T> {

	public StackedEntityControler(int width, int height) {
		super(width, height);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				set(x, y, new Tile<>());
			}
		}
	}

	@Override public void register(T e) {
		Tile<T> tile = get(e.getLocation().getX(), e.getLocation().getY());

		tile.register(e);
		set(e.getLocation().getX(), e.getLocation().getY(), tile);
	}

	@Override public void unregister(T e) {
		Tile<T> tile = get(e.getLocation().getX(), e.getLocation().getY());

		tile.unregister(e);
		set(e.getLocation().getX(), e.getLocation().getY(), tile);
	}

	public void iterateTiles(Consumer<T> c) {
		iterate(tile -> {
			for (T t : tile) {
				if (t == null) {
					return;
				}
				c.accept(t);
			}
		});
	}

	public void iterateTopTiles(Consumer<T> c) {
		iterate(tile -> {
			T t = tile.getTop();

			if (t == null) {
				return;
			}
			c.accept(t);
		});
	}
}
