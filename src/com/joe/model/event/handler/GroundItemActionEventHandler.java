package com.joe.model.event.handler;

import com.joe.Game;
import com.joe.model.Direction;
import com.joe.model.Item;
import com.joe.model.Loot;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Player;
import com.joe.model.event.EventDispatcher;
import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.DespawnEntityEvent;
import com.joe.model.event.impl.GroundItemActionEvent;
import com.joe.model.event.impl.ObjectActionEvent;
import com.joe.model.event.impl.UnlockDoorEvent;
import com.joe.util.GameUtil;
import com.joe.util.Messages;
import com.joe.util.Util;

public class GroundItemActionEventHandler extends EventHandler<GroundItemActionEvent> {

	@Override public void handle(GroundItemActionEvent event) {
		Player player = Game.getPlayer();
		GroundItem item = event.getEntity();
		Zone zone = event.getZone();

		if (player.getData().getInventory().add(item.getItem())) {
			Util.streamMessageLn("You picked up: " + item.getItem().getName() + " x " + item.getItem().getAmount()
					+ ".");
			//Util.pressEnterToContinue();
			EventDispatcher.dispatch(new DespawnEntityEvent(zone, item));
		} else {
			Util.streamMessageLn("Your inventory is too full to pick this item up.");
			//Util.pressEnterToContinue();
		}
	}

}
