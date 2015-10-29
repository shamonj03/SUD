package com.joe.model.event;

import java.util.HashMap;

import com.joe.model.event.handler.DespawnEntityEventHandler;
import com.joe.model.event.handler.EquipEventHandler;
import com.joe.model.event.handler.MoveEventHandler;
import com.joe.model.event.handler.SpawnEntityEventHandler;
import com.joe.model.event.handler.UnlockDoorEventHandler;
import com.joe.model.event.impl.DespawnEntityEvent;
import com.joe.model.event.impl.EquipEvent;
import com.joe.model.event.impl.MoveEvent;
import com.joe.model.event.impl.SpawnEntityEvent;
import com.joe.model.event.impl.UnlockDoorEvent;

public class EventDispatcher {

	private static final HashMap<Class<? extends Event>, EventHandler<? extends Event>> handlers = new HashMap<>();

	static {
		handlers.put(EquipEvent.class, new EquipEventHandler());
		handlers.put(MoveEvent.class, new MoveEventHandler());
		handlers.put(UnlockDoorEvent.class, new UnlockDoorEventHandler());
		handlers.put(SpawnEntityEvent.class, new SpawnEntityEventHandler());
		handlers.put(DespawnEntityEvent.class, new DespawnEntityEventHandler());
	}

	@SuppressWarnings("unchecked") public static <T extends Event> void dispatch(T event) {
		EventHandler<T> handler = (EventHandler<T>) handlers.get(event.getClass());

		if (handler == null) { // Unhandled event
			return;
		}
		handler.handle(event);
	}

}
