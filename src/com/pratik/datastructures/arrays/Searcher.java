package com.pratik.datastructures.arrays;

import java.util.Arrays;

public class Searcher {

	/**
	 * 
	 * @param A
	 * @param x
	 * @return
	 */
	public static boolean binarySearchIterative(int[] A, int x) {

		if (A.length == 0) {
			return false;
		}

		int low = 0;
		int high = A.length - 1;

		while (low < high) {

			int mid = low + ((high - low) / 2);

			if (x == A[mid]) {
				return true;
			} else if (x < A[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return false;
	}

	/**
	 * 
	 * @param A
	 * @param x
	 * @return
	 */
	public static boolean binarySearchRecursive(int[] A, int x) {

		return binarySearchRecursive(A, 0, A.length - 1, x);
	}

	/**
	 * 
	 * @param A
	 * @param low
	 * @param high
	 * @param x
	 * @return
	 */
	private static boolean binarySearchRecursive(int[] A, int low, int high, int x) {

		if (low > high) {
			return false;
		}

		// int mid = (low + high) >>> 1;
		int mid = low + ((high - low) / 2);

		if (x == A[mid]) {
			return true;
		} else if (x < A[mid]) {
			return binarySearchRecursive(A, low, mid - 1, x);
		} else {
			return binarySearchRecursive(A, mid + 1, high, x);
		}

	}

	public static void main(String[] args) {
		
		int[] A = {1,34,5,8,45,22,12,4,12,77,83,13,7,25,-5,-4,0,2};
		
		//first sort the array
		Arrays.sort(A);
		
		boolean found = binarySearchRecursive(A,12);
		System.out.println("Number 12 "+((found)?"Found":"Not Found"));
		
		boolean found1 = binarySearchIterative(A,12);
		System.out.println("Number 12 "+((found1)?"Found":"Not Found"));

	}

}
