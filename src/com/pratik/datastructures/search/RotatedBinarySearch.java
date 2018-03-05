package com.pratik.datastructures.search;

/**
 * Binary search in a sorted rotated array WITH NO DUPLICATES. This code will
 * not work for dups. Take O(log(n));
 * 
 * @author pratikm
 *
 */
public class RotatedBinarySearch {

	/*
	 * Modification of traditional binsearch to work on rotated sorted array.
	 */
	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {

			// logical shift seems to perform better for large input.
			int mid = (low + high) >>> 1;

			if (nums[mid] == target) {
				return mid;
			}

			// Right half is monotonically increasing
			if (nums[mid] <= nums[high]) {

				if (target > nums[mid] && target <= nums[high]) {
					// search in right half of array
					low = mid + 1;
				} else {
					// search in left half of array
					high = mid - 1;
				}

			} else { // left half is monotonically increasing

				if (target >= nums[low] && target < nums[mid]) {
					// search in left half of array
					high = mid - 1;
				} else {
					// search in right half of array
					low = mid + 1;
				}

			}

		}

		return -1;
	}

	public static void main(String[] args) {

		int[] a = { 25, 26, 28, 29, 31, 35, 4, 6, 8, 10, 11, 15, 17, 19, 21, 23 };
		
		System.out.println("Number 29 found at index "+search(a,29));
		System.out.println("Number 19 found at index "+search(a,19));
		System.out.println("Number 23 found at index "+search(a,23));
		System.out.println("Number 27 Not Found in the Array "+search(a,27));




	}

}
