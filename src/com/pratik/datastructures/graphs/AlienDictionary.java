package com.pratik.datastructures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given a lexicographically sorted dictionary (array of words) of an alien
 * language, find order of alphabets in the language Input: words[] = {"baa",
 * "abcd", "abca", "cab", "cad"} Output: Order of characters is 'b', 'd', 'a',
 * 'c'
 */

public class AlienDictionary {

	public static String alienOrder(String[] words) {

		// Build an adjacency matrix representation of the characters in a graph
		Map<Character, Set<Character>> graph = new HashMap<>();
		// Build a map to store the indegrees of the characters
		Map<Character, Integer> indegree = new HashMap<>();

		// Initialize the indegree map for all the characters.
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (!indegree.containsKey(c)) {
					indegree.put(c, 0);
				}
			}
		}

		// build a graph
		// Compare pairs of adjacent words.
		// Find the first differing character and add it as a neighbor to the graph.
		// Increment the indegree of the neighbbor.

		for (int i = 0; i < words.length - 1; i++) {

			String currWord = words[i];
			String nextWord = words[i + 1];

			int length = Math.min(words[i].length(), words[i + 1].length());

			for (int j = 0; j < length; j++) {

				char c1 = currWord.charAt(j);
				char c2 = nextWord.charAt(j);

				if (c1 != c2) {

					// add a vertex from c1 to c2
					if (graph.containsKey(c1)) {
						graph.get(c1).add(c2);
					}
//					} else {
//						Set<Character> set = new HashSet<>();
//						set.add(c2);
//						graph.put(c1,set);
//					}
					// increment the indegree of c2
					indegree.put(c2, indegree.get(c2) + 1);
					// break since you found first differing character.
					break;
				}
			}

		}

		// Do a topological sort on the graph.

		Queue<Character> queue = new LinkedList<>();
		// add all characters with indegree 0
		for (char ch : indegree.keySet()) {
			if (indegree.get(ch) == 0) {
				queue.add(ch);
			}
		}

		int visited = 0;
		StringBuilder toporder = new StringBuilder();

		while (!queue.isEmpty()) {

			char ch = queue.poll();
			toporder.append(ch);

			if (graph.containsKey(ch)) {
				Set<Character> neighbors = graph.get(ch);
				for (Character neighbor : neighbors) {
					if (indegree.get(neighbor) == 0) {
						queue.add(neighbor);
					} else {
						indegree.put(neighbor, indegree.get(neighbor) - 1);
					}
				}
			}

			visited++;
		}

		if (visited != indegree.size()) {
			return "";
		}

		return toporder.toString();
	}

	public static void main(String[] args) {

		String[] alienDictionary = { "baa", "abcd", "abca", "cab", "cad" };

		System.out.println("The order of the alphabet in the alien language =" + alienOrder(alienDictionary));

	}

}
