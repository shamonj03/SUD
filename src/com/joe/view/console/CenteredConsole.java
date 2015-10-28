package com.joe.view.console;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.joe.view.Console;

@SuppressWarnings("serial") public class CenteredConsole extends Console {

	public CenteredConsole(int width, int height) {
		super(width, height);
	}

	@Override public void setTextPane(JTextPane textPane) {
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}

}
