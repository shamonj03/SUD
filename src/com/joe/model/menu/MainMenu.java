package com.joe.model.menu;

import com.joe.Game;
import com.joe.io.definition.MenuDefinition;
import com.joe.model.Direction;
import com.joe.model.Menu;
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

	@Override public void handleOption(int index, int option) {
		Player player = Game.getPlayer();

		if (index < 5) {
			if (index == 1) {
				player.move(Direction.NORTH);
			} else if (index == 2) {
				player.move(Direction.SOUTH);
			} else if (index == 3) {
				player.move(Direction.EAST);
			} else if (index == 4) {
				player.move(Direction.WEST);
			}
			Game.getCamera().getLocation().set(player.getLocation());
		} else if (index == 5) {
			MenuDefinition.forId(1).displayMenu();
		} else if (index == 6) {
			MenuDefinition.forId(2).displayMenu();
		} else if (index == 7) {
			MenuDefinition.forId(3).displayMenu();
		}
	}
}
