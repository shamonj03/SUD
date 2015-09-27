package com.joe.model;

import java.util.ArrayList;

import com.joe.util.InputReader;

public abstract class Menu {

	private ArrayList<String> items = new ArrayList<>();
	
	private String title;

	public Menu(String title) {
		this.title = title;
	}

	public abstract void populateMenu();
	
	public abstract void handleOption(int option);
	
	public void displayMenu() {
		items.clear();
		populateMenu();
		
		System.out.println(title);
		
		for(int i = 0; i < items.size(); i++) {
			System.out.println("\t" + (i + 1) + ": " + items.get(i));
		}
		
		int option = InputReader.getInt();
		handleOption(option);
	}
	
	public void addItem(String item) {
		items.add(item);
	}
	
	public String getTitle() {
		return title;
	}
}
