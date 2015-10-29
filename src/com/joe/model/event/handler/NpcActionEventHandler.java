package com.joe.model.event.handler;

import com.joe.Game;
import com.joe.model.Zone;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.NpcActionEvent;
import com.joe.util.Messages;

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
