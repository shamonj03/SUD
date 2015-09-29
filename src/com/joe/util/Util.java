package com.joe.util;

import com.joe.Game;

public class Util {
	
	public static void streamMessage(String message) {
		long start = System.nanoTime();
		
		char[] chars = message.toCharArray();
		
		int pos = 0;
		
		while(pos < chars.length) {
			if((System.nanoTime() - start) > 5E7) {
				System.out.print(chars[pos++]);
				start = System.nanoTime();
			}
		}
	}
	
	public static void streamMessageLn(String message) {
		streamMessage(message);
		System.out.println();
	}

	public static void printlnDebug(String message) {
		if (Constants.DEBUGGING) {
			System.out.println(message);
		}
	}

	public static void hintMessageGuide() {
		Game.getCamera().getLocation().set(10, 6);
		streamMessageLn("Kids these days...Can't do anything on their own.");
		pressEnterToContinue();
		Game.getPlayer().getZone().printVisibleZone();
		System.out.println();
		streamMessageLn("Look, there's a door down there.");
		streamMessageLn("Now get out of my sight.");
		pressEnterToContinue();
		Game.getCamera().getLocation().set(Game.getPlayer().getLocation());
	}

	public static void pressEnterToContinue() {
		System.out.println("Press enter to continue...");
		InputReader.getLine();
		System.out.println();
	}
	
	public static String capitalizeAllFirstLetters(String line) {
		line = line.replaceAll("_", " ");
		String[] words = line.split(" ");
		
		String formated = "";
		for(String s : words) {
			formated = formated + capitalizeFirstLetter(s) + " ";
		}
		return formated.trim();
	}
	
	public static String capitalizeFirstLetter(String word) {
		char firstChar = word.charAt(0);
		String otherCharacters = word.substring(1, word.length()).toLowerCase();
		return firstChar + otherCharacters;
	}
}
