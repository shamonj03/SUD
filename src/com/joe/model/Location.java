package com.joe.model;

public class Location {

	private static final double SQRT_TWO = Math.sqrt(2);

	private int x;

	private int y;

	public Location(int x, int y) {
		set(x, y);
	}

	public Location(Location other) {
		set(other);
	}

	public void offset(int xOff, int yOff) {
		this.x += xOff;
		this.y += yOff;
	}

	public void set(int x, int y) {
		setX(x);
		setY(y);
	}

	public void set(Location other) {
		set(other.getX(), other.getY());
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction directionOf(Location other) {
		int deltaY = getY() - other.getY();
		int deltaX = getX() - other.getX();

		if (deltaY < 0) {
			if (deltaX == 0) {
				return Direction.SOUTH;
			} else if (deltaX > 0) {
				return Direction.SOUTH_WEST;
			} else {
				return Direction.SOUTH_EAST;
			}
		} else if (deltaY > 0) {
			if (deltaX == 0) {
				return Direction.NORTH;
			} else if (deltaX > 0) {
				return Direction.NORTH_WEST;
			} else {
				return Direction.NORTH_EAST;
			}
		} else if (deltaY == 0) {
			if (deltaX < 0) {
				return Direction.EAST;
			} else if (deltaX > 0) {
				return Direction.WEST;
			} else {
				return Direction.NONE;
			}
		}
		return Direction.NONE;
	}

	public boolean withinDistance(Location other, int targetDistance) {
		int deltaX = getX() - other.getX();
		int deltaY = getY() - other.getY();

		return ((deltaX * deltaX) + (deltaY * deltaY)) <= (targetDistance * targetDistance);
	}
	
	public boolean withinDiagonalDistance(Location other, int targetDistance) {
		int deltaX = Math.abs(getX() - other.getX());
		int deltaY = Math.abs(getY() - other.getY());

		int min = Math.min(deltaX, deltaY);
		int max = Math.max(deltaX, deltaY);

		int diagonalSteps = min;
		int straightSteps = max - min;

		return (SQRT_TWO * diagonalSteps + straightSteps) <= (targetDistance * SQRT_TWO);
	}

	@Override public String toString() {
		return "Location(X: " + getX() + ", Y: " + getY() + ")";
	}

	public boolean equals(int x, int y) {
		return getX() == x && getY() == y;
	}

	@Override public boolean equals(Object o) {
		if (!(o instanceof Location)) {
			return false;
		}
		Location other = (Location) o;
		return getX() == other.getX() && getY() == other.getY();
	}
}
