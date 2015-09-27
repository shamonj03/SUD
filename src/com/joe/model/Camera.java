package com.joe.model;

public class Camera {

	private Location location = new Location(0, 0);

	private int width;

	private int height;

	public Camera(int width, int height, Location location) {
		this.width = width;
		this.height = height;
		this.location.set(location);
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Location getLocation() {
		return location;
	}

}
