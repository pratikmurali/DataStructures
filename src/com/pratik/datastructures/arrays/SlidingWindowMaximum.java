package com.pratik.datastructures.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {

	/**
	 * O(n^2) solutions.
	 * @param a
	 * @param w
	 */
	public static void slidingWindowMaximum(int[] a, int w) {

		int max = a[0];
		int[] b = new int[w];

		for (int i = 0; i <= a.length - w; i++) {
			for (int j = i; j <= i + w - 1; j++) {

				b[j - i] = a[j];
				if (a[j] > max) {
					max = a[j];
				}

			}

			Arrays.stream(b).forEach(System.out::print);
			System.out.println(" Max in this window " + max);
			reset(b);
		}

	}
	
	/**
	 * Same O(n^2) solution using a Queue.
	 * @param a
	 * @param w
	 */
	public static void slidingWindowMaximumQ(int[] a, int w) {

		int max = a[0];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i <= a.length - w; i++) {

			for (int j = i; j <= i + w - 1; j++) {
				q.add(a[j]);
				if (a[j] > max) {
					max = a[j];
				}
			}

			q.stream().forEach(System.out::print);
			System.out.println(" Max in this window " + max);
			q.clear();

		}

	}

	public static void reset(int[] b) {

		for (int i = 0; i < b.length; i++) {
			b[i] = 0;
		}
	}
	
	/**
	 * Optimal O(n) solution which makes clever use of a Deque.
	 * @param a
	 * @param w
	 * @return
	 */
	public static int[] slidingWindowMaximumDeque(int[] a, int w) {

		int n = a.length;
		// Number of windows = (n-k+1)
		int[] result = new int[n - w + 1];

		// Deque for storing indices.
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {

			// Remove the head of the queue (max) once the window slides out of range.
			if (!deque.isEmpty() && (i - w + 1) > deque.peek()) {
				deque.pollFirst();
			}

			// Remove the back of the queue if its lesser than the incoming element.
			while (!deque.isEmpty() && a[deque.peekLast()] <= a[i]) {
				deque.pollLast();
			}

			deque.offer(i);

			if (i - w + 1 >= 0) {

				result[i - w + 1] = a[deque.peek()];

			}

		}

		return result;
	}

	public static void main(String[] args) {

		//int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		//int w = 3;
		int[] a = {7,2,4};
		int w = 2;
		//slidingWindowMaximum(a, w);
		slidingWindowMaximumQ(a, w);
		
		System.out.println("Result using a Deque");
		Arrays.stream(slidingWindowMaximumDeque(a,w)).forEach(System.out::print);

	}

}
