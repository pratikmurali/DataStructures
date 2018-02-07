package com.pratik.datastructures.heap;

import java.util.Arrays;

public class MinHeap {

	private int CAPACITY = 10;
	private int[] items;
	int size = 0;

	public MinHeap() {

		items = new int[CAPACITY];
	}

	public int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	public int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	public int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	public boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}

	public boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}

	public boolean hasParent(int childIndex) {

		return getParentIndex(childIndex) > 0;

	}

	public int getLeftChild(int parentIndex) {

		return items[getLeftChildIndex(parentIndex)];
	}

	public int getRightChild(int parentIndex) {

		return items[getRightChildIndex(parentIndex)];
	}

	public int getParent(int childIndex) {

		return items[getParentIndex(childIndex)];
	}

	public void ensureCapacity() {

		if (size == CAPACITY) {
			items = Arrays.copyOf(items, CAPACITY * 2);
		}
		CAPACITY *= 2;
	}

	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index1] = temp;
	}

	public void add(int val) {

		ensureCapacity();
		items[size] = val;
		size++;
		heapifyUp();
	}

	public int poll() {

		if (size == 0) {
			throw new IllegalStateException("Heap is Empty");
		}

		int ret = items[0];
		swap(0, size - 1);
		size--;
		heapifyDown();
		return ret;

	}

	private void heapifyUp() {

		int index = size - 1;
		while (hasParent(index) && getParent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}

	}

	private void heapifyDown() {

		int index = 0;
		while (hasLeftChild(index)) {

			int minChildIndex = getLeftChildIndex(index);

			if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
				minChildIndex = getRightChild(index);
			}

			if (items[index] > items[minChildIndex]) {
				swap(index, minChildIndex);
			} else {
				break;
			}

			index = minChildIndex;

		}

	}

	public int peek() {
		return items[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
