package com.joe.io.definition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonStreamParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.joe.io.ItemData;
import com.joe.io.NpcData;

public class NpcDefinition {

	private static HashMap<Integer, NpcData> dataMap = new HashMap<>();

	public static void load() {
		try {
			File file = new File("./data/npcs.json");

			Gson g = new Gson();

			JsonStreamParser parser = new JsonStreamParser(new FileReader(file));
			while (parser.hasNext()) {
				NpcData data = g.fromJson(parser.next(), NpcData.class);
				dataMap.put(data.getId(), data);
			}

		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static NpcData forId(int id) {
		return dataMap.get(id);
	}
}
