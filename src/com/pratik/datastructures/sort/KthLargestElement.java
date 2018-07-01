package com.pratik.datastructures.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

	/**
	 * Naive approach O(nlog(n))
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int sortAndFind(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[k - 1];

	}

	
	/**
	 * Reduced from O(nlogn) to O(nlogk) because k < n.
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int heapFind(int[] nums, int k) {
		// create a priority queue (min heap) of size K
		PriorityQueue<Integer> queue = new PriorityQueue<>(k);

		//O(klogk)
		for (int i = 0; i < Math.min(nums.length, k); i++) {
			//System.out.println("Adding " + nums[i]);
			queue.offer(nums[i]);
		}

		//O(n-klog(k))
		for (int j = k; j < nums.length; j++) {

			if (nums[j] > queue.peek()) {
				int remove = queue.poll(); //O(logn)
				//System.out.println("Removing " + remove + " and Adding " + nums[j]);
				queue.offer(nums[j]); //O(logn)
			}
		}

		return queue.peek();

	}
	
	/**
	 * Best approach uses O(n) in average case.
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest(int[] nums, int k) {

		if (k < 1 || k > nums.length) {
			throw new IllegalArgumentException("K cannot be greater than length of the array");
		}

		int lo = 0;
		int hi = nums.length - 1;
        k = nums.length - k;  
		
		while (lo < hi) {
			int pivot = partition(nums, lo, hi);

			if (pivot < k) {
				lo = pivot + 1;
			} else if (pivot > k) {
				hi = pivot - 1;
			} else {
				break;
			}
		}

		return nums[k];
	}
	
	private static int partition(int[] nums, int lo, int hi) {

		int i = lo + 1;
		int j = hi;
		int pivot = nums[lo];

		while (true) {

			while (i < j) {

				if (nums[i] < pivot) {
					i++;
				} else {
					break;
				}
			}

			while (j > i) {
				if (nums[j] < pivot) {
					break;
				} else
					j--;
			}

			if (i >= j)
				break;

			// swap
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;

			i++;
			j--;

		}

		nums[lo] = nums[i - 1];
		nums[i - 1] = pivot;

		return i - 1;
	}

	public static void main(String[] args) {

		int[] nums = { 5, 3, 17, 4, 12 };
		//System.out.println("Third Largest element = " + sortAndFind(nums, 3));
		
		//int[] n = { 17, 12, 3, 11, 15, 9, 4, 6, 14 };
		//System.out.println("Fifth Largest element = " + heapFind(n, 5));
		
		int[] n = { 17, 12, 3, 11, 15, 9, 4, 6, 14 };
		System.out.println("Fifth Largest element = " + findKthLargest(n, 5));

	}

}
