package com.pratik.datastructures.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * O(n) array shuffling algorithm.
 *
 *
 */
public class FischerYatesShuffle {

	/**
	 * Fischer Yates Shuffle
	 * @param a
	 * @return
	 */
	public static int[] shuffle(int[] a) {

		for (int i = a.length - 1; i >= 0; i--) {

			int random = generateRandom(i);
			swap(a, i, random);
		}

		return a;

	}

	/**
	 * Generate a random number in a range.
	 * @param i
	 * @return
	 */
	private static int generateRandom(int i) {
		int range = (i - 0) + 1;
		Random ran = new Random();
		int random = ran.nextInt(range);
		return random;
	}

	private static void swap(int[] a, int i, int random) {

		int temp = a[i];
		a[i] = a[random];
		a[random] = temp;

	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

		Arrays.stream(shuffle(a)).forEach(System.out::println);

	}

}
