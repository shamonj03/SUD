package com.joe.model.menu;

import com.joe.Game;
import com.joe.model.Equipment;
import com.joe.model.EquipmentSlot;
import com.joe.model.Item;
import com.joe.model.Menu;
import com.joe.model.entity.Player;
import com.joe.util.Util;

public class EquipmentMenu extends Menu {

	public EquipmentMenu() {
		super("Equipment");
	}

	@Override public void populateMenu() {
		Player player = Game.getPlayer();

		for (int slot = 0; slot < Equipment.MAX_SLOTS; slot++) {
			Item item = player.getEquipment().get(slot);

			if (item == null) {
				addItem(EquipmentSlot.forId(slot).getName(), "Empty");
			} else {
				addItem(EquipmentSlot.forId(slot).getName(), "Unequip: "
						+ item.getData().getName() + " x " + item.getAmount());
			}
		}
		addItem("Back");
	}

	@Override public void handleOption(int index, int option) {
		Player player = Game.getPlayer();

		if ((index - 1) < Equipment.MAX_SLOTS) {
			Item item = player.getEquipment().get(index - 1);

			if (item == null) {
				displayMenu();
				return;
			}
			player.getEquipment().remove(index - 1);
			Util.streamMessageLn("You unequip the " + item.getData().getName()
					+ " x " + item.getAmount() + ".");
			Util.pressEnterToContinue();
		}

		if (index != size()) {
			displayMenu();
		}
	}

}
