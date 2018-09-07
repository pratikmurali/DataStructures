package com.pratik.datastructures.arrays;

import java.util.Arrays;

/**
 * Move all zeroes to the end of the given integer array. 
 * For example, if A = [2,3,0,3,0,1,0], Output = [2,3,3,1,0,0,0].
 * @author pratikm
 *
 */
public class MoveZeroes {

	/**
	 * Naive first thought in my mind approach.
	 * @param nums
	 */
	public static void moveZeroesVersion1(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				for (int j = i+1; j < nums.length; j++) {
					if (nums[j] != 0) {
						swap(nums, i, j);
						break;
					}
				}
			}
		}

	}
	
	/**
	 * Smarter O(n) approach.
	 * Count all the non-zero elements inline
	 * while traversing the array. Length-Count Zeroes will be left.
	 * @param nums
	 */
	public static void moveZeroesVersion2(int[] nums) {

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[count++] = nums[i];
			}
		}

		while (count < nums.length)
			nums[count++] = 0;

	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,0,3,0,1,0};
		//moveZeroesVersion1(nums);
		//System.out.println(Arrays.toString(nums));
		moveZeroesVersion2(nums);
		System.out.println(Arrays.toString(nums));

	}

}
