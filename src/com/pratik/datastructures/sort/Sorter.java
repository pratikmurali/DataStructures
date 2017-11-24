package com.pratik.datastructures.sort;

import java.util.Arrays;

public class Sorter {

	/**
	 * 
	 * @param A
	 */
	public static void quicksort(int[] A) {

		quicksort(A, 0, A.length - 1);
	}

	private static void quicksort(int[] A, int start, int end) {

		// Base case
		if (start >= end) {
			return;
		} else {

			int pIndex = partition(A, start, end);
			quicksort(A, start, pIndex - 1);
			quicksort(A, pIndex + 1, end);
		}

	}

	/**
	 * Find the partition index using a pivot
	 * 
	 * @param A
	 * @param start
	 * @param end
	 * @return
	 */
	private static int partition(int[] A, int start, int end) {

		int pivot = A[end];
		int pIndex = start;

		for (int i = start; i < end; i++) {

			if (A[i] <= pivot) {
				swap(A, i, pIndex);
				pIndex = pIndex + 1;
			}
		}

		swap(A, pIndex, end);

		return pIndex;

	}

	/**
	 * 
	 * @param A
	 * @param a
	 * @param b
	 */
	private static void swap(int[] A, int a, int b) {

		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;

	}

	/**
	 * Merge step of merge sort
	 * 
	 * @param L
	 * @param R
	 * @param A
	 */
	private static void merge(int[] L, int[] R, int[] A) {

		int nL = L.length;
		int nR = R.length;
		int i = 0, j = 0, k = 0;

		// merge the arrays in ascending order.
		while (i < nL && j < nR) {

			if (L[i] < R[j]) {
				A[k++] = L[i++];
			} else {
				A[k++] = R[j++];
			}
		}

		while (i < nL) {
			A[k++] = L[i++];
		}

		while (j < nR) {
			A[k++] = R[j++];
		}
	}

	/**
	 * Merge sort partitioner.
	 * 
	 * @param A
	 */
	public static void mergesort(int[] A) {

		// base case
		if (A.length < 2) {
			return;
		}

		// find mid point
		int mid = A.length / 2;

		// Create partitions to merge
		int[] left = new int[mid];
		int[] right = new int[A.length - mid];

		// populate the left partition
		for (int i = 0; i < mid; i++) {
			left[i] = A[i];
		}

		// populate the right partition
		for (int j = mid; j < A.length; j++) {
			right[j - mid] = A[j];
		}

		mergesort(left);
		mergesort(right);
		merge(left, right, A);

	}

	public static void main(String[] args) {

		System.out.println("------------- Mergesort Results -----------------");
		int[] A = { 2, 4, 1, 6, 8, 5, 3, 0, 7, 11, 10, -1, 15, 13, 17, 14, 12, 16 };
		mergesort(A);
		Arrays.stream(A).forEach(System.out::println);

		System.out.println("------------- Quicksort Results -----------------");
		int[] B = { 2, 4, 1, 6, 8, 5, 3, 0, 7, 11, 10, -1, 15, 13, 17, 14, 12, 16 };
		quicksort(B);
		Arrays.stream(B).forEach(System.out::println);

	}

}
