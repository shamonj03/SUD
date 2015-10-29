package com.joe.model.event;

import java.util.HashMap;

import com.joe.model.event.handler.DespawnEntityEventHandler;
import com.joe.model.event.handler.EquipEventHandler;
import com.joe.model.event.handler.GroundItemActionEventHandler;
import com.joe.model.event.handler.MoveEventHandler;
import com.joe.model.event.handler.NpcActionEventHandler;
import com.joe.model.event.handler.ObjectActionEventHandler;
import com.joe.model.event.handler.SpawnEntityEventHandler;
import com.joe.model.event.handler.UnlockDoorEventHandler;
import com.joe.model.event.impl.DespawnEntityEvent;
import com.joe.model.event.impl.EquipEvent;
import com.joe.model.event.impl.GroundItemActionEvent;
import com.joe.model.event.impl.MoveEvent;
import com.joe.model.event.impl.NpcActionEvent;
import com.joe.model.event.impl.ObjectActionEvent;
import com.joe.model.event.impl.SpawnEntityEvent;
import com.joe.model.event.impl.UnlockDoorEvent;

public class EventDispatcher {

	private static final HashMap<Class<? extends Event>, EventHandler<? extends Event>> handlers = new HashMap<>();

	static {
		register(EquipEvent.class, new EquipEventHandler());
		register(MoveEvent.class, new MoveEventHandler());
		register(UnlockDoorEvent.class, new UnlockDoorEventHandler());
		register(SpawnEntityEvent.class, new SpawnEntityEventHandler());
		register(DespawnEntityEvent.class, new DespawnEntityEventHandler());
		register(ObjectActionEvent.class, new ObjectActionEventHandler());
		register(GroundItemActionEvent.class, new GroundItemActionEventHandler());
		register(NpcActionEvent.class, new NpcActionEventHandler());
	}

	@SuppressWarnings("unchecked") public static <T extends Event> void dispatch(T event) {
		EventHandler<T> handler = (EventHandler<T>) handlers.get(event.getClass());

		if (handler == null) { // Unhandled event
			return;
		}
		handler.handle(event);
	}

	private static void register(Class<? extends Event> c, EventHandler<? extends Event> h) {
		handlers.put(c, h);
	}
}
