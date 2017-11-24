package com.pratik.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Fibonacci {

	/**
	 * 
	 * @param limit
	 */
	public static void generateFibonacciIterative(int limit) {

		if (limit == 0) {
			return;
		}

		List<Integer> fibs = new ArrayList<>();
		int fibPrev = 0;
		int fibCurr = 1;
		int fibNext = 0;
		fibs.add(fibPrev);
		fibs.add(fibCurr);

		do {

			fibNext = fibPrev + fibCurr;
			fibs.add(fibNext);
			int temp = fibCurr;
			fibCurr = fibNext;
			fibPrev = temp;
		} while (fibNext <= limit);

		fibs.stream().forEach(System.out::println);
	}

	/**
	 * Print 50th fibonacci number (without memoization) 
	 * 12586269025 
	 * Total execution time: 0 min, 52 sec
	 */
	public static long fibRecursive(long n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibRecursive(n - 1) + fibRecursive(n - 2);
		}

	}

	/**
	 * Print 50th fibonacci number (with memoization) 
	 * 12586269025 
	 * Total execution time: 0 min, 0 sec
	 * 
	 * @param n
	 */
	public static long fibRecursiveMemoized(int n) {
		long[] memo = new long[100];

		for (int i = 0; i < memo.length; i++) {
			memo[i] = -1;
		}
		return fibRecursiveMemoized(n, memo);
	}

	/**
	 * pass the memoized array
	 * 
	 * @param n
	 * @param memo
	 * @return
	 */
	private static long fibRecursiveMemoized(int n, long[] memo) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (memo[n] == -1) {
			memo[n] = fibRecursiveMemoized(n - 1, memo) + fibRecursiveMemoized(n - 2, memo);
		}
		return memo[n];
	}

	public static void main(String[] args) {

		System.out.println("Print Fibonacci numbers till 100");
		generateFibonacciIterative(15);

		System.out.println("Print 50th fibonacci number (without memoization)");
		long startTime = System.nanoTime();
		System.out.println(fibRecursive(50));
		long difference = System.nanoTime() - startTime;
		System.out.println("Total execution time: " + String.format("%d min, %d sec",
				TimeUnit.NANOSECONDS.toHours(difference), TimeUnit.NANOSECONDS.toSeconds(difference)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference))));

		System.out.println("Print 50th fibonacci number (with memoization)");
		long startTime1 = System.nanoTime();
		System.out.println(fibRecursiveMemoized(50));
		long difference1 = System.nanoTime() - startTime1;
		System.out.println("Total execution time: " + String.format("%d min, %d sec",
				TimeUnit.NANOSECONDS.toHours(difference1), TimeUnit.NANOSECONDS.toSeconds(difference1)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference1))));

	}

}
