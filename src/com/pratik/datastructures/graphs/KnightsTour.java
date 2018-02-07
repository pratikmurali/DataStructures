package com.pratik.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Find the shortest path taken by a Knight on a chessboard from a starting square to a 
 * destination.
 * @author pratikm
 *
 */

public class KnightsTour {

	static class BoardSquare {

		private int row;
		private int col;
		private Set<BoardSquare> neighbors;

		public BoardSquare(int row, int col) {
			this.row = row;
			this.col = col;
			neighbors = new HashSet<>();
		}

		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}

		/**
		 * Check if a move falls out of the board.
		 * @param square
		 * @param limit
		 * @return
		 */
		private boolean isLegitSquare(BoardSquare square, BoardSquare limit) {
			if (square.getCol() >= 0 && square.getCol() <= limit.getCol() && square.getRow() >= 0
					&& square.getRow() <= limit.getRow()) {
				return true;
			}

			return false;
		}

		/**
		 * All possible moves a Knight can make. 8 Moves.
		 * @param vertex
		 * @param limit
		 * @return a set of neighbors to prevent duplicate squares.
		 */
		public Set<BoardSquare> getNeighbors(BoardSquare vertex, BoardSquare limit) {

			BoardSquare topRight = new BoardSquare(vertex.getRow() + 2, vertex.getCol() + 1);
			BoardSquare topLeft = new BoardSquare(vertex.getRow() + 2, vertex.getCol() - 1);
			BoardSquare bottomRight = new BoardSquare(vertex.getRow() - 2, vertex.getCol() + 2);
			BoardSquare bottomLeft = new BoardSquare(vertex.getRow() - 2, vertex.getCol() + 1);
			BoardSquare topMidRight = new BoardSquare(vertex.getRow() + 1, vertex.getCol() + 2);
			BoardSquare topMidLeft = new BoardSquare(vertex.getRow() + 1, vertex.getCol() - 2);
			BoardSquare botMidRight = new BoardSquare(vertex.getRow() - 1, vertex.getCol() + 2);
			BoardSquare botMidLeft = new BoardSquare(vertex.getRow() - 1, vertex.getCol() - 2);

			if (isLegitSquare(topRight, limit)) {
				neighbors.add(topRight);
			}

			if (isLegitSquare(topLeft, limit)) {
				neighbors.add(topLeft);
			}

			if (isLegitSquare(bottomRight, limit)) {
				neighbors.add(bottomRight);
			}

			if (isLegitSquare(bottomLeft, limit)) {
				neighbors.add(bottomLeft);
			}

			if (isLegitSquare(topMidRight, limit)) {
				neighbors.add(topMidRight);
			}

			if (isLegitSquare(topMidLeft, limit)) {
				neighbors.add(topMidLeft);
			}

			if (isLegitSquare(botMidRight, limit)) {
				neighbors.add(botMidRight);
			}

			if (isLegitSquare(botMidLeft, limit)) {
				neighbors.add(botMidLeft);
			}

			return neighbors;

		}

		@Override
		public boolean equals(Object o) {

			if (o == this)
				return true;
			if (!(o instanceof BoardSquare)) {
				return false;
			}
			BoardSquare sq = (BoardSquare) o;
			return (sq.row == row && sq.col == col);
		}

		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + row;
			result = 31 * result + col;
			return result;
		}

		@Override
		public String toString() {
			return "{ " + row + "," + col + " }";
		}

	}

	/*
	 * Complete the function below.
	 */
	public static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row,
			int end_col) {

		BoardSquare limit = new BoardSquare(rows - 1, cols - 1);
		BoardSquare startSquare = new BoardSquare(start_row, start_col);
		BoardSquare endSquare = new BoardSquare(end_row, end_col);

		return findMinimumMoves(startSquare, endSquare, limit);

	}

	/**
	 * Regular BFS, to find shortest path, print it and return its length.
	 * @param start
	 * @param end
	 * @param limit
	 * @return
	 */
	private static int findMinimumMoves(BoardSquare start, BoardSquare end, BoardSquare limit) {

		Queue<BoardSquare> q = new LinkedList<>();
		HashSet<BoardSquare> visited = new HashSet<>();
		Map<BoardSquare, BoardSquare> parentMap = new HashMap<>();
		q.add(start);
		visited.add(start);

		while (!q.isEmpty()) {

			BoardSquare sq = q.poll();
			if (sq.equals(end)) {

				if (sq.equals(end)) {

					List<BoardSquare> shortestPath = new ArrayList<>();
					BoardSquare curr = end;
					while (curr != null) {
						shortestPath.add(curr);
						curr = parentMap.get(curr);
					}

					Collections.reverse(shortestPath);
					shortestPath.stream().forEach(System.out::println);
					return shortestPath.size() - 1;
				}
			}

			for (BoardSquare neighbor : sq.getNeighbors(sq, limit)) {

				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					//(visited_node, where_you_came_from)
					parentMap.put(neighbor, sq);
					q.add(neighbor);
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) {

		// System.out.println(find_minimum_number_of_moves(5, 5, 0, 0, 4, 1));
		System.out.println(find_minimum_number_of_moves(5, 5, 1, 1, 4, 4));

	}

}
