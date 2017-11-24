package com.pratik.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Queue<String> q = new LinkedList<>();
		List<String> ladder = new ArrayList<>();
		ListIterator<String> it = wordList.listIterator();
		q.add(beginWord);
		ladder.add(beginWord);

		// bfs
		while (!q.isEmpty()) {

			String word = q.poll();

			if (word.equals(endWord)) {
				return ladder.size();
			}

			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {

				for (char c = 'a'; c <= 'z'; c++) {
					char tmp = arr[i];
					arr[i] = c;
					String check = new String(arr);
					if (wordList.contains(check)) {
						q.add(check);
						ladder.add(check);
					} else {
						arr[i] = tmp;
					}

				}

			}

		}

		return 0;

	}

	public static void main(String[] args) {

		String[] a = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> words = new ArrayList<>();
		words.add("hot");
		words.add("dot");
		words.add("dog");
		words.add("lot");
		words.add("log");
		words.add("cog");

		String beginWord = "hit";
		String endWord = "cog";

		System.out.println(" The word ladder length =" + ladderLength(beginWord, endWord, words));

	}

}
