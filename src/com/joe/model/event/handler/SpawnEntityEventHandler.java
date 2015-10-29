package com.joe.model.event.handler;

import com.joe.Game;
import com.joe.io.definition.ZoneDefinition;
import com.joe.model.EntityType;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.SpawnEntityEvent;

public class SpawnEntityEventHandler extends EventHandler<SpawnEntityEvent> {

	@Override public void handle(SpawnEntityEvent event) {
		EntityType type = event.getEntity().getData().getEntityType();

		Zone zone = event.getZone();
		event.getEntity().setZone(zone);

		if (type == EntityType.ITEM) {
			zone.getGroundItemController().register((GroundItem) event.getEntity());
		} else if (type == EntityType.OBJECT) {
			zone.getGameObjectController().register((GameObject) event.getEntity());
		} else if (type == EntityType.NPC) {
			zone.getNpcController().register((Npc) event.getEntity());
		}

		Player player = Game.getPlayer();
		if (zone == player.getZone()) {
			zone.printVisibleZone();
		}
	}

}