package com.joe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.joe.io.definition.ItemDefinition;
import com.joe.io.definition.MenuDefinition;
import com.joe.io.definition.NpcDefinition;
import com.joe.io.definition.ObjectDefinition;
import com.joe.io.definition.ZoneDefinition;
import com.joe.model.Camera;
import com.joe.model.Direction;
import com.joe.model.Entity;
import com.joe.model.EntityType;
import com.joe.model.Item;
import com.joe.model.Zone;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.GroundItem;
import com.joe.model.entity.Npc;
import com.joe.model.entity.Player;
import com.joe.util.InputReader;
import com.joe.util.Messages;
import com.joe.util.Util;

public class Game {

	private static Player player;

	private static Camera camera;

	public static void initializeGame() {
		ObjectDefinition.load();
		NpcDefinition.load();
		ItemDefinition.load();
		ZoneDefinition.load();
		MenuDefinition.load();
	}

	public static void start() {
		initializeGame();

		player = new Player();
		camera = new Camera(5, 5, player.getLocation());
		
		//Messages.introMessage();
		
		player.getInventory().add(new Item(0, 1));
		player.getInventory().add(new Item(1, 1));
		player.getInventory().add(new Item(2, 1));
		player.getInventory().add(new Item(3, 1));
		//player.getInventory().add(new Item(4, 1));
		
		play();
	}

	private static void play() {
		player.getZone().printVisibleZone();
		System.out.println();
		
		MenuDefinition.forId(0).displayMenu();
		
		play();
	}

	public static Player getPlayer() {
		return player;
	}

	public static Camera getCamera() {
		return camera;
	}
	
}
