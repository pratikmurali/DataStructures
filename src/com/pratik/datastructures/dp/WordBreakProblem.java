package com.pratik.datastructures.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an input string and a dictionary of words, segment the input string
 * into a space-separated sequence of dictionary words if possible. For example,
 * if the input string is "applepie" and dictionary contains a standard set of
 * English words, then we would return the string "apple pie" as
 * output.[Description straight from the author:
 * http://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem]
 *
 */

public class WordBreakProblem {
	
	private static Map<String,String> memoized = new HashMap<>();

	/**
	 * Just caters to 2 segments.
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static String segmentStringNaive(String s, Set<String> dict) {

		if (s == null || s.isEmpty()) {
			return null;
		}

		for (int i = 1; i < s.length(); i++) {

			// check for suffix
			String prefix = s.substring(0, i);
			if (dict.contains(prefix)) {
				// check if dictionary contains prefix
				String suffix = s.substring(i, s.length());

				if (dict.contains(suffix)) {
					return prefix + " " + suffix;
				}
			}
		}

		return null;
	}

	/**
	 * Generalizes to multiple segments.
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static String segmentStringRecursive(String s, Set<String> dict) {

		if (dict.contains(s)) {
			return s;
		}

		for (int i = 0; i < s.length() - 1; i++) {

				String prefix = s.substring(0, i);

				if (dict.contains(prefix)) {

					// System.out.print(padLeftSpaces(prefix, i));
					String suffix = s.substring(i, s.length());

					// recursively further segment the suffix
					String segmented = segmentStringRecursive(suffix, dict);

					if (segmented != null) {
						return prefix + " " + segmented;
					} 
				}
		}

		return null;

	}

	public static String padLeftSpaces(String str, int n) {
		return String.format("%1$" + n + "s", str);
	}
	
	/**
	 * Recursive DP (because of memoization)
	 * @param s
	 * @param dict
	 * @return
	 */
	public static String segmentStringRecursiveDP(String s, Set<String> dict) {

		if (dict.contains(s)) {
			return s;
		}

		if (memoized.containsKey(s)) {
			return memoized.get(s);
		}

		for (int i = 0; i < s.length() - 1; i++) {

			String prefix = s.substring(0, i);

			if (dict.contains(prefix)) {

				// System.out.print(padLeftSpaces(prefix, i));
				String suffix = s.substring(i, s.length());

				// recursively further segment the suffix
				String segmented = segmentStringRecursive(suffix, dict);

				if (segmented != null) {
					memoized.put(prefix, " " + segmented);
					return prefix + " " + segmented;
				}
			}
		}

		memoized.put(s, null);
		return null;

	}

	public static void main(String[] args) {

		String s = "bluefox";
		//String ss = "quickbluefoxjumpedoverthefence";
		//String[] arr = { "quick", "blue", "fox", "jumped", "over", "the", "fence" };
		//Set<String> dict = new HashSet<>(Arrays.asList(arr));
		String ss = "interviewkickstart";
		String[] arr = { "a","e","i","int","inter","interview","view","kick,kicker","kickstart","star" };
		Set<String> dict = new HashSet<>(Arrays.asList(arr));
		// System.out.println(segmentStringNaive(s,dict));
		// assert("blue fox".equals(segmentStringNaive(s,dict)));
		 System.out.println(segmentStringRecursiveDP(ss,dict));
		//segmentStringRecursive(ss, dict);
		// assert("quick blue fox jumped over the
		// fence".equals(segmentStringRecursive(ss,dict)));

	}

}
