package com.joe.model;

import com.joe.util.Util;

public enum Direction {

	NORTH(0, -1), SOUTH(0, 1), EAST(1, 0), WEST(-1, 0), NORTH_EAST(1, 1), NORTH_WEST(-1, 1), SOUTH_EAST(1, -1), SOUTH_WEST(-1, -1), NONE(0, 0);

	private final int xOffset;
	private final int yOffset;

	private Direction(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public int getXOffset() {
		return xOffset;
	}

	public int getYOffset() {
		return yOffset;
	}

	public String getName() {
		return Util.capitalizeAllFirstLetters(name());
	}
}
