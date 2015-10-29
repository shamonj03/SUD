package com.joe.io.definition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonStreamParser;
import com.google.gson.JsonSyntaxException;
import com.joe.io.ZoneData;

public class ZoneDataDefinition {
	
	private static HashMap<Integer, ZoneData> dataMap = new HashMap<>();

	private static void load(int id) {
		try {
			File file = new File("./data/zones/"+id+".json");

			Gson g = new Gson();

			JsonStreamParser parser = new JsonStreamParser(new FileReader(file));
			while (parser.hasNext()) {
				ZoneData data = g.fromJson(parser.next(), ZoneData.class);
				dataMap.put(data.getId(), data);
			}
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ZoneData forId(int id) {
		if(!dataMap.containsKey(id)) {
			load(id);
		}
		return dataMap.get(id);
	}
}
