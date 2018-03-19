package com.pratik.datastructures.arrays;

import java.util.HashMap;

/**
 * 
 * @author pratikm
 *
 */
public class MajorityElement {
	
	//Method 1: Moore's Voting algorithm O(n) time and O(1) space
	public static int majority1(int[] nums) {

		int counter = 0;
		int current = 0;

		for (int i = 0; i < nums.length; i++) {

			if (counter == 0) {
				current = nums[i];
				counter = 1;
			} else if (nums[i] == current) {
				counter++;
			} else {
				counter--;
			}
		}

		return (counter == 1) ? -1 : current;

	}
	
	//Method 2: using a hashmap (O(n) tiem and O(n) space))
	public static int majority2(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int majority = nums.length >> 1;

		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
				if (map.get(i) > majority) {
					return i;
				}
			}
		}

		return -1;

	}

	public static void main(String[] args) {

		int[] arr_no_maj_element = { 14, 25, 16, 3, 14, 8, 21, 23, 1, 4, 9, 11, 24, 19, 15, 20, 1, 14, 5, 18, 1, 5, 5,
				2, 24 };
		int[] arr_with_maj_element = { 14, 25, 16, 3, 14, 14, 21, 14, 14, 14, 14, 14, 14, 14, 15, 20, 1, 13, 14, 14, 14,
				5, 5, 2, 24 };

		System.out.println(majority1(arr_no_maj_element));
		System.out.println(majority2(arr_no_maj_element));
		System.out.println(majority1(arr_with_maj_element));
		System.out.println(majority2(arr_with_maj_element));

	}

}
