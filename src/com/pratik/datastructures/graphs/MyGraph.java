package com.pratik.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MyGraph {

	private Map<Integer, ArrayList<Integer>> adjListsMap;
	private int numVertices;
	private int numEdges;

	public MyGraph() {

			numVertices = 0;
			numEdges = 0;
			adjListsMap = new HashMap<>();
		}

	/**
	 * 
	 * @param v
	 */
	public void addVertex(int v) {
		adjListsMap.put(v, new ArrayList<Integer>());
		numVertices++;
	}

	/**
	 * 
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adjListsMap.get(v).add(w);
		numEdges++;
	}

	/**	
	 * 
	 * @param v
	 * @return
	 */
	public List<Integer> getNeighbors(int v) {
		// return a copy of the neighbors list.
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

	public int getNumVertices() {

		return numVertices;
	}

	public int getNumEdges() {

		return numEdges;
	}
	
	public void dfs() {
		
		boolean[] visited = new boolean[getNumVertices()];
		
		for(int i = 0; i < getNumVertices(); i++) {
			
			if(!visited[i]) {
				dfs(i, visited);
			}
		}
		
	}
	
	private void dfs(int v, boolean[] visited) {
		
		visited[v] = true;
		System.out.println("Visiting "+v);
		
		for(int neighbor: getNeighbors(v)) {
			if(!visited[neighbor]) {
				dfs(neighbor,visited);
			}
		}
		
		
	}

	/**
	 * Topological Sort of a Graph.
	 */
	public void topologicalSort() {

		// Create an array to store the indegrees of all the vertices.
		// Initialize all in-dregrees to 0
		int[] indegree = new int[getNumVertices()];

		// Initialize the indegree array for the AdjListsMap

		for (int vertex : adjListsMap.keySet()) {

			indegree[vertex] = getIndegree(vertex);

		}
		
		// initialize count of visited vertices
			int visited = 0;

		// Create a queue and enqueue all vertices with in-degree 0
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < indegree.length; i++) {

			if (indegree[i] == 0) {
				queue.add(i);
				visited++;
			}
		}

		
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

		System.out.println("Priting the topological order");
		toporder.stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		
		MyGraph graph = new MyGraph();
		graph.addVertex(0);//Algorithms
		graph.addVertex(1);//Complexity Theory
		graph.addVertex(2);//AI
		graph.addVertex(3);//Intro to CS
		graph.addVertex(4);//Cryptography
		graph.addVertex(5);//Scientific Computing
		graph.addVertex(6);//Advanced Programming
		
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 4);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(3, 4);
		graph.addEdge(5, 2);
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		
		graph.topologicalSort();
		
		graph.dfs();

	}

}
