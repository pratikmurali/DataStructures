package com.pratik.datastructures.strings;

import java.util.HashMap;

public class MinimumWindowSubstring {

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
		
		String S ="ADOBECODEBANC";
		String T = "ABC";
		
		System.out.println(minWindow(S,T));
				
				

	}

}
