package com.joe.io.definition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonStreamParser;
import com.google.gson.JsonSyntaxException;
import com.joe.io.ObjectData;

public class ObjectDefinition {

	private static HashMap<Integer, ObjectData> dataMap = new HashMap<>();

	public static void load() {
		try {
			File file = new File("./data/objects.json");

			Gson g = new Gson();

			JsonStreamParser parser = new JsonStreamParser(new FileReader(file));
			while (parser.hasNext()) {
				ObjectData data = g.fromJson(parser.next(), ObjectData.class);
				dataMap.put(data.getId(), data);
			}
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ObjectData forId(int id) {
		return dataMap.get(id);
	}
}
