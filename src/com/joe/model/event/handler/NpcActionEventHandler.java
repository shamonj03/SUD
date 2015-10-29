package com.joe.model.event.handler;

import com.joe.Game;
import com.joe.model.Direction;
import com.joe.model.Item;
import com.joe.model.Loot;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.model.event.EventDispatcher;
import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.NpcActionEvent;
import com.joe.model.event.impl.ObjectActionEvent;
import com.joe.model.event.impl.UnlockDoorEvent;
import com.joe.util.GameUtil;
import com.joe.util.Messages;
import com.joe.util.Util;

public class NpcActionEventHandler extends EventHandler<NpcActionEvent> {

	@Override public void handle(NpcActionEvent event) {
		Player player = Game.getPlayer();
		Npc npc = event.getEntity();
		Zone zone = event.getZone();

		switch (zone.getId()) {
			case STARTER_ZONE:
				switch (npc.getId()) {
					case 0:
						Messages.hintMessageGuide();
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
