package com.joe.model.event.handler;

import java.util.ArrayList;

import com.joe.Game;
import com.joe.model.Direction;
import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.Player;
import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.MoveEvent;

public class MoveEventHandler extends EventHandler<MoveEvent> {

	@Override public void handle(MoveEvent event) {
		Entity<?> entity = event.getEntity();
		Direction direction = event.getDirection();
		
		entity.getLocation().advance(direction);
		checkCollision(entity, direction);
		
		Player player = Game.getPlayer();
		Zone zone = entity.getZone();
		if (zone == player.getZone()) {
			zone.printVisibleZone();
		}
	}

	private void checkCollision(Entity<?> entity, Direction direction) {
		Zone zone = Game.getPlayer().getZone();

		ArrayList<Entity<?>> list = zone.getEntitiesInReach(e -> e.getData().getEntityType() == EntityType.OBJECT);

		for (Entity<?> e : list) {
			GameObject object = (GameObject) e;

			if (entity.getLocation().equals(object.getLocation()) && object.getData().isSolid()) {
				entity.getLocation().retreat(direction);
			}
		}
	}

}
