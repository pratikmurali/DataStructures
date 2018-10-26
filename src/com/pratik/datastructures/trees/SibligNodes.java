package com.pratik.datastructures.trees;

public class SibligNodes {
	

	 public class TreeLinkNode {
	     int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }
	  
	 /*
	 * You may only use constant extra space.
	 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
	 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every 
	 * parent has two children).
	 */
	
	/**
	1 -> NULL
	   /  \
	  2 -> 3 -> NULL
	 / \  / \
	4->5->6->7 -> NULL
    **/
	
	
	public void connect(TreeLinkNode root) {
		TreeLinkNode level_start = root;
		while (level_start != null) {
			TreeLinkNode cur = level_start;
			while (cur != null) {
				if (cur.left != null)
					cur.left.next = cur.right;
				if (cur.right != null && cur.next != null)
					cur.right.next = cur.next.left;

				cur = cur.next;
			}
			level_start = level_start.left;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
