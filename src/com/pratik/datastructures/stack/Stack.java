package com.pratik.datastructures.stack;

public class Stack<E> {

	private static class Node<E> {

		private E data;
		private Node<E> next;

		public Node(E data) {

			super();
			this.data = data;
			this.next = null;
		}

	}

	private Node<E> top;// Add and Remove from the Top.

	public boolean isEmpty() {

		return top == null;

	}

	public E peek() {

		return top.data;
	}

	public void push(E data) {

		Node node = new Node(data);
		node.next = top;
		top = node;

	}

	public E pop() {

		E data = top.data;
		top = top.next;
		return data;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
