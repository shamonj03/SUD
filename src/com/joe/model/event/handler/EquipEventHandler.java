package com.joe.model.event.handler;

import com.joe.Game;
import com.joe.model.Equipment;
import com.joe.model.Item;
import com.joe.model.ItemContainer;
import com.joe.model.ItemType;
import com.joe.model.entity.Player;
import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.EquipEvent;
import com.joe.util.Util;

public class EquipEventHandler extends EventHandler<EquipEvent> {

	@Override public void handle(EquipEvent event) {
		Item item = event.getItem();
		Player player = Game.getPlayer();
		ItemContainer inventory = player.getData().getInventory();
		Equipment equipment = player.getData().getEquipment();

		if (item.getData().getType() != ItemType.EQUIPABLE) {
			return;
		}
		if (equipment.add(item)) {
			inventory.remove(item);
			Util.streamMessageLn("You equip the " + item.getData().getName() + ".");
			//Util.pressEnterToContinue();
		} else {
			Util.streamMessageLn("Your inventory is too full to equip the " + item.getData().getName() + ".");
			//Util.pressEnterToContinue();
		}
	}

}
