package com.pratik.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedGraphCycle {

	private static class Graph {

		private Map<Integer, List<Integer>> adjlistMap;

		public Graph(int size) {
			adjlistMap = new HashMap<>(6);
		}
		
		public void addVertex(int v) {
			ArrayList<Integer> neighbors = new ArrayList<>();
			adjlistMap.put(v,neighbors);
		}

		// Get All Vertices
		public Set<Integer> getAllVertices() {
			return adjlistMap.keySet();
		}

		// Add an Edge
		public void addEdge(int v, int w) {
			if (adjlistMap.containsKey(v))
				adjlistMap.get(v).add(w);
			LinkedList<Integer> list = new LinkedList<>();
			list.add(w);
			adjlistMap.put(v, list);
		}

		// Get Neighbors
		public List<Integer> getNeighbors(int v) {
			return adjlistMap.get(v);
		}

	}

	public static boolean hasCycle(Graph g) {

		Set<Integer> whiteSet = new HashSet<>();
		Set<Integer> graySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();

		for (Integer vertex : g.getAllVertices()) {
			whiteSet.add(vertex);
		}

		while (whiteSet.size() > 0) {

			int current = whiteSet.iterator().next();
			if (dfs(current, whiteSet, graySet, blackSet, g))
				return true;
		}
		return false;
	}

	private static boolean dfs(int current, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet,
			Graph g) {

		moveVertex(current, whiteSet, graySet);

		for (int neighbor : g.getNeighbors(current)) {

			if (blackSet.contains(neighbor)) {
				continue;
			}

			if (graySet.contains(neighbor)) {
				return true;
			}

			if (dfs(neighbor, whiteSet, graySet, blackSet, g)) {
				return true;
			}
		}

		moveVertex(current, graySet, blackSet);
		return false;
	}

	private static void moveVertex(int vertex, Set<Integer> src, Set<Integer> dest) {
		src.remove(vertex);
		dest.add(vertex);
	}

	public static void main(String args[]) throws Exception {

		Graph g = new Graph(6);
		g.addEdge(1, 2);
		g.addVertex(3);
		g.addEdge(2, 3);
		g.addEdge(1, 3);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);

		System.out.println(hasCycle(g));

	}
}