package com.pratik.datastructures.lists;

public class DoublyLinkedList<E> {

	static class DllNode<E> {

		E val;
		DllNode<E> prev;
		DllNode<E> next;

		public DllNode(E val) {
			super();
			this.val = val;
			prev = next = null;

		}

		@Override
		public String toString() {
			return "DllNode [val=" + val + "]";
		}

	}

	// sentinel node for head
	private DllNode<E> head = null;
	// sentinel node for tail
	private DllNode<E> tail = null;
	private int size = 0;

	/**
	 * Constructor
	 */
	public DoublyLinkedList() {
		super();
		head = new DllNode<E>(null);
		tail = new DllNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Insert in the front of the list.
	 * 
	 * @param val
	 */
	public void insert(E val) {

		DllNode<E> n = new DllNode<>(val);

		n.next = head.next;
		n.prev = n.next.prev;
		head.next.prev = n;
		head.next = n;

		size++;

	}

	/**
	 * Iterate through the list.
	 */
	public void list() {

		DllNode<E> curr = head.next;
		while (curr.next != null) {
			System.out.println(curr);
			curr = curr.next;
		}

	}

	/**
	 * 
	 * @param toDelete
	 */
	public void remove(E toDelete) {

		DllNode<E> curr = head;

		if (head.next == tail) {
			return;
		}

		while (curr.next != null) {
			if (curr.next.val == toDelete) {
				curr.next.next.prev = curr;
				curr.next = curr.next.next;
				size --;
				return;
			}

			curr = curr.next;
		}

	}
	
	/**
	 * Remove the least recently used item
	 * @param toDelete
	 */
	public void removeFromTail(E toDelete) {
		
		if(head.next == tail) {
			return;
		}
		
		tail.prev.prev.next = tail;
		tail.prev = tail.prev.prev;
		
	}

	/**
	 * Check if List is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {

		return (size == 0);
	}

	/**
	 * Return size
	 * 
	 * @return
	 */
	public int size() {

		return size;
	}

	public static void main(String[] args) {

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.insert(5);
		dll.insert(4);
		dll.insert(3);
		dll.insert(2);
		dll.insert(1);
		dll.list();
		System.out.println("Removing 5 from the end");
		dll.removeFromTail(5                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      );
		dll.list();
		System.out.println("Removing 3 from the middle");
		dll.remove(3);
		dll.list();
		System.out.println("Removing 1 from the begining");
		dll.remove(1);
		dll.list();
		//System.out.println("Removing 5 from the end");
		//dll.remove(5);
		//dll.list();

	}

}
