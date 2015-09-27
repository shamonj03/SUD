package com.joe.io.definition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.joe.io.data.ItemData;

public class ItemDefinition {
	
	private static HashMap<Integer, ItemData> dataMap;
	
	public static void load() {
		try {
			File file = new File("./data/items.json");

			Type type = new TypeToken<Map<Integer, ItemData>>() { }.getType();
			dataMap = new Gson().fromJson(new FileReader(file), type);
			
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ItemData forId(int id) {
		return dataMap.get(id);
	}
}
