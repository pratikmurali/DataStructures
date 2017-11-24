package com.pratik.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrix extends Graph {
	
	private int[][] adjMatrix;

	@Override
	public void implementAddVertex() {

		int v = getNumVertices();

		// Resize the matrix
		if (v >= adjMatrix.length) {
			int[][] newAdjMatrix = new int[v * 2][v * 2];
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix.length; j++) {
					newAdjMatrix[i][j] = adjMatrix[i][j];
				}
			}
			// Re-assign references
			adjMatrix = newAdjMatrix;
		}

		for (int i = 0; i < adjMatrix[v].length; i++) {
			adjMatrix[v][i] = 0;
		}

	}

	@Override
	public List<Integer> getNeighbors(int v) {

		List<Integer> neighbors = new ArrayList<>();

		for (int i = 0; i < getNumVertices(); i++) {
			if (adjMatrix[5][i] == 1) {
				neighbors.add(i);
			}
		}

		return neighbors;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementAddEdge(int v, int w) {
		
		adjMatrix[v][w] = 1;
		
	}

}
