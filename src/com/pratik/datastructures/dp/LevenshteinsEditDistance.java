package com.pratik.datastructures.dp;

/**
 * Classic DP Problem: Levenshteins Edit Distance measures the minimum number of
 * character edits required to change one string to another. This is also known
 * as edit distance.
 *
 */
public class LevenshteinsEditDistance {

	/**
	 * Bottum Up DP for Levenshteins Edit Distance.
	 * @param strWord1
	 * @param strWord2
	 * @return
	 */
	static int levenshteinDistance(String strWord1, String strWord2) {

		int[][] dp = new int[strWord1.length() + 1][strWord2.length() + 1];

		for (int i = 0; i < strWord1.length() + 1; i++) {
			for (int j = 0; j < strWord2.length() + 1; j++) {

				if (i == 0 && j == 0) {
					dp[i][j] = 0;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] + 1;
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] + 1;
				} else {
					//If the characters are equal, just copy down from the diagonal.
					dp[i][j] = (strWord1.charAt(i - 1) == strWord2.charAt(j - 1)) ? dp[i - 1][j - 1]
							: minimum(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
				}
			}
		}
		return dp[strWord1.length()][strWord2.length()];
	}

	/**
	 * Utility method to find the minimum of three elements.
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int minimum(int a, int b, int c) {

		return Math.min(Math.min(a, b), c);

	}

	public static void main(String[] args) {

		System.out.println("Edit Distance for cat and bat is " + levenshteinDistance("cat", "bat"));

	}

}
