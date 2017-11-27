package com.pratik.datastructures.recursion;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

	private static void printPermutation(char[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void swap(char[] a, int i, int j) {

		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * 
	 * @param a
	 * @param l
	 * @param r
	 */
	private static void permuteHelper(char[] a, int l, int r, Set<String> noDups) {

		if (l == r) {

			if (!noDups.contains(String.valueOf(a))) {
				printPermutation(a);
				noDups.add(String.valueOf(a));
			}

			return;
		} else {

			for (int i = 1; i <= r; i++) {
				swap(a, l, i);
				permuteHelper(a, l + 1, r, noDups);
				swap(a, l, i);
			}
		}

	}

	/**
	 * 
	 * @param s
	 */
	public static void permute(String s) {

		if (s == null || s.isEmpty()) {
			return;
		}

		Set<String> noDups = new HashSet<>();
		permuteHelper(s.toCharArray(), 0, s.length() - 1, noDups);

	}

	public static void main(String[] args) {

		permute("google");

	}

}
