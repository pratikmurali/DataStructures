package com.pratik.datastructures.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes: You may assume pattern contains only lowercase letters, 
 * and str contains lowercase letters separated by a single space.
 * LEETCODE.
 *
 */

public class StringWordPattern {
	
	public static boolean checkWordPattern(String pattern, String str) {
		
		String[] s = str.split(" ");
		
		System.out.println(pattern.length());
		System.out.println(str.length());
		
		if(pattern.length() != s.length) {
			return false;
		}

		Map index = new HashMap();
		
		for(Integer i = 0; i < pattern.length(); i++) {
			
			char ch = pattern.charAt(i);
			if(index.put(ch, i) != index.put(s[i],i)) {
				return false;
			}
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		
		//String s1 = "abba";
		//String s2 = "red blue blue red";
		
		//System.out.println(checkWordPattern(s1,s2));
		
		//String s3 = "abba";
		//String s4 = "red green blue red";
		
		String s5 ="ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
		String s6 = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
		
		System.out.println(checkWordPattern(s5,s6));
		
	}

}
