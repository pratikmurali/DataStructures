package com.pratik.datastructures.dp;

/**
 * Find Unique path in a grid with obstacles.
 * @author pratikm
 *
 */
public class UniquePathsII {

	/*
	 * Bottom up solution.
	 */
	public static int uniquePathsWithObstacles(int[][] gridWithObstacles) {

		int m = gridWithObstacles.length;
		int n = gridWithObstacles[0].length;

		int[][] DP = new int[m + 1][n + 1];
		DP[m - 1][n] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				DP[i][j] = (gridWithObstacles[i][j] == 1) ? 0 : DP[i + 1][j] + DP[i][j + 1];
			}
		}

		return DP[0][0];

	}

	public static void main(String[] args) {

		int[][] gridWithObstacles = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println("Number of paths = " + uniquePathsWithObstacles(gridWithObstacles));

	}

}
