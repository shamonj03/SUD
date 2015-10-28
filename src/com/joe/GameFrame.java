package com.joe;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import com.joe.view.Console;
import com.joe.view.Input;
import com.joe.view.console.BasicConsole;
import com.joe.view.console.CenteredConsole;

public class GameFrame {

	public static final Color FONT_COLOR = Color.RED;
	public static final Color BG_COLOR = Color.BLACK;

	private static final Console map = new CenteredConsole(600, 128);
	private static final Console console = new BasicConsole(250, 200);
	private static final Console options = new BasicConsole(350, 200);
	private static final Input input = new Input(500, 24);

	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		frame.display();

		Game.start();
	}

	public void display() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		options.disableEditing();
		map.disableEditing();


		frame.add(map, BorderLayout.NORTH);
		frame.add(console, BorderLayout.CENTER);
		frame.add(options, BorderLayout.WEST);
		frame.add(input, BorderLayout.SOUTH);
		frame.setResizable(false);

		frame.pack();
		frame.setVisible(true);

		input.requestFocusInWindow();
	}

	public static Console getMap() {
		return map;
	}

	public static Console getConsole() {
		return console;
	}

	public static Console getOptions() {
		return options;
	}

	public static Input getInput() {
		return input;
	}
}
