package com.pratik.datastructures.sort;

import java.util.Arrays;

/**
 * Count Inversions O(nlog(n))
 * Counting inversions is a popular technique (used in collaborative filtering for example).
 * @author pratikm
 *
 */
public class CountInversions {

	public static int countInversions(int[] a) {

		if (a.length <= 1)
			return 0;
		
		int inversionCount = 0;

		int mid = a.length >>> 1;
		int[] left = new int[mid];
		int[] right = new int[a.length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}

		for (int j = mid; j < a.length; j++) {
			right[j - mid] = a[j];
		}
		
		inversionCount = countInversions(left);
		inversionCount += countInversions(right);
		inversionCount += merge(left,right,a);

		return inversionCount;
	}

	private static int merge(int[] a, int[] b, int[] c) {

		int i = 0, j = 0, k = 0, invCount = 0;

		while (i < a.length && j < b.length) {

			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
				//This is the important step!
				//modification to merge step, to count inversions.
				invCount += a.length - i;
			}
		}

		while (i < a.length) {
			c[k++] = a[i++];
		}

		while (j < b.length) {
			c[k++] = b[j++];
		}

		return invCount;

	}

	public static void main(String[] args) {

		int[] arr = { 2,1,3,2,4,3,5,4};
		System.out.println("There were " + countInversions(arr) + " inversions");
		System.out.println(Arrays.toString(arr));

	}

}
