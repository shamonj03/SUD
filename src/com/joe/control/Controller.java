package com.joe.control;

public interface Controller<E> {

	public void register(E e);

	public void unregister(E e);

}
