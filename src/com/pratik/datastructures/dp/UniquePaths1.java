package com.pratik.datastructures.dp;

/**
 * Count all paths from start to finish.
 * @author pratikm
 *
 */
public class UniquePaths1 {

	public static int countPathsRecursive(int m, int n) {

		int[][] memo = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				memo[i][j] = -1;
			}
		}
		return helper(m, n, 0, 0, memo);
	}

	/**
	 * Memoized Recursive version
	 * 
	 * @param m
	 * @param n
	 * @param r
	 * @param c
	 * @param memo
	 * @return
	 */
	private static int helper(int m, int n, int r, int c, int[][] memo) {

		if (r >= m || c >= n) {
			return 0;
		}

		if (r + 1 == m && c + 1 == n) {
			return 1;
		}

		if (memo[r][c] == -1)
			memo[r][c] = helper(m, n, r + 1, c, memo) + helper(m, n, r, c + 1, memo);

		return memo[r][c];

	}

	/**
	 * Building a bottom up DP table.
	 * @param m
	 * @param n
	 * @return
	 */
	public static int countPathsDP(int m, int n) {

		int[][] DP = new int[m + 1][n + 1];

		DP[m - 1][n] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				DP[i][j] = DP[i + 1][j] + DP[i][j + 1];
			}
		}

		return DP[0][0];

	}

	public static void main(String[] args) {

		System.out.println(countPathsRecursive(4, 4));

		System.out.println(countPathsDP(4, 4));
	}

}
