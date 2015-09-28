package com.joe.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

	private static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public static String getLine() {
		String input = "";

		try {
			while (System.in.available() != 0) {
				System.in.read();
			}

			input = reader.readLine();

			if (input == null) {
				System.out.println("Ending game...");
				System.exit(1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	public static int getInt() {
		int number = 0;

		try {
			number = Integer.parseInt(getLine());
		} catch (Exception e) {
			System.out.println("Please enter a valid integer.");
			return getInt();
		}
		return number;
	}

	public static float getFloat() {
		float number = 0;

		try {
			number = Float.parseFloat(getLine());
		} catch (Exception e) {
			System.out.println("Please enter a valid floating point number.");
			return getFloat();
		}
		return number;
	}

	public static double getDouble() {
		double number = 0;

		try {
			number = Double.parseDouble(getLine());
		} catch (Exception e) {
			System.out.println("Please enter a valid decimal.");
			return getDouble();
		}
		return number;
	}

	public static boolean getBoolean() {
		boolean bool = false;

		try {
			bool = Boolean.parseBoolean(getLine());
		} catch (Exception e) {
			System.out.println("Please enter true or false.");
			return getBoolean();
		}
		return bool;
	}
}
