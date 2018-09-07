package com.pratik.datastructures.arrays;

public class DutchNationalFlag {
	
	public static void dutch(int[] nums, int index) {

		int low = -1;
		int high = nums.length;
		int mid = -1;

		while (mid + 1 < high) {

			int toPlace = nums[mid + 1];

			if (toPlace > index) {
				swap(nums, mid + 1, high - 1);
				high--;
			} else if (toPlace < index) {
				swap(nums, mid + 1, low + 1);
				low++;
				mid++;
			} else {
				mid++;
			}
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		
		int nums[] = {3,5,2,6,8,4,4,6,4,4,3};
		dutch(nums, 5);
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		

	}

}
