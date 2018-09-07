package com.pratik.datastructures.arrays;

public class MaxMinSlidingWindowSum {

	/**
	 * Given an array of integers (positive or negative) and a sliding window size (i.e. a contiguous subset), 
	 * write a function to print the minimum and the maximum sliding window sum.
	 * @param nums
	 * @param w
	 */
	public static void findMinMax(int[] nums, int w) {

		int minSum = 0;
		int maxSum = 0;
		// sum in window
		int currentSum = 0;

		// If the window size == size of array then min/max will be same
		// so marking that invalid as well.
		if (w >= nums.length) {
			System.out.println("Window cannot be greater than size of array");
			return;
		}

		// calsulate rthe first window's sum.
		for (int i = 0; i < w; i++) {
			maxSum += nums[i];
		}

		minSum = maxSum;
		currentSum = maxSum;

		for (int j = w; j < nums.length; j++) {
			// Add the next element, delete the last (out of window) element.
			currentSum = (currentSum + nums[j]) - nums[j - w];
			maxSum = Math.max(currentSum, maxSum);
			minSum = Math.min(currentSum, minSum);

		}

		System.out.println("Maximum Sum for Window of size " + w + " = " + maxSum);
		System.out.println("Minimum Sum for Window of size " + w + " = " + minSum);

	}

	public static void main(String[] args) {

		int[] test1 = { -2, 3, 7, 1, 2, 5, 3, 0, -7 };

		// Happy case, 11 and -4
		findMinMax(test1, 3);

		// Invalid case
		findMinMax(test1, 10);

		// Invalid case
		findMinMax(test1, 9);

		// Borderline case, 19 and 14
		findMinMax(test1, 8);

		int[] companyProvided = { 1, 2, 4, 5, 3 };
		// Company provided, 9 and 3
		findMinMax(companyProvided, 2);

	}

}
