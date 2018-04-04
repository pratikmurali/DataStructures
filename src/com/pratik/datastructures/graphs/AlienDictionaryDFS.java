package com.pratik.datastructures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Alien Dictionary using DFS based Topological Sort.
 * @author pratikm
 *
 */
public class AlienDictionaryDFS {

	public static class Graph {

		private Stack<Character> reversePost = new Stack<>();
		private Map<Character, List<Character>> adjListMap;
		private boolean visited[];

		public Graph(int size) {

			adjListMap = new HashMap<>(size);
			visited = new boolean[26];

		}

		public int getNumVertices() {
			return adjListMap.keySet().size();
		}

		public void addEdge(char v, char w) {
			if (adjListMap.containsKey(v))
				adjListMap.get(v).add(w);
			LinkedList<Character> list = new LinkedList<>();
			list.add(w);
			adjListMap.put(v, list);
		}

		public void toporder() {

			for (char v : adjListMap.keySet()) {
				if (!visited[v - 'a']) {
					dfs(v);
				}
			}
		}

		public void dfs(char v) {

			visited[v - 'a'] = true;

			if (adjListMap.get(v) != null) {
				for (char w : adjListMap.get(v)) {
					if (!visited[w - 'a']) {
						dfs(w);
					}
				}
			}

			reversePost.push(v);
		}

		public Stack<Character> reversePostOrder() {
			return reversePost;
		}

	}

	/*
	 * Complete the function below.
	 */
	static String find_order(String[] words) {

		// corner case
		if (words.length == 0) {
			return "";
		}

		int graphSize = findUniqueChar(words);

		// Corner case
		if (graphSize == 1) {
			return words[0].charAt(0) + "";
		}

		Graph g = new Graph(graphSize);

		for (int i = 0; i < words.length - 1; i++) {
			addEdgeToGraph(words[i], words[i + 1], g);
		}

		g.toporder();

		StringBuilder sb = new StringBuilder();

		Stack<Character> toporder = g.reversePostOrder();

		while (!toporder.isEmpty()) {
			char c = toporder.pop();
			sb.append(c);
		}

		return sb.toString();
	}

	// Find the size of the alphabet
	static int findUniqueChar(String[] words) {

		Set<Character> set = new HashSet<>();
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				set.add(word.charAt(i));
			}
		}

		return set.size();
	}

	static void addEdgeToGraph(String w1, String w2, Graph g) {

		int length = Math.min(w1.length(), w2.length());
		for (int j = 0; j < length; j++) {
			char c1 = w1.charAt(j);
			char c2 = w2.charAt(j);
			if (c1 != c2) {
				g.addEdge(c1, c2);
				break;
			}
		}
	}

	public static void main(String[] args) {

		String[] words = { "g", "g", "g","g"};
		System.out.println(find_order(words));

	}

}
