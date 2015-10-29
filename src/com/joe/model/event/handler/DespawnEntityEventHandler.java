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
import com.joe.model.event.impl.DespawnEntityEvent;

public class DespawnEntityEventHandler extends EventHandler<DespawnEntityEvent> {

	@Override public void handle(DespawnEntityEvent event) {
		EntityType type = event.getEntity().getData().getEntityType();
	
		Zone zone = event.getZone();
		
		if(type == EntityType.ITEM) {
			zone.getGroundItemController().unregister((GroundItem) event.getEntity());
		} else if(type == EntityType.OBJECT) {
			zone.getGameObjectController().unregister((GameObject) event.getEntity());
		} else if(type == EntityType.NPC) {
			zone.getNpcController().unregister((Npc) event.getEntity());
		}
		
		Player player = Game.getPlayer();
		
		if(zone == player.getZone()) {
			zone.printVisibleZone();
		}
	}

}