package com.joe.model.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.joe.model.Controller;

public class Stack<E> implements Controller<E>, Iterable<E> {

	private ArrayList<E> items = new ArrayList<>();

	@Override public void register(E e) {
		items.add(e);
	}

	@Override public void unregister(E e) {
		items.remove(e);
	}

	public E getTop() {
		return get(items.size() - 1);
	}

	public E getBottom() {
		return get(0);
	}

	public E get(int index) {
		if (items.isEmpty()) {
			return null;
		}
		return items.get(index);
	}

	@Override public Iterator<E> iterator() {
		return items.iterator();
	}
}