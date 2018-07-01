package com.pratik.datastructures.arrays;

/**
 * Simple solution to find max subarray sum for contiguous elements
 * when the size of the subarray is k.
 * @author pratikm
 *
 */

public class SlidingWindowSum {

	public static int maxWindowSum(int[] nums, int k) {

		int maxSum = 0;
		int maxWindowSum = 0;

		if (k >= nums.length) {
			return -1;
		}

		for (int i = 0; i < k; i++) {
			maxWindowSum += nums[i];
		}
		
		for (int j = k; j < nums.length; j++) {

			//Add one at the end, remove one from the begining.
			maxWindowSum = maxWindowSum - nums[j - k] + nums[j];
			maxSum = Math.max(maxSum, maxWindowSum);

		}

		return maxSum;
	}

	public static void main(String[] args) {

		int[] arr = { 21, 4, 5, 17, 34, 22, 43, 1, 56, 7, 13, 22, 48 };

		System.out.println(maxWindowSum(arr, 4));
	}

}
