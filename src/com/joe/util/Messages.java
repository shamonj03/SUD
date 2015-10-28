package com.joe.util;

import com.joe.Game;
import com.joe.GameFrame;
import com.joe.model.Camera;
import com.joe.model.Item;
import com.joe.model.Zone;
import com.joe.model.entity.Player;

public class Messages {

	public static void nothingInterestingHappens() {
		Util.streamMessageLn("Nothing interesting happens...");
	}

	public static void hintMessageGuide() {
		Player player = Game.getPlayer();
		Camera camera = Game.getCamera();
		Zone zone = player.getData().getZone();
		camera.getLocation().set(10, 6);
		Util.streamMessageLn("Kids these days...Can't do anything on their own.");
		Util.pressEnterToContinue();
		zone.printVisibleZone();
		GameFrame.getConsole().println();
		Util.streamMessageLn("Look, there's a door down there.");
		Util.streamMessageLn("Now get out of my sight.");
		Util.pressEnterToContinue();
		camera.getLocation().set(player.getLocation());
		zone.printVisibleZone();
	}

	public static void introMessage() {
		String input = "";

		Util.streamMessageLn("Welcome adventurer. These are dark times indeed.");
		Util.streamMessageLn("Are you here to fight or are you here to die?");

		GameFrame.getConsole().print("Fight or Die: ");
		input = GameFrame.getInput().getLine();
		GameFrame.getConsole().println();

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

		GameFrame.getConsole().print("Name: ");
		input = GameFrame.getInput().getLine();
		if(input.isEmpty()) {
			Util.streamMessageLn("Don't want to give a name?");
			Util.streamMessageLn("See what I care, I'll just call you Jack.");
			input = "Jack";
		}
		Game.getPlayer().getData().setName(input);
		GameFrame.getConsole().println();

		Util.streamMessageLn("So you're " + input + " are you?");
		Util.streamMessageLn("That's a silly name for an adventurer...");
		Util.streamMessageLn("Regardless, you look unprepared for the job.");
		Util.streamMessageLn("Take these.");
		GameFrame.getConsole().println();

		Item sword = new Item(0, 1);
		Item potion = new Item(1, 2);
		Util.streamMessageLn("You are given a " + sword.getData().getName() + ".");
		Util.streamMessageLn("You are given some " + potion.getData().getName()
				+ "s.");
		Game.getPlayer().getData().getInventory().add(sword);
		Game.getPlayer().getData().getInventory().add(potion);

		//Util.pressEnterToContinue();
	}

}
