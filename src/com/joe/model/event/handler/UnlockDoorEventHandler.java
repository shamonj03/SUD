package com.joe.model.event.handler;

import com.joe.Game;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.Player;
import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.UnlockDoorEvent;
import com.joe.model.item.ItemContainer;
import com.joe.util.Util;

public class UnlockDoorEventHandler extends EventHandler<UnlockDoorEvent> {
	
	private static final int UNLOCKED_DOOR = 3;

	@Override public void handle(UnlockDoorEvent event) {
		Player player = Game.getPlayer();
		ItemContainer inventory = player.getData().getInventory();

		GameObject door = event.getObject();
		
		int x = door.getLocation().getX() + event.getDirection().getXOffset();
		int y = door.getLocation().getY() + event.getDirection().getYOffset();
		
		if (player.getLocation().equals(x, y)) {
			if (inventory.contains(event.getKeyId(), 1)) {
				inventory.remove(event.getKeyId(), 1);
				door.setId(UNLOCKED_DOOR);

				Game.redrawZone();
				Util.streamMessageLn("You unlock the door.");
				//Util.pressEnterToContinue();
			} else {
				Util.streamMessageLn("Looks like you need a key to unlock this door.");
				//Util.pressEnterToContinue();
			}
		}
	}

}
