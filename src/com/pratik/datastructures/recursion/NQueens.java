package com.pratik.datastructures.recursion;

/**
 * 
 * Classic  problem to practice the (choose-explore-unchoose) backtracking paradigm
 * 64*63*62*61*60*59*58*57 choices to place 8 queens.
 * O(n!) time complexity
 * 
 * Some interesting optimizations over here (https://sites.google.com/site/nqueensolver/)
 * DP Approach to N-Queens (http://www.cs.cornell.edu/~rdz/Papers/RZ-IPL92.pdf)
 *
 */

public class NQueens {

	private static char[][] makeBoard(int n) {

		char[][] board = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				board[i][j] = '_';
			}
		}

		return board;

	}

	/**
	 * Function to place a Queen.
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean placeQueen(char[][] board, int row, int col) {

		if (row > board.length || col > board[0].length) {
			return false;
		} else {
			board[row][col] = 'Q';
			return true;
		}
	}

	private static boolean removeQueen(char[][] board, int row, int col) {

		if (row > board.length || col > board[0].length) {
			return false;
		} else {
			board[row][col] = '_';
			return true;
		}

	}

	private static boolean isSafe(char[][] board, int row, int col) {

		// check row attack
		for (int c = 0; c < board[0].length; c++) {
			if (board[row][c] == 'Q') {
				return false;
			}
		}

		// check col attack
		for (int r = 0; r < board.length; r++) {
			if (board[r][col] == 'Q') {
				return false;
			}
		}

		// check left (top) diagonal attack
		// it would suffice to check the left top diagonal (\)
		// because, the recursive solution is structured such that cols
		// are incremented in each recursive call, and the prev cols are allocated 
		// So you can't have a queen attacking from a right top diagonal
		for (int i = row, j = col; j >= 0 && i >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}

		// check left (bottom) diagonal attack.
		// it would suffice to check the left top diagonal (/)
		// because, the recursive solution is structured such that cols
		// are incremented in each recursive call, and the prev cols are allocated 
		// So you can't have a queen attacking from a right top diagonal
		for (int i = row, j = col; i <= board.length - 1 && j >= 0; i++, j--) {

			if (board[i][j] == 'Q') {
				return false;
			}
		}

		return true;

	}

	/**
	 * Utility function to print the chess board.
	 * @param board
	 */
	private static void printBoard(char[][] board) {

		// header
		for (int i = 0; i < board.length; i++) {
			System.out.print("- ");
		}

		System.out.println();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}

			System.out.println();
		}

		// footer
		for (int j = 0; j < board.length; j++) {
			System.out.print("- ");
		}

		System.out.println();
	}

	/**
	 * Call to NQueens
	 * @param board
	 */
	public static void nqueens(char[][] board) {

		nqueensHelper(board, 0);

	}

	//Recursive Helper.
	public static void nqueensHelper(char[][] board, int col) {

		if (col >= board[0].length) {
			printBoard(board);
			return;

		} else {

			for (int row = 0; row < board.length; row++) {

				if (isSafe(board, row, col)) {
					// choose
					placeQueen(board, row, col);
					// explore
					nqueensHelper(board, col + 1);
					// unchoose (backtrack)
					removeQueen(board, row, col);
				}
			}

		}

	}

	/**
	 * Driver function to test N -Queens
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		char[][] board = makeBoard(4);
		nqueens(board);

	}

}
