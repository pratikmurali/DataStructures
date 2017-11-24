package com.pratik.datastructures.strings;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a list of words, find if any of the two words can be concatenated to form a palindrome.
 * Input : list[] =  {"abc", "xyxcba", "geekst", "or","keeg", "bc"}
 * Output: There is a pair "abc" and "xyxcba"
 * http://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
 */
public class StringPalindromePairs {
	
	public static boolean checkPalindrome(String str) {
		
		int len = str.length();
		
		for (int i = 0; i < len / 2; i++) {

			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * O(n^2)
	 * @param words
	 * @return
	 */
	public static boolean checkPalindromePairs(List<String> words) {

		if (words.isEmpty())
			return false;

		for (int i = 0; i < words.size() - 1; i++) {

			for (int j = i + 1; j < words.size(); j++) {

				String concat = words.get(i) + words.get(j);
				if (checkPalindrome(concat)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		
		String str1 = "abcdcba";
		System.out.println(checkPalindrome(str1));
		
		List<String> words = Arrays.asList("abcd","xyz","xor","cba","ac");
		
		System.out.println(checkPalindromePairs(words));
		

	}

}
