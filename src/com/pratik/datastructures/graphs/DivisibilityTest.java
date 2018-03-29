package com.pratik.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Disguised Graph (BFS) based problem 
 * 
 *
 */
public class DivisibilityTest {
	
	private static class Edge {
		
		String destination;
		double weight;
		
		Edge(String destination, double weight) {
			
			this.destination = destination;
			this.weight = weight;
		}
	}

	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		double[] result = new double[queries.length];

		Map<String, List<Edge>> map = new HashMap<>();

		int i = 0;
		// Go through all the rows of equations
		for (String[] e : equations) {

			List<Edge> edges0 = map.getOrDefault(e[0], new ArrayList<>());
			List<Edge> edges1 = map.getOrDefault(e[1], new ArrayList<>());

			Edge e0 = new Edge(e[1], values[i]); // forward edge
			Edge e1 = new Edge(e[0], 1 / values[i]); // back-edge

			edges0.add(e0);
			edges1.add(e1);

			map.put(e[0], edges0);
			map.put(e[1], edges1);

			i++;

		}

		for (int j = 0; j < queries.length; j++) {

			String src = queries[j][0];
			String dst = queries[j][1];
			Set<String> visited = new HashSet<>();
			visited.add(src);
			result[j] = dfsRecursive(map, visited, src, dst, 1.0);

		}

		return result;
	}
	
	
	private static double dfsIterative(Map<String, List<Edge>> map, String src, String dst) {

		if (!map.containsKey(src)) {
			return -1.0;
		}

		Set<String> visited = new HashSet<>();
		visited.add(src);
		Stack<String> s = new Stack<>();
		s.push(src);

		double distance = 1.0;

		while (!s.isEmpty()) {

			String tmp = s.pop();

			List<Edge> list = map.get(tmp);

			for (Edge e : list) {
				if (!visited.contains(e.destination)) {

					if (!src.equals(e.destination)) {
						distance *= e.weight;
					} else {
						return distance;
					}
					visited.add(e.destination);
					s.push(e.destination);
				}
			}

		}

		return distance;

	}
	
	
	private static double dfsRecursive(Map<String, List<Edge>> map, Set<String> visited, String src, String dst,
			double distance) {

		if (!map.containsKey(src)) {
			return -1.0;
		}

		if (src.equals(dst)) {
			return distance;
		}

		List<Edge> list = map.get(src);

		for (Edge e : list) {
			if (!visited.contains(e.destination)) {
				visited.add(e.destination);
				double result = dfsRecursive(map,visited,e.destination,dst,e.weight*distance);
				if(result != -1.0) {
					return result;
				}
			}
		}
		return -1.0;

	}

	public static void main(String[] args) {
		
		String[][] equations = { {"a", "b"}, {"b", "c"} };
		double[]  values = {2.0, 3.0};
		String[][] queries = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
		

		double[] result = calcEquation(equations, values, queries);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+", ");
		}
	}

}
