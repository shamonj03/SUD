package com.joe.model.menu;

import com.joe.Game;
import com.joe.io.definition.MenuDefinition;
import com.joe.model.Inventory;
import com.joe.model.Item;
import com.joe.model.ItemType;
import com.joe.model.Menu;
import com.joe.model.entity.Player;
import com.joe.util.Messages;
import com.joe.util.Util;

public class InventoryMenu extends Menu {

	public InventoryMenu() {
		super("Inventory");
	}

	private void handleItem(Item item) {
		Player player = Game.getPlayer();

		if (!player.equip(item)) {
			System.out.println(item.getData().getExamine());
		}
	}

	@Override public void populateMenu() {
		Player player = Game.getPlayer();
		Inventory inventory = player.getInventory();

		for (Item item : inventory) {
			ItemType type = item.getData().getType();

			addItem(type.getMenuOption() + " " + item.getData().getName()
					+ " x " + item.getAmount());
		}

		addItem("Exit");
	}

	@Override public void handleOption(int option) {
		Player player = Game.getPlayer();
		Inventory inventory = player.getInventory();

		if (option <= inventory.getSize()) {
			Item item = inventory.getItem(option - 1);

			handleItem(item);
			Util.pressEnterToContinue();

			displayMenu();
		}
	}
}
