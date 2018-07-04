package com.pratik.datastructures.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author pratikm
 * Minimum Window Substring.
 */
public class MinimumWindowSubstring {

	/**
	 * Uses a hashmap to store the character count.
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	private static boolean check(String S, String T) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		if (S.length() < T.length())
			return false;

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();

		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (map.containsKey(c)) {
				// map.put(c, map.getOrDefault(c, 0) - 1);
				map.remove(c);
			}
		}
		int decCounter = map.size();

		return ((counter - decCounter) == T.length());
	}

	/**
	 * Brute Force, generate all substrings and then check if all characters of T
	 * appear in the substring. If they do, update the minimumWindowSubstring.
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public static String minWindowBruteForce(String S, String T) {

		if (S == null || S.length() < T.length() || S.length() == 0) {
			return "";
		}

		String minimumWindowSubstring = "";
        int minLength = Integer.MAX_VALUE;

		for (int i = 0; i < S.length(); i++) {
			for (int j = i + 1; j <= S.length(); j++) {
				String sub = S.substring(i, j);
				if (check(sub, T)) {
					System.out.println("Found Match "+sub+" and "+T);
					if (sub.length() <= minLength) {
						minimumWindowSubstring = sub;
                        minLength = sub.length();
					}

				}
			}
		}

		return minimumWindowSubstring;
	}

	/**
	 * Using the Sliding Window Template.
	 * 
	 * @param strText
	 * @param strCharacters
	 * @return
	 */
	public static String minWindow(String strText, String strCharacters) {

		if (strText == null || strText.length() < strCharacters.length() || strText.length() == 0) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : strCharacters.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int left = 0;
		int minLeft = 0;
		int minLen = strText.length() + 1;
		int count = 0;
		for (int right = 0; right < strText.length(); right++) {
			if (map.containsKey(strText.charAt(right))) {
				map.put(strText.charAt(right), map.get(strText.charAt(right)) - 1);
				if (map.get(strText.charAt(right)) >= 0) {
					count++;
				}
				while (count == strCharacters.length()) {
					if (right - left + 1 < minLen) {
						minLeft = left;
						minLen = right - left + 1;
					}
					if (map.containsKey(strText.charAt(left))) {
						map.put(strText.charAt(left), map.get(strText.charAt(left)) + 1);
						if (map.get(strText.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}
		if (minLen > strText.length()) {
			return "";
		}

		return strText.substring(minLeft, minLeft + minLen);
	}

	public static void main(String[] args) {

		//String S = "ADOBECODEBANC";
		//String T = "ABC";
		
		String S ="bbaa";
		String T ="aba";

		// System.out.println(minWindow(S,T));
		System.out.println(minWindowBruteForce(S, T));
		System.out.println(minWindow(S, T));

	}

}
