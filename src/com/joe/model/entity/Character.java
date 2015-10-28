package com.joe.model.entity;

import java.util.ArrayList;

import com.joe.Game;
import com.joe.io.EntityData;
import com.joe.model.Direction;
import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Zone;

public abstract class Character<T extends EntityData> extends Entity<T> {

	public void move(Direction direction) {
		getLocation().advance(direction);
		checkCollision(direction);
	}

	private void checkCollision(Direction direction) {
		Zone zone = Game.getPlayer().getData().getZone();

		ArrayList<Entity<?>> list = zone.getEntitiesInReach(e -> e.getData().getEntityType() == EntityType.OBJECT);

		for (Entity<?> entity : list) {
			GameObject object = (GameObject) entity;

			if (getLocation().equals(object.getLocation()) && object.getData().isSolid()) {
				getLocation().retreat(direction);
			}
		}
	}

}
