package com.joe.model.menu;

import com.joe.Game;
import com.joe.GameFrame;
import com.joe.model.InventoryManager;
import com.joe.model.Item;
import com.joe.model.ItemContainer;
import com.joe.model.ItemType;
import com.joe.model.Menu;
import com.joe.model.entity.Player;
import com.joe.util.Util;

public class InventoryMenu extends Menu {

	public InventoryMenu() {
		super("Inventory");
	}

	@Override public void populateMenu() {
		Player player = Game.getPlayer();
		ItemContainer inventory = player.getData().getInventory();

		for (Item item : inventory) {
			addItem(item.getData().getName() + " x " + item.getAmount(), item
					.getData().getActions());

		}
		addItem("Back");
	}

	@Override public void handleOption(int index, int option) {
		Player player = Game.getPlayer();
		ItemContainer inventory = player.getData().getInventory();

		if ((index - 1) < inventory.getSize()) {
			Item item = inventory.getItem(index - 1);

			String[] actions = item.getData().getActions();

			if (actions[option].equalsIgnoreCase("equip")
					&& item.getData().getType() == ItemType.EQUIPABLE) {
				player.equip(item);
			} else if ((actions[option].equalsIgnoreCase("drink") || actions[option]
					.equalsIgnoreCase("eat"))
					&& item.getData().getType() == ItemType.CONSUMABLE) {
				InventoryManager.consume(item);
			} else if (actions[option].equalsIgnoreCase("use")) {
				GameFrame.getConsole().print("Choose another item slot: ");
				int slot = GameFrame.getInput().getInt();

				if ((slot - 1) == (index - 1)) {
					Util.streamMessageLn("Nothing interesting happens.");
					//Util.pressEnterToContinue();
					displayMenu();
					return;
				}
				Item otherItem = inventory.getItem(slot - 1);
				InventoryManager.usItemOnItem(item, otherItem);
			} else {
				Util.streamMessageLn(item.getData().getExamine());
				//Util.pressEnterToContinue();
			}
		}

		if (index != size()) {
			displayMenu();
		}
	}
}
