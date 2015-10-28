package com.joe.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.joe.GameFrame;

@SuppressWarnings("serial") public abstract class Console extends JTextArea {

	private JTextPane textPane;
	private Style style;

	public Console(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		setSize(dimension);
		setPreferredSize(dimension);

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		textPane = new JTextPane();


		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);
		textPane.setFont(font);

		setTextPane(textPane);

		style = textPane.addStyle("Style", null);
		StyleConstants.setForeground(style, GameFrame.FONT_COLOR);
		StyleConstants.setBackground(style, GameFrame.BG_COLOR);


		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(dimension);
		scrollPane.setBorder(BorderFactory.createLineBorder(GameFrame.FONT_COLOR));
		textPane.setBackground(GameFrame.BG_COLOR);
		setBorder(BorderFactory.createEmptyBorder());

		add(scrollPane);
	}

	public abstract void setTextPane(JTextPane textPane);

	public void disableEditing() {
		textPane.setEditable(false);
	}

	public void clearText() {
		setText("");
	}

	@Override public void setText(String text) {
		textPane.setText(text);
		textPane.setCaretPosition(textPane.getDocument().getLength());
	}

	public void printf(String text, Object... args) {
		print(String.format(text, args));
	}

	public void print(String text) {
		StyledDocument doc = textPane.getStyledDocument();
		try {
			doc.insertString(doc.getLength(), text, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
	}

	public void println(String text) {
		print(text + "\n");
	}

	public void println() {
		println("");
	}
}
