package com.pratik.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This returns all the subarrays, which sum to zero, within a given array. 
 * {0} is a valid output.  The idea is to calculate Prefix Sums S[K0---Kn] for the array A[0--n]
 * Store the Prefix Sums in a Map[S[Ki: i]. If you see that the current sum at index j is already
 * in the map, at index i, then the range {i-j} is a zero sum subarray. 
 *
 */
public class SubarrayZeroSum {
	
	
	 /*
     * O(n) solution
     * O(n) space
     */
	static String[] sumZero(int[] intArr) {

		if (intArr.length == 0) {
			return null;
		}

		List<String> result = new ArrayList<>();
		HashMap<Integer, Integer> sums = new HashMap<>();
		int currentSum = 0;

		for (int i = 0; i < intArr.length; i++) {

			currentSum += intArr[i];

			if (currentSum == 0) {
				result.add(formString(intArr, 0, i));
			} else if (sums.get(currentSum) != null) {
				result.add(formString(intArr, sums.get(currentSum) + 1, i));
			} else {
				sums.put(currentSum, i);
			}

		}

		return result.stream().toArray(String[]::new);
	}


	/**
	 * Utility method to pretty-print the sub-array as a string.
	 * @param a
	 * @param oldIndex
	 * @param currIndex
	 * @return
	 */
	static String formString(int[] a, int oldIndex, int currIndex) {

		StringBuilder sb = new StringBuilder();
		// copy all array elements from old index to new index
		int[] arr = Arrays.copyOfRange(a, oldIndex, currIndex + 1);

		if (oldIndex == currIndex) {

			return a[oldIndex] + "";
		}

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ",");
		}

		String res = sb.toString();
		return res.substring(0, res.length() - 1);
	}

	public static void main(String[] args) {
		
		int[] arr = {0,1,2,3,4,-10};
		
		Arrays.stream(sumZero(arr)).forEach(System.out::println);
	}

}
