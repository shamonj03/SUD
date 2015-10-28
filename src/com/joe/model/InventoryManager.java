package com.joe.model;

import com.joe.util.Util;

public class InventoryManager {

	public static void consume(@SuppressWarnings("unused") Item item) {

	}

	public static void usItemOnItem(Item focus, Item target) {
		Util.streamMessageLn("You use the " + focus.getName() + " on the "
				+ target.getName() + "....");

		Util.streamMessageLn("Nothing interesting happens.");
		///Util.pressEnterToContinue();
	}
}
