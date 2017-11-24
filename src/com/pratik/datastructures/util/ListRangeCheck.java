package com.pratik.datastructures.util;

import java.util.ArrayList;
import java.util.List;

public class ListRangeCheck {

	public static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode(int node_value) {
			val = node_value;
			next = null;
		}
	};

	public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val) {
		if (head == null) {
			head = new LinkedListNode(val);
			tail = head;
		} else {
			tail.next = new LinkedListNode(val);
			tail = tail.next;
		}
		return tail;
	}

	public static int findMiddleNode(LinkedListNode pList) {

		if (pList == null) {
			return 0;
		} else {

			LinkedListNode curr = pList;
			List<Integer> list = new ArrayList<>();

			while (curr != null) {
				list.add(curr.val);
				curr = curr.next;
			}

			return (list.size() % 2 == 1) ? list.get(list.size() / 2) : list.get(list.size() / 2 + 1);
		}

	}

	public static void main(String[] args) {

		int res;
		int pList_size = 0;

		LinkedListNode pList = null;
		LinkedListNode pList_tail = null;

		pList_size = 7;
		int[] a = {6,1,11,45,12,67,89};

		for (int i = 0; i < pList_size; i++) {
			int pList_item;
			pList_item = a[i];
			pList_tail = _insert_node_into_singlylinkedlist(pList, pList_tail, pList_item);

			if (i == 0) {
				pList = pList_tail;
			}
		}

		res = findMiddleNode(pList);
		System.out.println(res);
		
	}

}
