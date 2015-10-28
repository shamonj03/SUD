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
import com.joe.io.ObjectData;

public class ObjectDefinition {

	private static HashMap<Integer, ObjectData> dataMap;

	public static void load() {
		try {
			File file = new File("./data/objects.json");

			Type type = new TypeToken<Map<Integer, ObjectData>>() { }.getType();
			dataMap = new Gson().fromJson(new FileReader(file), type);

		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ObjectData forId(int id) {
		return dataMap.get(id);
	}
}
