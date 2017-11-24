package com.pratik.datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Contact List with a Prefix based search implemented using
 *  a Trie.
 * @author pratikm
 *
 */
public class TrieContactList {

	private static class TrieNode {

		boolean isWord;
		String contact;
		Map<Character, TrieNode> children;

		TrieNode() {

			children = new HashMap<>();
			isWord = false;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public boolean isWord() {
			return isWord;
		}

		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}

		public Map<Character, TrieNode> getChildren() {
			return children;
		}

		public void setChildren(Map<Character, TrieNode> children) {
			this.children = children;
		}

	}

	private TrieNode root = null;

	public TrieContactList() {

		this.root = new TrieNode();
	}

	/**
	 * Add a contact
	 * 
	 * @param word
	 */
	public void insertContact(String word) {

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

		curr.setWord(true);
		curr.setContact(word);

	}

	/**
	 * Find the stem/prefix and then do a breadth first search to find all contacts.
	 * (Kind of like autocomplete).
	 * 
	 * @param prefix
	 * @return
	 */
	public List<String> findContact(String prefix) {

		TrieNode curr = root;
		List<String> contacts = new ArrayList<>();

		//Iterate through the prefix.
		for (int i = 0; i < prefix.length(); i++) {

			char ch = prefix.charAt(i);
			TrieNode node = curr.getChildren().get(ch);
			if (node == null) {
				return contacts;
			}
			
			curr = node;
		}
		
		Queue<TrieNode> queue = new LinkedList<>();
		queue.add(curr);

		while (!queue.isEmpty()) {

			TrieNode n = queue.poll();
			if ((n != null) && n.isWord()) {
				contacts.add(n.getContact());
			}
			// Add all the child nodes
			queue.addAll(n.getChildren().values());
		}

		return contacts;

	}

	/**
	 * Print the contents of the Trie
	 */
	public void printTrie() {

		TrieNode curr = root;

		Queue<TrieNode> queue = new LinkedList<>();
		queue.add(curr);

		while (!queue.isEmpty()) {

			TrieNode node = queue.poll();
			if (node != null && node.isWord) {
				System.out.println(node.getContact());
			}

			queue.addAll(node.getChildren().values());
		}

	}

	public static void main(String[] args) {
		TrieContactList contactList = new TrieContactList();

		contactList.insertContact("Pratik");
		contactList.insertContact("Preetham");
		contactList.insertContact("Prathima");
		contactList.insertContact("Priyanka");
		contactList.insertContact("Priscillia");
		contactList.insertContact("Alexa");
		contactList.insertContact("Alex");
		contactList.insertContact("Alexis");
		contactList.insertContact("Alexander");
		contactList.insertContact("Alexia");
		contactList.insertContact("Alexandria");
		
		System.out.println("Printing all contacts");

		contactList.printTrie();
		
		System.out.println("Printing all contacts with prefix Prat");
		
		List<String> contacts1 = contactList.findContact("Prat");
		
		contacts1.forEach(System.out::println);
		
		System.out.println("Printing all contacts with prefix Pri");

        List<String> contacts2 = contactList.findContact("Pri");
		
		contacts2.forEach(System.out::println);
		
		System.out.println("Printing all contacts with prefix Alexa");

        List<String> contacts3 = contactList.findContact("Alexa");
		
		contacts3.forEach(System.out::println);

	}

}
