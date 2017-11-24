/**
 * Implement an algorithm to determine if a String has all unique characters
 */
package com.pratik.datastructures.strings;

import java.util.Arrays;
import java.util.BitSet;

public class StringUniqueCharacter {

	// O(nlog(n)) approach.
	public static boolean isUniqueChar1(String str) {

		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		char prev = ' ';
		for (char ch : arr) {

			if (Character.toLowerCase(ch) == Character.toLowerCase(prev)) {
				return false;
			} else {
				prev = ch;
			}
		}
		return true;
	}

	// O(n) time and O(256) space: Use a bitset.
	public static boolean isUniqueChar2(String str) {

		BitSet bs = new BitSet(256);

		for (int i = 0; i < str.length(); i++) {

			int index = str.charAt(i);
			if (bs.get(index)) {
				return false;
			} else {
				bs.set(index);
			}

		}

		return true;
	}

	// O(n) time no additional data structure.
	// Uses Bit Masking
	public static boolean isUniqueChar3(String str) {

		int check = 0;

		for (int i = 0; i < str.length(); ++i) {

			int val = str.charAt(i);
			// check the bit for this char
			if ((check & (1 << val)) > 0)
				return false;
			// set the bit at val;
			check |= (1 << val);
		}

		return true;
	}

	// O(n) time no additional data structure.
	// Uses a boolean array
	public static boolean isUniqueChar4(String str) {

		boolean[] arr = new boolean[256];

		for (int i = 0; i < str.length(); ++i) {

			int val = str.charAt(i);
			if (arr[val]) {
				return false;
			} else {
				arr[val] = true;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		String s1 = "PRATIK";
		String s2 = "AMAZON";

		System.out.println("String pratik answer = " + isUniqueChar1(s1));
		System.out.println("String amazon answer = " + isUniqueChar1(s2));

		System.out.println("String pratik answer = " + isUniqueChar2(s1));
		System.out.println("String amazon answer = " + isUniqueChar2(s2));

		System.out.println("String pratik answer = " + isUniqueChar3(s1));
		System.out.println("String amazon answer = " + isUniqueChar3(s2));

	}

}
