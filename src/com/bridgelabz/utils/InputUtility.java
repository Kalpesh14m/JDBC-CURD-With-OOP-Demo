package com.bridgelabz.utils;

import java.util.Scanner;

public class InputUtility {
	private InputUtility() {
		// Auto-generated constructor stub
	}

	private static final Scanner SC = new Scanner(System.in);

	public static int intVal() {
		return SC.nextInt();
	}

	public static String stringVal() {
		return SC.next();
	}

	public static long longVal() {
		return SC.nextLong();
	}
}
