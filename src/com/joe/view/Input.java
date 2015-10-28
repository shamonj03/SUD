package com.joe.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import com.joe.GameFrame;

@SuppressWarnings("serial") public class Input extends JTextField {

	private String line;

	private boolean recievedInput = false;

	public Input(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		setSize(dimension);
		setPreferredSize(dimension);

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		setPreferredSize(dimension);

		addActionListener(e -> {
			line = getText();
			setText("");
			recievedInput = true;
		});

		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);
		setFont(font);

		setForeground(GameFrame.FONT_COLOR);
		setBackground(GameFrame.BG_COLOR);
		setBorder(BorderFactory.createLineBorder(GameFrame.FONT_COLOR));
	}

	public String getLine() {
		waitForInput();

		if (line.isEmpty() || line == null) {
			return "";
		}
		return line;
	}

	public int getInt() {
		int number = 0;

		try {
			number = Integer.parseInt(getLine());
		} catch (Exception e) {
			GameFrame.getConsole().println("Please enter a valid integer.");
			return getInt();
		}
		return number;
	}

	public float getFloat() {
		float number = 0;

		try {
			number = Float.parseFloat(getLine());
		} catch (Exception e) {
			GameFrame.getConsole().println("Please enter a valid floating point number.");
			return getFloat();
		}
		return number;
	}

	public double getDouble() {
		double number = 0;

		try {
			number = Double.parseDouble(getLine());
		} catch (Exception e) {
			GameFrame.getConsole().println("Please enter a valid decimal.");
			return getDouble();
		}
		return number;
	}

	public boolean getBoolean() {
		boolean bool = false;

		try {
			bool = Boolean.parseBoolean(getLine());
		} catch (Exception e) {
			GameFrame.getConsole().println("Please enter true or false.");
			return getBoolean();
		}
		return bool;
	}

	private void waitForInput() {
		while(!recievedInput) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		recievedInput = false;
	}

}
