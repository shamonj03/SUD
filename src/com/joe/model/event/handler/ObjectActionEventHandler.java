package com.joe.model.event.handler;

import com.joe.Game;
import com.joe.model.Direction;
import com.joe.model.Item;
import com.joe.model.Loot;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.Player;
import com.joe.model.event.EventDispatcher;
import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.ObjectActionEvent;
import com.joe.model.event.impl.UnlockDoorEvent;
import com.joe.util.GameUtil;
import com.joe.util.Messages;
import com.joe.util.Util;

public class ObjectActionEventHandler extends EventHandler<ObjectActionEvent> {

	private static final Loot[][] POT_LOOT = { { new Loot(1, 3, 75) } };

	@Override public void handle(ObjectActionEvent event) {
		Player player = Game.getPlayer();
		GameObject object = event.getEntity();
		Zone zone = event.getZone();

		switch (zone.getId()) {
			case STARTER_ZONE:
				switch (object.getId()) {
					case 2: // Locked Door
						EventDispatcher.dispatch(new UnlockDoorEvent(object, Direction.WEST, 4));
						break;

					case 4: // Pot

						if (object.getLocation().equals(10, 1)) {
							GameUtil.customBreakPot(object, p -> {
								if (!player.getData().getInventory().contains(4)) {
									Item key = new Item(4, 1);
									player.addItemToInv(key);

									Util.streamMessageLn("You find a key, this could be useful");
								}
							});
						} else {
							GameUtil.breakPot(POT_LOOT, object);
						}
						break;
				}
				break;

			default:
				Messages.nothingInterestingHappens();
				break;
		}
	}

	private static final int STARTER_ZONE = 0;
}
