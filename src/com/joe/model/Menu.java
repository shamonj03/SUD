package com.joe.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.joe.util.InputReader;

public abstract class Menu {

	private ArrayList<MenuItem> items = new ArrayList<>();

	protected String title;

	public Menu(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public abstract void populateMenu();

	public abstract void handleOption(int index, int option);

	public void displayMenu() {
		items.clear();
		populateMenu();

		System.out.println(title);

		int keyIndex = 0;
		int optionIndex = 0;

		for (MenuItem item : items) {
			keyIndex++;

			if (item.getOptions() == null) {
				System.out.println("\t" + keyIndex + ": " + item.getHeader());
				continue;
			} else {
				System.out.println("\t" + item.getHeader());
			}

			if (item.getOptions().length == 1) {
				System.out.println("\t\t" + keyIndex + ": "
						+ item.getOptions()[0] + ".");
			} else {
				for (String option : item.getOptions()) {
					System.out.println("\t\t" + keyIndex + "." + optionIndex
							+ ": " + option + ".");
					optionIndex++;
				}
			}
			optionIndex = 0;
		}

		System.out.print("Choice: ");
		float choice = InputReader.getFloat();

		String number = Float.toString(choice);

		String[] tokens = number.split("\\.");
		int index = Integer.parseInt(tokens[0]);
		int option = Integer.parseInt(tokens[1]);

		handleOption(index, option);
	}

	public void addItem(String item, String[] options) {
		items.add(new MenuItem(item, options));
	}

	public void addItem(String item, String option) {
		items.add(new MenuItem(item, new String[] { option }));
	}

	public void addItem(String item) {
		items.add(new MenuItem(item, null));
	}

	public int size() {
		return items.size();
	}
	
	private class MenuItem {
		private final String header;
		private final String[] options;

		public MenuItem(String header, String[] options) {
			this.header = header;
			this.options = options;
		}

		public String getHeader() {
			return header;
		}

		public String[] getOptions() {
			return options;
		}
	}
}
