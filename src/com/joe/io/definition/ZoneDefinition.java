package com.joe.io.definition;

import java.util.HashMap;

import com.joe.model.Zone;
import com.joe.model.zone.StarterZone;

public class ZoneDefinition {

	private static HashMap<Integer, Zone> zoneMap = new HashMap<>();

	public static Zone forId(int id) {
		if(!zoneMap.containsKey(id)) {
			Zone zone = new Zone(id);
			register(zone);
		}
		return zoneMap.get(id);
	}
	
	private static void register(Zone zone) {
		zoneMap.put(zone.getId(), zone);
		zone.registerEntities();
	}
}
