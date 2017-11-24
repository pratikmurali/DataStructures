package com.pratik.datastructures.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {

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

	public static void main(String[] args) {

		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int w = 3;
		//slidingWindowMaximum(a, w);
		slidingWindowMaximumQ(a, w);

	}

}
