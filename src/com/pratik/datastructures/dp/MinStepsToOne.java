package com.pratik.datastructures.dp;

import java.util.Arrays;

/**
 * The goal is to reduce a number 'n' to 1 in minimum number of steps.
 * The available steps to do so are:
 * You can reduce n by 1, i.e. (n-1)
 * if (n%2 == 0)  n/2
 * if( n%3 == 0) n/3
 * 
 * This is a simple example which clearly shows that Greedy typically results in
 * a Feasible solution which is not necessarily optimal. DP on the other hand
 * always picks optimal.	 Coversion of Top Down DP -> Bottum Up DP is also easy
 * to understand in this example.
 * @author pratikm
 *
 */
public class MinStepsToOne {
	
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int minStepsGreedy(int n) {
		
		//5->4(1)->2(2)->3: FEASIBLE AND OPTIMAL
		//10->5(1)->4(2)->2(3)->1(4) :FEASIBLE
		//10->9(1)->3(2)->1(3) :OPTIMAL
		
		int steps = 0;
		
		while (n > 1) {

			if (n % 2 == 0) {
				n /= 2;
			} else if (n % 3 == 0) {
				n /= 3;
			} else
				n--;

			steps++;
		}
		
		return steps;
		
	}
	
	/**
	 * Top Down with Memoization
	 * @param n
	 * @return
	 */
	public static int minStepsDynamic(int n) {

		int[] memo = new int[n + 1];

		return minStepsDynamicHelper(n, memo);
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int minStepsDynamicHelper(int n, int[] memo) {

		if (n == 1) {
			return 0;
		}

		if (memo[n] > 0) {
			return memo[n];
		}

		int ans = 1 + minStepsDynamicHelper(n - 1, memo);

		if (n % 2 == 0) {
			ans = Math.min(ans, 1 + minStepsDynamicHelper(n / 2, memo));
		}

		if (n % 3 == 0) {
			ans = Math.min(ans, 1 + minStepsDynamicHelper(n / 3, memo));
		}

		memo[n] = ans;

		return ans;
	}
	
	/**
	 * Bottom up approach
	 * @param n
	 * @return
	 */
	public static int minStepsDynamicTable(int n) {

		int[] dp = new int[n + 1];

		// base case
		dp[1] = 0;

		for (int i = 2; i <= dp.length - 1; i++) {

			int ans = 1 + dp[i - 1];

			if (i % 2 == 0) {
				ans = Math.min(ans, 1 + dp[i / 2]);
			}

			if (i % 3 == 0) {
				ans = Math.min(ans, 1 + dp[i / 3]);
			}

			dp[i] = ans;
		}

		//Uncomment to see what the DP array looks like.
		//Arrays.stream(dp).forEach(System.out::print);
		return dp[n];
	}
	

	public static void main(String[] args) {
		
		//Feasible Solutions with Greedy approach
		System.out.println(minStepsGreedy(5));
		System.out.println(minStepsGreedy(10));
		
		//Optimal Solutions with DP approach
		System.out.println(minStepsDynamic(5));
		System.out.println(minStepsDynamic(10));
		
		//Optimal Solutions with DP approach
		System.out.println(minStepsDynamicTable(5));
		System.out.println(minStepsDynamicTable(10));
	

	}

}
