package com.joe.model.menu;

import com.joe.Game;
import com.joe.model.Equipment;
import com.joe.model.EquipmentSlot;
import com.joe.model.Item;
import com.joe.model.Menu;
import com.joe.model.entity.Player;

public class EquipmentMenu extends Menu {

	public EquipmentMenu() {
		super("Equipment");
	}

	@Override public void populateMenu() {
		Player player = Game.getPlayer();

		for (int slot = 0; slot < Equipment.MAX_SLOTS; slot++) {
			Item item = player.getEquipment().get(slot);
			
			if (item == null) {
				addItem(EquipmentSlot.forId(slot) + " - Empty");
			} else {
				addItem("Unequip " + item.getData().getSlot() + " - "
						+ item.getData().getName() + " x " + item.getAmount());
			}
		}
		addItem("Exit");
	}

	@Override public void handleOption(int option) {
		Player player = Game.getPlayer();
		
		if(option < Equipment.MAX_SLOTS) {
			player.getEquipment().remove(option - 1);
		}
	}

}
