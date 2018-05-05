package com.pratik.datastructures.sort;

import java.util.Arrays;

/**
 * Mergesort is an O(nlog(n)) algorithm. It uses an auxilary array.
 * @author pratikm
 *
 */
public class Mergesort {

	@SafeVarargs
	private static <T> T[] newArray(int length, T... array) {
		return Arrays.copyOf(array, length);
	}

	public static <T extends Comparable<T>> void mergesort(T[] A) {

		if (A.length < 2) {
			return;
		}

		int mid = A.length >>> 1;

		T[] left = newArray(mid);
		T[] right = newArray(A.length - mid);

		for (int i = 0; i < mid; i++) {
			left[i] = A[i];
		}

		for (int j = mid; j < A.length; j++) {
			right[j - mid] = A[j];
		}

		mergesort(left);
		mergesort(right);
		merge(left, right, A);

	}

	private static <T extends Comparable<T>> void merge(T[] left, T[] right, T[] A) {

		int i = 0;
		int j = 0;
		int k = 0;
		int ll = left.length;
		int rl = right.length;

		while (i < ll && j < rl) {

			if (left[i].compareTo(right[j]) <= 0) {
				A[k++] = left[i++];
			} else {
				A[k++] = right[j++];
			}
		}

		while (i < ll)
			A[k++] = left[i++];
		while (j < rl)
			A[k++] = right[j++];
	}

	public static void main(String[] args) {

		System.out.println("----------TESTCASE FOR STRINGS -------");
		String[] cities = { "Delhi", "Sydney", "Cairo", "London", "Dallas", "Aarhus", "Seattle", "San Francisco",
				"Beijing", "Lima", "Yerevan", "Helsinki" };
		System.out.println("Cities Before Sorting" + Arrays.toString(cities));
		mergesort(cities);
		System.out.println("Cities After Sorting" + Arrays.toString(cities));

		System.out.println("----------TESTCASE FOR INTEGERS -------");
		Integer[] numbers = { 5, 7, 45, 23, -17, 33, 21, 97, 0, -5, 56, 39, 68, 64, 75, -12 };
		System.out.println("Numbers Before Sorting" + Arrays.toString(numbers));
		mergesort(numbers);
		System.out.println("Numbers After Sorting" + Arrays.toString(numbers));

	}

}
