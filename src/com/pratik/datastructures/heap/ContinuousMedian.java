package com.pratik.datastructures.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ContinuousMedian {

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static double[] getMedians(int[] arr) {

		// Max heap
		PriorityQueue<Integer> lower = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return -1 * i1.compareTo(i2);
			}
		});

		// Min Heap
		PriorityQueue<Integer> higher = new PriorityQueue<>();
		double[] medians = new double[arr.length];

		for (int i = 0; i < arr.length; i++) {

			int number = arr[i];
			addNumber(number, lower, higher);
			rebalance(lower, higher);
			medians[i] = getMedian(lower, higher);
		}

		return medians;
	}

	/**
	 * 
	 * @param number
	 * @param lower
	 * @param higher
	 */
	private static void addNumber(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {

		if (lower.size() == 0 || number < lower.peek()) {
			lower.add(number);
		} else {
			higher.add(number);
		}
	}

	/**
	 * 
	 * @param lower
	 * @param higher
	 */
	private static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {

		PriorityQueue<Integer> bigger = (lower.size() > higher.size()) ? lower : higher;
		PriorityQueue<Integer> smaller = (lower.size() > higher.size()) ? higher : lower;

		if (bigger.size() - smaller.size() >= 2) {

			smaller.add(bigger.poll());
		}

	}

	/**
	 * 
	 * @param lower
	 * @param higher
	 * @return
	 */
	private static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {

		PriorityQueue<Integer> bigger = (lower.size() > higher.size()) ? lower : higher;
		PriorityQueue<Integer> smaller = (lower.size() > higher.size()) ? higher : lower;
		double median;

		if (bigger.size() == smaller.size()) {

			median = ((double) bigger.peek() + smaller.peek()) / 2;

		} else {

			median = (double) bigger.peek();
		}

		return median;
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		int[] arr = new int[count + 1];

		for (int i = 0; i < count; i++) {
			String nextInt = sc.nextLine();
			arr[i] = Integer.parseInt(nextInt);
		}

		double[] medians = getMedians(arr);

		for (int i = 0; i < medians.length; i++) {

			System.out.println(medians[i]);
		}
	}
}