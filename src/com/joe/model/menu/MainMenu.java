package com.joe.model.menu;

import java.util.ArrayList;

import com.joe.Game;
import com.joe.io.definition.MenuDefinition;
import com.joe.model.Direction;
import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Menu;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;

public class MainMenu extends Menu {

	private ArrayList<Entity> entities;

	public MainMenu() {
		super("What would you like to do?");
	}

	@Override public void populateMenu() {
		Player player = Game.getPlayer();

		addItem("North");
		addItem("South");
		addItem("East");
		addItem("West");
		addItem("Open Inventory");
		
		entities = player.getZone().getEntitiesInReach();
		for (Entity entity : entities) {

			if (entity.getType() == EntityType.OBJECT) {
				GameObject object = (GameObject) entity;

				if (!object.getData().isInteractable()) {
					continue;
				}
			}
			addItem("Interact with " + entity.getType() + ": "
					+ entity.getName() + ", Dir: "
					+ player.getLocation().directionOf(entity.getLocation()));
		}
	}

	@Override public void handleOption(int option) {
		Player player = Game.getPlayer();

		if (option < 5) {
			if (option == 1) {
				player.move(Direction.NORTH);
			} else if (option == 2) {
				player.move(Direction.SOUTH);
			} else if (option == 3) {
				player.move(Direction.EAST);
			} else if (option == 4) {
				player.move(Direction.WEST);
			}
			Game.getCamera().getLocation().set(player.getLocation());
		} else if(option == 5) {
			MenuDefinition.forId(1).displayMenu();
		} else {
			Entity entity = entities.get(option - 6);

			if (entity.getType() == EntityType.OBJECT) {
				player.getZone().handleObjectInteraction((GameObject) entity);
			} else if (entity.getType() == EntityType.NPC) {
				player.getZone().handleNpcInteraction((Npc) entity);
			} else if (entity.getType() == EntityType.ITEM) {
				player.getZone().handleGroundItemInteraction((GroundItem) entity);
			}
		}
	}
}
