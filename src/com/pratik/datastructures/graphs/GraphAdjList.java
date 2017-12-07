package com.pratik.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphAdjList extends Graph {

	private Map<Integer, ArrayList<Integer>> adjListsMap;

	@Override
	public void implementAddVertex() {

		int v = getNumVertices();
		ArrayList<Integer> neighbors = new ArrayList<>();
		adjListsMap.put(v, neighbors);

	}

	@Override
	public void implementAddEdge(int v, int w) {

		adjListsMap.get(v).add(w);
	}

	@Override
	public List<Integer> getNeighbors(int v) {

		return new ArrayList(adjListsMap.get(v));
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public int getIndegree(int v) {

		int inDegree = 0;

		/**
		 * O(|v^2|) time for a highly connected graph (adj. list) O(|E|) time for a
		 * sparse graph (adj. list)
		 */
		for (int vertex : adjListsMap.keySet()) {

			if (adjListsMap.get(vertex).contains(v))
				inDegree++;

		}

		return inDegree;

	}

	public void topologicalSort() {

		// Create an array to store the indegrees of all the vertices.
		// Initialize all in-dregrees to 0
		int[] indegree = new int[getNumVertices()];

		// Initialize the indegree array for the AdjListsMap

		for (int vertex : adjListsMap.keySet()) {

			indegree[vertex] = getIndegree(vertex);

		}

		// Create a queue and enqueue all vertices with in-degree 0
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < indegree.length; i++) {

			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		// initialize count of visited vertices
		int visited = 0;
		// create an arraylist to store toporder
		ArrayList<Integer> toporder = new ArrayList<>();

		while (!queue.isEmpty()) {

			int v = queue.poll();
			toporder.add(v);

			// Iterate though v's neighbors and decrement their in-degrees by 1
			List<Integer> neighbors = getNeighbors(v);

			for (int neighbor : neighbors) {

				indegree[neighbor]--;
				if (indegree[neighbor] == 0) {
					queue.add(neighbor);
				}
			}
			visited++;
		}

		if (visited != getNumVertices()) {
			System.out.println("There was a cycle in the graph");
		}

		System.out.println("Printing the topological order");
		toporder.stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		


	}

}
