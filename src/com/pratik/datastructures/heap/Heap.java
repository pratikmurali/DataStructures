package com.pratik.datastructures.heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Binary (Max) Heap class supports the following operations
 * insert (O(log(n))
 * delete (O(log(n))
 * lookup (O(1))
 * @author pratikm
 *
 * @param <T>
 */

public class Heap<T extends Comparable<T>> {

	// Array to store the heap.
	private ArrayList<T> items;

	public Heap() {
		super();
		items = new ArrayList<T>();
	}

	/**
	 * Required for re-balancing a heap.
	 */
	private void siftup() {

		int k = items.size() - 1;

		while (k > 0) {

			int parent = (k - 1) / 2;

			if (items.get(k).compareTo(items.get(parent)) > 0) {

				T item = items.get(parent);
				items.set(parent, items.get(k));
				items.set(k, item);
				// Move index to parent
				k = parent;

			} else {

				break;
			}

		}

	}

	/**
	 * Required for rebalancing a heap.
	 */
	private void siftdown() {

		int k = 0;
		int leftChild = 2 * k + 1;

		while (leftChild < items.size()) {

			int max = leftChild;
			int rightChild = leftChild + 1;

			if (rightChild < items.size()) { // There is a right child.
				if (items.get(rightChild).compareTo(items.get(leftChild)) > 0) {
					max++;

				}
			}

			if (items.get(k).compareTo(items.get(max)) < 0) {

				T temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				k = max;
				leftChild = 2 * k + 1;
			} else {
				break;
			}

		}
	}

	/**
	 * Insert into a max heap.
	 * 
	 * @param item
	 */
	public void insert(T item) {

		items.add(item);
		siftup();
	}

	/**
	 * Return max element at top of the heap and rebalance.
	 * 
	 * @return
	 */
	public T remove() throws NoSuchElementException {

		if (items.isEmpty()) {
			throw new NoSuchElementException();
		}

		if (items.size() == 1) {
			return items.remove(0);
		}

		T item = items.get(0);
		items.set(0, items.get(items.size() - 1));
		siftdown();

		return item;
	}

	/**
	 * Is the heap empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}

	/**
	 * Size of the heap.
	 * 
	 * @return
	 */
	public int size() {
		return items.size();
	}

	@Override
	public String toString() {

		return items.toString();
	}

	public static void main(String[] args) {

		Heap<Integer> hp = new Heap<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter next int, type 'done' to stop");
		String line = sc.nextLine();

		while (!line.equals("done")) {

			hp.insert(Integer.parseInt(line));
			System.out.println(hp);
			System.out.print("Enter next int, type 'done' to stop");
			line = sc.nextLine();

		}

	}

}
