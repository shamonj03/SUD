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

	public MainMenu() {
		super("What would you like to do?");
	}

	@Override public void populateMenu() {
		addItem("Move North");
		addItem("Move South");
		addItem("Move East");
		addItem("Move West");
		addItem("Open Inventory");
		addItem("View Equipment");
		addItem("Interact With Entities");

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
		} else if (option == 5) {
			MenuDefinition.forId(1).displayMenu();
		} else if (option == 6) {
			MenuDefinition.forId(2).displayMenu();
		} else if (option == 7) {
			MenuDefinition.forId(3).displayMenu();
		}
	}
}
