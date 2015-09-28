package com.joe.util;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;

import com.joe.Game;
import com.joe.model.Item;

public class Messages {

	public static void introMessage() {
		String input = "";

		Util.streamMessageLn("Welcome adventurer. These are dark times indeed.");
		Util.streamMessageLn("Are you here to fight or are you here to die?");

		System.out.print("Fight or Die: ");
		input = InputReader.getLine();
		System.out.println();

		if (input.equalsIgnoreCase("fight")) {
			Util.streamMessageLn("Hah a fighting spirit I like that!");
			Util.streamMessageLn("Don't let your confidence blind you, you'll die anyways.");
		} else if (input.equalsIgnoreCase("die")) {
			Util.streamMessageLn("Having a sense of forsight is a valuable feature.");
			Util.streamMessageLn("You'd do well to remember that.");
		} else {
			Util.streamMessageLn("Dodging my question I see?");
		}
		Util.streamMessageLn("But that's besides the point, you're hired.");
		Util.streamMessageLn("You could say the positions...Recently been opened.");
		Util.streamMessageLn("What's you're name?");

		System.out.print("Name: ");
		input = InputReader.getLine();
		if(input.isEmpty()) {
			Util.streamMessageLn("Don't want to give a name?");
			Util.streamMessageLn("See what I care, I'll just call you Jack.");
			input = "Jack";
		}
		Game.getPlayer().setName(input);
		System.out.println();

		Util.streamMessageLn("So you're " + input + " are you?");
		Util.streamMessageLn("That's a silly name for an adventurer...");
		Util.streamMessageLn("Regardless, you look unprepared for the job.");
		Util.streamMessageLn("Take these.");
		System.out.println();

		Item sword = new Item(0, 1);
		Item potion = new Item(1, 2);
		Util.streamMessageLn("You are given a " + sword.getData().getName() + ".");
		Util.streamMessageLn("You are given some " + potion.getData().getName()
				+ "s.");
		Game.getPlayer().getInventory().add(sword);
		Game.getPlayer().getInventory().add(potion);

		Util.pressEnterToContinue();
	}

}
