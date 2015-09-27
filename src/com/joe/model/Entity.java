package com.joe.model;

public abstract class Entity {

	protected String name;
	
	protected Location location = new Location(0, 0);
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public abstract EntityType getType();

	@Override public String toString() {
		return "Entity(Name: " + name + ", Type: " + getType() + ", Location: " + location + ")";
	}

	@Override public boolean equals(Object o) {
		if (!(o instanceof Entity)) {
			return false;
		}
		Entity other = (Entity) o;
		return getLocation().equals(other.getLocation())
				&& getType() == other.getType();
	}
}
