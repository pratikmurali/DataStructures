package com.pratik.datastructures.strings;

/**
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, 
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * @author pratikm
 *
 */
public class StringCheckPalindromePairs {
	

	/**
	 * Check if String is a palindrome O(n)
	 * @return
	 */
	private static boolean isPalindrome(String str) {

		int p = 0;
		int q = str.length() - 1;

		while (p < q) {

			if (str.charAt(p) != str.charAt(q)) {
				return false;
			}
			p++;
			q--;

		}

		return true;
	}

	public static void main(String[] args) {

		System.out.println(" Is radar a palindrome ?" + isPalindrome("radar"));
		System.out.println(" Is abba a palindrome ?" + isPalindrome("abba"));
		System.out.println(" Is racecar a palindrome ?" + isPalindrome("racecar"));
		System.out.println(" Is pratik a palindrome ?" + isPalindrome("pratik"));

	}

}
