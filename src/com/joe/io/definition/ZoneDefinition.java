package com.joe.io.definition;

import java.util.HashMap;

import com.joe.model.Zone;
import com.joe.model.zone.StarterZone;

public class ZoneDefinition {

	private static HashMap<Integer, Zone> zoneMap = new HashMap<>();

	public static void load() {
		zoneMap.put(0, new StarterZone());
	}

	public static Zone forId(int id) {
		return zoneMap.get(id);
	}
}
