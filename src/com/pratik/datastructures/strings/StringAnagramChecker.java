package com.pratik.datastructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagramChecker {

	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> indices = new ArrayList<>();

		for (int i = 0; i <= s.length() - p.length(); i++) {

			if (isAnagram(s.substring(i, i + p.length()).toCharArray(), p.toCharArray())) {
				indices.add(i);
			}

		}

		return indices;

	}

	public static boolean isAnagram(char[] s, char[] p) {

		if (s.length != p.length) {
			return false;
		}

		Arrays.sort(s);
		Arrays.sort(p);

		for (int i = 0; i < s.length; i++) {

			if (s[i] != p[i]) {
				return false;
			}
		}

		return true;

	}

	/**
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> findAnagramsOptimized(String s, String p) {

		List<Integer> list = new ArrayList<>();

		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;

		int[] hash = new int[256]; // character hash

		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash, decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right)] >= 1) {
				count--;
			}
			hash[s.charAt(right)]--;
			right++;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0) {
				list.add(left);
			}
			// if we find the window's size equals to p, then we have to move left (narrow
			// the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't go below 0
			if (right - left == p.length()) {

				if (hash[s.charAt(left)] >= 0) {
					count++;
				}
				hash[s.charAt(left)]++;
				left++;

			}

		}
		return list;
	}


	public static void main(String[] args) {

		String s1 = "cbaebabacd";
		String s2 = "abc";

		findAnagrams(s1, s2).stream().forEach(System.out::println);
		
		findAnagramsOptimized(s1, s2).stream().forEach(System.out::println);
		
		String s3 = "a";
		String s4 = "b";
		
		System.out.println(isAnagram(s3.toCharArray(),s4.toCharArray()));

	}

}
