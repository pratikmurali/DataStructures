package com.pratik.datastructures.lists;

public class LinkedList<E extends Comparable<E>> {

	private static class Node<E extends Comparable<E>> implements Comparable<Node<E>> {

		private E val;
		private Node<E> next;

		Node(E val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}

		@Override
		public int compareTo(Node<E> node) {
			return node.val.compareTo(this.val);
		}
	}

	private Node<E> head;
	private int size = 0;

	public LinkedList() {
		super();
		head = null;
	}

	/**
	 * Add to the front of the list.
	 * 
	 * @param val
	 */
	public void insert(E val) {

		Node<E> n = new Node(val);
		n.next = head;
		head = n;
		size++;

	}

	/**
	 * Remove an element from anywhere in the list.
	 * 
	 * @param val
	 */
	public void remove(E val) {

		Node<E> curr = head;

		if (head == null) {
			return;
		}

		if (head.val == val) {
			head = head.next;
			return;
		}

		while (curr.next != null) {

			if (curr.next.val == val) {
				curr.next = curr.next.next;
				size--;
				return;
			}

			curr = curr.next;
		}

	}

	/**
	 * List the list.
	 */
	public void list() {

		Node<E> curr = head;

		while (curr.next != null) {
			System.out.println(curr);
			curr = curr.next;
		}

	}
	
	/**
	 * Merge two linked lists using a dummyhead.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public Node<E> mergeLists(Node l1, Node l2) {

		Node<E> dummyHead = new Node(0);
		Node<E> p = dummyHead;

		while (l1 != null && l2 != null) {

			if (l1.val.compareTo(l2.val) < 0) {
				p.next = l1;
				l1 = l1.next;
			} else {

				p.next = l2;
				l2 = l2.next;
			}
		}

		if (l1 != null)
			p.next = l1;
		if (l2 != null)
			p.next = l2;

		return dummyHead.next;
	}
	
	/**
	 * O(m + n) where n > = m;
	 * @param m
	 * @return
	 */
	public E findMthToLast(int m) {

		Node<E> mth = head;

		//Advance mth to the mth position
		for (int i = 0; i < m; i++) {

			if (mth.next == null) {
				return null;
			} else {

				mth = mth.next;
			}
		}
		
		//Assign current pointer to mth
		Node<E> curr = mth;
		//move back mth to head.
		mth = head.next;

		while (curr.next != null) {
			curr = curr.next;
			mth = mth.next;
		}

		return mth.val;

	}

	public boolean isEmpty() {

		return (size == 0);
	}

	/**
	 * Return the size of the list.
	 * 
	 * @return
	 */
	public int size() {

		return size;
	}

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		list.insert(25);
		list.insert(26);
		list.insert(27);
		list.insert(28);
		list.insert(29);
		list.insert(30);
		list.list();
		System.out.println("Deleting 27 in the middle :");
		list.remove(27);
		list.list();

	}

}
