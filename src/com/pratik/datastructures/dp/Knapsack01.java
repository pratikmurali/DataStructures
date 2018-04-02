package com.pratik.datastructures.dp;

import java.util.HashMap;
import java.util.Map;

public class Knapsack01 {

	// Key for a Memo map: [Remaining Weight, Remaining Items : Max Value]
	private static class Entry {

		int weight;
		int items;

		Entry(int weight, int items) {
			this.weight = weight;
			this.items = items;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + items;
			result = prime * result + weight;
			return result;
		}

		@Override
		public boolean equals(Object obj) {

			if (this == obj)
				return true;

			if (obj == null)
				return false;

			if (getClass() != obj.getClass())
				return false;

			Entry other = (Entry) obj;

			if (items != other.items)
				return false;

			if (weight != other.weight)
				return false;

			return true;
		}
	}

	public static int knapsack(int W, int[] w, int[] vals) {

		Map<Entry, Integer> memo = new HashMap<>();
		return knapsackHelper(W, w, vals, 0, memo);

	}

	/**
	 * Recursive Knapsack Helper
	 * @param W
	 * @param w
	 * @param vals
	 * @param currentIndex
	 * @param memo
	 * @return
	 */
	private static int knapsackHelper(int W, int[] w, int[] vals, int currentIndex, Map<Entry, Integer> memo) {

		// base case
		if (currentIndex > vals.length - 1 || W <= 0) {
			return 0;
		}

		//Entry of Remaining Weight, Remaining Items
		Entry entry = new Entry(W, w.length - 1 - currentIndex);

		// Check if the value was memoized
		if (memo.containsKey(entry)) {
			return memo.get(entry);
		}

		int maxVal = 0;

		// DON"T PICK: When the weight of the current item is > Remaining weight
		if (w[currentIndex] > W) {
			maxVal = knapsackHelper(W, w, vals, currentIndex + 1, memo);
		} else { // PICK:
			maxVal = Math.max(vals[currentIndex] + knapsackHelper(W - w[currentIndex], w, vals, currentIndex + 1, memo),
					knapsackHelper(W, w, vals, currentIndex + 1, memo));
		}

		memo.put(entry, maxVal);

		return maxVal;

	}
	public static void main(String[] args) {
		
		int[] w = {2,2,4,5};
		int[] v = {2,4,6,9};
		
		System.out.println("Maximum possible value in a Knapsack of weight 8 = "+knapsack(8,w,v));

	}

}
