package com.joe.io.definition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonStreamParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.joe.io.ItemData;

public class ItemDefinition {

	private static HashMap<Integer, ItemData> dataMap = new HashMap<>();

	public static void load() {
		try {
			File file = new File("./data/items.json");

			Gson g = new Gson();

			JsonStreamParser parser = new JsonStreamParser(new FileReader(file));
			while (parser.hasNext()) {
				ItemData data = g.fromJson(parser.next(), ItemData.class);
				dataMap.put(data.getId(), data);
			}
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ItemData forId(int id) {
		return dataMap.get(id);
	}
}
