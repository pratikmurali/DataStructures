package com.pratik.datastructures.recursion;

public class CountUniquePaths {

	public static void countUniquePaths(int[][] grid) {

		int[] path = new int[8];

		count(grid, 0, 0, path, 0);

	}

	public static void count(int[][] grid, int r, int c, int[] path, int k) {

		int n = grid.length-1;
		int m = grid[0].length-1;

		if (r == n && c == m) {
			printPath(path);
		}

		if (r > n || c > m) {
			return;
		}

		path[k] = grid[r][c];
		count(grid, r + 1, c, path, k+1);
		count(grid, r, c + 1, path, k+1);
	}

	public static void printPath(int[] path) {
		
		//System.out.println(path.length);

		for (int i = 0; i < path.length; i++) {
			System.out.print(" " + path[i]);
		}

		System.out.println();

	}

	public static void main(String[] args) {

		int[][] grid = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		countUniquePaths(grid);

	}

}
