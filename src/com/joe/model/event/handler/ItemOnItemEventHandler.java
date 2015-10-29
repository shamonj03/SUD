package com.joe.model.event.handler;

import com.joe.model.event.EventHandler;
import com.joe.model.event.impl.ItemOnItemEvent;
import com.joe.util.Util;

public class ItemOnItemEventHandler extends EventHandler<ItemOnItemEvent> {

	@Override public void handle(ItemOnItemEvent event) {
		Util.streamMessageLn("You use the " + event.getFocus().getName() + " on the "
				+ event.getTarget().getName() + "....");

		Util.streamMessageLn("Nothing interesting happens.");
	}

}
