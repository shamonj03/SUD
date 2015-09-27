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

		pressEnterToContinue();
	}

	public static void hintMessageGuide() {
		Game.getCamera().getLocation().set(5, 6);
		Util.streamMessageLn("Kids these days...Can't do anything on their own.");
		pressEnterToContinue();
		Game.getPlayer().getZone().printVisibleZone();
		System.out.println();
		Util.streamMessageLn("Look, there's a door down there.");
		Util.streamMessageLn("Now get out of my sight.");
		pressEnterToContinue();
		Game.getCamera().getLocation().set(Game.getPlayer().getLocation());
	}

	public static void pressEnterToContinue() {
		System.out.println("Press enter to continue...");
		InputReader.getLine();
		System.out.println();
	}

}
