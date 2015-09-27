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
import com.joe.io.data.NpcData;

public class NpcDefinition {
	
	private static HashMap<Integer, NpcData> dataMap;
	
	public static void load() {
		try {
			File file = new File("./data/npcs.json");

			Type type = new TypeToken<Map<Integer, NpcData>>() { }.getType();
			dataMap = new Gson().fromJson(new FileReader(file), type);
			
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static NpcData forId(int id) {
		return dataMap.get(id);
	}
}
