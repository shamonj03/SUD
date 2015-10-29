package com.joe.control;

import java.util.function.Consumer;

import com.joe.model.Entity;

public class StackedEntityControler<E extends Entity<?>> extends BoundedMap<Stack<E>> implements Controller<E> {

	public StackedEntityControler(int width, int height) {
		super(width, height);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				set(x, y, new Stack<>());
			}
		}
	}

	@Override public void register(E e) {
		Stack<E> stack = get(e.getLocation().getX(), e.getLocation().getY());

		stack.register(e);
		set(e.getLocation().getX(), e.getLocation().getY(), stack);
	}

	@Override public void unregister(E e) {
		Stack<E> stack = get(e.getLocation().getX(), e.getLocation().getY());

		stack.unregister(e);
		set(e.getLocation().getX(), e.getLocation().getY(), stack);
	}

	public void iterateTiles(Consumer<E> c) {
		iterate(stack -> {
			for (E e : stack) {
				if (e == null) {
					return;
				}
				c.accept(e);
			}
		});
	}

	public void iterateTopTiles(Consumer<E> c) {
		iterate(stack -> {
			E t = stack.getTop();

			if (t == null) {
				return;
			}
			c.accept(t);
		});
	}
}
