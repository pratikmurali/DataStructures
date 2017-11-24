package com.pratik.datastructures.strings;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Given two strings check if one is a permutation of the other.
 * 
 * @author pratikm
 *
 */

public class StringCheckPermutation {

	/**
	 * O(nlog(n)) + O(n) sort the strings and check for equality.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkPermute1(String s1, String s2) {

		// Strings should be of equal length.
		if (s1.length() != s2.length()) {
			return false;
		}

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();

		Arrays.sort(arr1); //O(nlog(n))
		Arrays.sort(arr2); //O(nlog(n))

		//O(n)
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}

		return true;

	}
	
	/**
	 * Uses additional O(256) space but O(n) time
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkPermute2(String s1, String s2) {

		// Strings should be of equal length.
		if (s1.length() != s2.length()) {
			return false;
		}

		BitSet bs = new BitSet(256);

		for (int i = 0; i < s1.length(); i++) {
			bs.set(s1.charAt(i) - 'a', true);
		}

		for (int j = 0; j < s2.length(); j++) {

			if (!bs.get(s2.charAt(j) - 'a'))
				return false;
		}

		return true;

	}

	public static void main(String[] args) {

		String s1 = "amazon";
		String s2 = "zamaon";

		String s3 = "pratik";
		String s4 = "amazon";

		String s5 = "amazon";
		String s6 = "seattle";

		System.out.println("Uses Pre-Sorting");
		System.out.println(" Amazon and Zamaon are permutations " + checkPermute1(s1, s2));
		System.out.println(" Amazon and Pratik are permutations " + checkPermute1(s3, s4));
		System.out.println(" Amazon and Seattle are permutations " + checkPermute1(s3, s4));
		
		System.out.println("Uses a bitset");
		System.out.println(" Amazon and Zamaon are permutations " + checkPermute2(s1, s2));
		System.out.println(" Amazon and Pratik are permutations " + checkPermute2(s3, s4));
		System.out.println(" Amazon and Seattle are permutations " + checkPermute2(s3, s4));

	}

}
