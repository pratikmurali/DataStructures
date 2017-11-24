package com.pratik.datastructures.strings;

public class StringAtoi {

	public static int myAtoi(String str) {

		if (str == null || str.isEmpty()) {
			return 0;
		}

		int val = 0;
		double pow = 0.0;
		int start = 0;
		int sign = 1;

		// Skip the whitespace
		for (int i = 0; i < str.length(); ++i) {
			if (!Character.isSpaceChar(str.charAt(i)))
				break;
			start++;
		}

		// Get the sign bit
		if (str.charAt(start) == '-') {
			sign = -1;
			start++;
		}

		// Get the sign bit
		if (str.charAt(start) == '+') {
			start++;
		}

		for (int j = str.length() - 1; j >= start; j--) {

			System.out.println(str.charAt(j));

			if (Character.isSpaceChar(str.charAt(j)))
				continue;

			if (!Character.isDigit(str.charAt(j))) {
				return 0;
			}

			val += Math.pow(10.0, pow) * Character.getNumericValue(str.charAt(j));
			pow++;
		}

		return sign * val;

	}

	public static void main(String[] args) {

		System.out.println("Number is " + myAtoi("2367"));
		System.out.println("Number is " + myAtoi("    -23 67"));
		System.out.println("Number is " + myAtoi("+1"));

	}

}
