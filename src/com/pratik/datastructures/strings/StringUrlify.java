package com.pratik.datastructures.strings;

/**
 * Write a method to replace all the spaces in a string with %20. You are given
 * the true length of the string. The string has sufficient space at the end to
 * hold the additional characters. Input "Mr John Smith "
 * Output:"Mr%20John%20Smith"
 * 
 * @author pratikm
 *
 */

public class StringUrlify {

	/**
	 * UrlEncode a String
	 * 
	 * @param str
	 * @param trueLength
	 * @return
	 */
	public static String urlify(char[] str, int trueLength) {

		int spaceCounter = 0;
		
		System.out.println(str.length);

		// first scan count the number of spaces.

		for (int i = 0; i < trueLength; i++) {

			if (Character.isWhitespace(str[i])) {
				spaceCounter++;
			}
		}

		int newLength = trueLength + spaceCounter * 2;
		System.out.println(newLength);

		//str[newLength] = '\0';

		for (int i = trueLength - 1; i >= 0; i++) {

			if (Character.isWhitespace(str[i])) {

				str[newLength - 1] = '0';
				str[newLength - 1] = '2';
				str[newLength - 1] = '%';
				newLength = newLength - 3;

			} else {
				str[newLength - 1] = str[i];
				newLength--;
			}

		}

		return String.copyValueOf(str);

	}

	public static void main(String[] args) {

		String s1 = "Mr John Smith    ";
		System.out.println("Urlify Mr John Smith    " + urlify(s1.toCharArray(), 13));

	}

}
