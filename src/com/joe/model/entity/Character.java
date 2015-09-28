package com.joe.model.entity;

import java.util.ArrayList;

import com.joe.Game;
import com.joe.model.Direction;
import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Zone;

public abstract class Character extends Entity {

	public void move(Direction direction) {
		getLocation().offset(direction.getXOffset(), direction.getYOffset());

		Zone zone = Game.getPlayer().getZone();

		ArrayList<Entity> list = zone.getEntitiesInReach(e -> {
			return e.getType() != EntityType.OBJECT;
		});

		for (Entity entity : list) {
			GameObject object = (GameObject) entity;

			if (getLocation().equals(object.getLocation())
					&& object.getData().isSolid()) {
				getLocation().offset(-1 * direction.getXOffset(),
						-1 * direction.getYOffset());
				return;
			}
		}
	}

	@Override public String toString() {
		return "Charcter(" + super.toString() + ")";
	}

	@Override public boolean equals(Object o) {
		if (!(o instanceof Character)) {
			return false;
		}
		Character other = (Character) o;
		return super.equals(other);
	}
}
