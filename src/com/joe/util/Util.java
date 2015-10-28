package com.joe.util;

import com.joe.GameFrame;

public class Util {

	public static void streamMessage(String message) {
		long start = System.nanoTime();

		char[] chars = message.toCharArray();

		int pos = 0;

		while(pos < chars.length) {
			if((System.nanoTime() - start) > 5E7) {
				GameFrame.getConsole().print(Character.toString(chars[pos++]));
				start = System.nanoTime();
			}
		}
	}

	public static void streamMessageLn(String message) {
		streamMessage(message);
		GameFrame.getConsole().println();
	}

	public static void printlnDebug(String message) {
		if (Constants.DEBUGGING) {
			GameFrame.getConsole().println(message);
		}
	}

	public static void pressEnterToContinue() {
		GameFrame.getConsole().println("Press enter to continue...");
		GameFrame.getInput().getLine();
		//GameFrame.getConsole().println();
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
