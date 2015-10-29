package com.joe.model.menu;

import java.util.ArrayList;

import com.joe.Game;
import com.joe.model.Entity;
import com.joe.model.Menu;
import com.joe.model.entity.EntityType;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.model.event.EventDispatcher;
import com.joe.model.event.impl.GroundItemActionEvent;
import com.joe.model.event.impl.NpcActionEvent;
import com.joe.model.event.impl.ObjectActionEvent;

public class EntityMenu extends Menu {

	private ArrayList<Entity<?>> entities;

	public EntityMenu() {
		super("Interact with nearby entites.");
	}

	@Override public void populateMenu() {
		Player player = Game.getPlayer();

		entities = player.getZone().getEntitiesInReach(entity -> {
			if (entity.getData().getEntityType() == EntityType.OBJECT) {
				GameObject object = (GameObject) entity;

				return object.getData().isInteractable();
			}
			return true;
		});

		for (Entity<?> entity : entities) {

			if (entity.getData().getEntityType() == EntityType.OBJECT) {
				GameObject object = (GameObject) entity;

				if (!object.getData().isInteractable()) {
					continue;
				}
			}

			String dir = player.getLocation().directionOf(entity.getLocation())
					.getName();
			String type = entity.getData().getEntityType().getName();
			String text = entity.getData().getName();

			addItem("Interact with " + type + " to the " + dir + ": " + text
					+ ".");
		}

		addItem("Back");
	}

	@Override public void handleOption(int index, int option) {
		Player player = Game.getPlayer();

		if ((index - 1) < entities.size()) {
			Entity<?> entity = entities.get(index - 1);

			if (entity.getData().getEntityType() == EntityType.OBJECT) {
				EventDispatcher.dispatch(new ObjectActionEvent(player.getZoneId(), (GameObject) entity));
			} else if (entity.getData().getEntityType() == EntityType.NPC) {
				EventDispatcher.dispatch(new NpcActionEvent(player.getZoneId(), (Npc) entity));
			} else if (entity.getData().getEntityType() == EntityType.ITEM) {
				EventDispatcher.dispatch(new GroundItemActionEvent(player.getZoneId(), (GroundItem) entity));
			}
		}

		if (index != size()) {
			displayMenu();
		}
	}

}
