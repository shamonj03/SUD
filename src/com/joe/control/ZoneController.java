package com.joe.control;

import java.util.HashMap;

import com.joe.model.Zone;

public class ZoneController {

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
