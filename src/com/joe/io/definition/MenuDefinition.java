package com.joe.io.definition;

import java.util.HashMap;

import com.joe.model.Menu;
import com.joe.model.menu.EntityMenu;
import com.joe.model.menu.EquipmentMenu;
import com.joe.model.menu.InventoryMenu;
import com.joe.model.menu.MainMenu;

public class MenuDefinition {

	private static HashMap<Integer, Menu> menuMap = new HashMap<>();

	public static void load() {
		menuMap.put(0, new MainMenu());
		menuMap.put(1, new InventoryMenu());
		menuMap.put(2, new EquipmentMenu());
		menuMap.put(3, new EntityMenu());
	}

	public static Menu forId(int id) {
		return menuMap.get(id);
	}
}
