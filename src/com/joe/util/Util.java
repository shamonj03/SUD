package com.joe.util;

import java.util.Scanner;

public class Util {
	
	public static void streamMessage(String message) {
		long start = System.nanoTime();
		
		char[] chars = message.toCharArray();
		
		int pos = 0;
		
		while(pos < chars.length) {
			if((System.nanoTime() - start) > 5E7) {
				System.out.print(chars[pos++]);
				start = System.nanoTime();
			}
		}
	}
	
	public static void streamMessageLn(String message) {
		streamMessage(message);
		System.out.println();
	}

	public static void printlnDebug(String message) {
		if (Constants.DEBUGGING) {
			System.out.println(message);
		}
	}
}
