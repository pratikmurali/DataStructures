package com.pratik.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result;
		Set<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < nums.length - 3; i++) {

			int a = nums[i];
			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {

				int b = nums[i + 1];
				int c = nums[nums.length - 1];

				if (a + b + c == 0) {

					List<Integer> list = new ArrayList<>();
					list.add(a);
					list.add(b);
					list.add(c);
					set.add(list);

					if (b == nums[start + 1]) {
						start++;
					} else {
						end--;
					}
				} else if (a + b + c > 0) {
					end--;
				} else {
					start++;
				}
			}
		}

		result = new ArrayList(set);

		return result;
	}
	
	public static void main() {
		
		int[] nums = {-1, 0, 1, 2, -1, -4};
		
		List<List<Integer>> result = threeSum(nums);
		result.stream().forEach(System.out::println);
	}

}
