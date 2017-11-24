package com.pratik.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static int[] twoSum(int[] arr, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];

		for (int i = 0; i < arr.length; i++) {

			int data = arr[i];
			if (map.containsKey(target - data)) {

				result[0] = i + 1;
				result[1] = map.get(target - data);

			} else {

				map.put(data, i);

			}

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
