package com.joe.model.menu;

import java.util.ArrayList;

import com.joe.Game;
import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Menu;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;

public class EntityMenu extends Menu {

	private ArrayList<Entity> entities;

	public EntityMenu() {
		super("Interact with nearby entites.");
	}

	@Override public void populateMenu() {
		Player player = Game.getPlayer();

		entities = player.getZone().getEntitiesInReach(entity -> {
			if (entity.getType() == EntityType.OBJECT) {
				GameObject object = (GameObject) entity;

				return !object.getData().isInteractable();
			}
			return false;
		});

		for (Entity entity : entities) {

			if (entity.getType() == EntityType.OBJECT) {
				GameObject object = (GameObject) entity;

				if (!object.getData().isInteractable()) {
					continue;
				}
			}

			String dir = player.getLocation().directionOf(entity.getLocation())
					.getName();
			String type = entity.getType().getName();
			String text = entity.getName();

			addItem("Interact with " + type + " to the " + dir + ": " + text
					+ ".");
		}

		addItem("Exit");
	}

	@Override public void handleOption(int option) {
		Player player = Game.getPlayer();

		if ((option - 1) < entities.size()) {
			Entity entity = entities.get(option - 1);

			if (entity.getType() == EntityType.OBJECT) {
				player.getZone().handleObjectInteraction((GameObject) entity);
			} else if (entity.getType() == EntityType.NPC) {
				player.getZone().handleNpcInteraction((Npc) entity);
			} else if (entity.getType() == EntityType.ITEM) {
				player.getZone().handleGroundItemInteraction(
						(GroundItem) entity);
			}
		}
	}

}
