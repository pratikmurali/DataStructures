package com.pratik.datastructures.hybrid;

import java.util.HashMap;
import java.util.Map;

/**
 * Put O(1)
 * Delete O(1)
 * Get O(1)
 * @author pratikm
 *
 */
public class LRUCache {

	private int maxCacheSize;
	private Map<Integer, LinkedListNode> map = new HashMap<>();
	private LinkedListNode head = null;
	private LinkedListNode tail = null;

	private static class LinkedListNode {
		private int key;
		private String val;
		private LinkedListNode next;
		private LinkedListNode prev;

		public LinkedListNode(int key, String value) {
			this.key = key;
			this.val = value;
		}
	}

	private void insertInFront(LinkedListNode node) {

		if (head == null) {
			head = node;
			tail = node;
		} else {
			head.prev = node;
			node.next = head.next;
			head = node;
		}
	}

	private void removeFromList(LinkedListNode node) {

		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;
		if (node == tail)
			tail = node.prev;
		if (node == head)
			head = node.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void LRUCache(int maxSize) {
		maxCacheSize = maxSize;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String get(int key) {

		LinkedListNode item = map.get(key);

		// Ensure MRU property
		if (item != head) {
			removeFromList(item);
			insertInFront(item);
		}

		return item.val;

	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean removeKey(int key) {

		LinkedListNode item = map.get(key);
		removeFromList(item);
		map.remove(key);
		return true;

	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, String value) {

		removeKey(key);
		// Remove the LRU key when cache is full
		if (map.size() == maxCacheSize && tail != null) {
			removeKey(tail.key);
		}

		// Insert new node
		LinkedListNode node = new LinkedListNode(key, value);
		map.put(key, node);
		insertInFront(node);

	}

}
