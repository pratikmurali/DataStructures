package com.pratik.datastructures.search;

/**
 * SQRT of a number in O(lgN) time uses the binary search technique.
 * @author pratikm
 *
 */

public class IntegerSqrt {

	public static int sqrt(int x) {

		if (x == 0 || x == 1) {
			return x;
		}

		int low = 1;
		int high = x >> 1;
		int ans = 0;

		while (low <= high) {

			int mid = (low + high) >> 1;

			if (mid == x/mid) {
				return mid;
			} else if (mid > x/mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
				ans = mid;
			}

		}

		return ans;
	}

	public static void main(String[] args) {
		

		System.out.println("Sqrt of 64 = "+sqrt(64));
		System.out.println("Sqrt of 75 = "+sqrt(75));
		System.out.println("Sqrt of 2147395599 = "+sqrt(2147395599));

	}

}
