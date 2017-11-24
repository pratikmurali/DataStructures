package com.pratik.datastructures.trie;

import java.util.HashMap;

public class Trie {

	public static class TrieNode {

		boolean isWord;
		String text;
		HashMap<Character, TrieNode> children;

		public TrieNode() {
			super();
			this.children = new HashMap<>();
			this.isWord = false;
		}

		public boolean isWord() {
			return isWord;
		}

		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}

		public HashMap<Character, TrieNode> getChildren() {
			return children;
		}

		public void setChildren(HashMap<Character, TrieNode> children) {
			this.children = children;
		}

	}

	private TrieNode root = null;

	public Trie() {

		root = new TrieNode();
	}

	/**
	 * Insert a word into the trie.
	 * 
	 * @param word
	 */
	public void insert(String word) {

		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {

			char ch = word.charAt(i);
			TrieNode node = curr.getChildren().get(ch);

			if (node == null) {
				node = new TrieNode();
				curr.getChildren().put(ch, node);
			}

			curr = node;

		}

		curr.isWord = true;

	}

	/**
	 * Recursive Insert implementation
	 * 
	 * @param word
	 */
	public void insertRecursive(String word) {

		insertRecursive(root, word, 0);

	}

	private void insertRecursive(TrieNode curr, String word, int index) {

		if (index == word.length()) {
			curr.isWord = true;
			return;
		}

		char ch = word.charAt(index);
		TrieNode node = curr.getChildren().get(ch);

		if (node == null) {
			node = new TrieNode();
			curr.getChildren().put(ch, node);
		}

		insertRecursive(node, word, index + 1);
	}

	/**
	 * Search through a Trie.
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {

		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {

			char ch = word.charAt(i);

			TrieNode node = curr.getChildren().get(ch);

			if (node == null) {
				return false;
			}
			curr = node;
		}

		return curr.isWord;

	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public boolean delete(String word) {

		return delete(root, word, 0);
	}

	private static boolean delete(TrieNode curr, String word, int index) {

		if (index == word.length()) {
			if (!curr.isWord) {
				return false;
			}
			curr.setWord(false);
			return curr.getChildren().size() == 0;
		}

		char ch = word.charAt(index);
		TrieNode node = curr.getChildren().get(ch);
		if (node == null) {
			return false;
		}

		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		if (shouldDeleteCurrentNode) {
			curr.children.remove(ch);
			return (curr.getChildren().size() == 0);
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
