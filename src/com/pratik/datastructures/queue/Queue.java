package com.pratik.datastructures.queue;

public class Queue<E> {

	private static class Node<E> {

		private E data;
		private Node<E> next;

		public Node(E data) {
			
			super();
			this.data = data;
			this.next = null;
		}

	}

	private Node<E> head; // remove from the head
	private Node<E> tail; // add to the tail.
	private int size = 0;

	/**
	 * Size of the Queue
	 * @return
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Return the top of the queue.
	 * @return
	 */
	public E peek() {

		return head.data;

	}

	/**
	 * Add an item to the queue.
	 * @param data
	 */
	public void add(E data) {

		Node<E> node = new Node<>(data);

		if (tail != null) {
			node.next = tail;
		}

		tail = node;

		if (head == null) {

			head = node;
		}
		
		size++;

	}

	/**
	 * Remove an element from the head.
	 */
	public E remove() {

		E data = head.data;
		head = head.next;

		if (head == null) {

			tail = head;
		}
		
		return data;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
