package com.pratik.datastructures.strings;

/**
 * Classic Needle in a Haystack problem, which shows two approaches to a brute
 * force O(NM) solution to searching the first occuring index of a substring in
 * a String. Where N == length of the Text, and M is the length of the pattern
 * being searched for. The basic flaw in brute force approaches is that, you
 * need to "backup" on T when no match is found for P. When T is a billion
 * characters long, and P is a 100 characters long, this has a worst case of
 * O(NM) which hardly scales.
 * 
 * @author pratikm
 *
 */

public class BruteForceSubstringSearch {

	/**
	 * Uses two for loops and demonstrates O(NM) better.
	 * Returns 0 based index of match.
	 * @param T
	 * @param P
	 * @return
	 */
	public static int bruteForcePatternSearchVer1(String T, String P) {

		int M = P.length();
		int N = T.length();

		// rule out the edge cases, assumes Text and Pattern are not null.
		if (N == 0 || N == 0 || M > N) {
			return -1;
		}

		for (int i = 0; i <= N - M; i++) {
			int j;

			for (j = 0; j < M; j++) {
				if (P.charAt(j) != T.charAt(i + j)) {
					break;
				}
			}

			if (j == M) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Uses one for loop and demonstrates the "Backup" better.
	 * Returns 0 based index of match.
	 * @param T
	 * @param P
	 * @return
	 */
	public static int bruteForcePatternSearchVer2(String T, String P) {

		int M = P.length();
		int N = T.length();

		// rule out the edge cases, assumes Text and Pattern are not null.
		if (N == 0 || N == 0 || M > N) {
			return -1;
		}

		int i, j;

		for (i = 0, j = 0; i < N && j < M; i++) {

			if (T.charAt(i) == P.charAt(j)) {
				// Check the next char index from the Pattern
				// Text index gets incremented by the outer for:
				j++;
			} else {
				// Backup Text index by j when you find
				// the first mismatch.
				i -= j;
				// Reset j as you'll need to scan again.
				j = 0;
			}
		}

		if (j == M) {
			return i - M; // Return the original index where the match started.
		} else
			return -1; // No index found
	}

	public static void main(String[] args) {

		// Average case input.
		String T1 = "ABRACADABRACA";
		String P1 = "ADAB";

		System.out.println(bruteForcePatternSearchVer1(T1, P1));
		System.out.println(bruteForcePatternSearchVer2(T1, P1));

		// Worst case input
		String T2 = "AAAAAAAAAAAAAAAAAB";
		String P2 = "AAB";

		System.out.println(bruteForcePatternSearchVer1(T2, P2));
		System.out.println(bruteForcePatternSearchVer2(T2, P2));

		// Negative Test Case
		System.out.println(bruteForcePatternSearchVer1(T2, P1));
		System.out.println(bruteForcePatternSearchVer2(T1, P2));

	}

}
