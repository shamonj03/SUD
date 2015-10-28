package com.joe.model;

public interface Controller<E> {

	public void register(E e);

	public void unregister(E e);

}
