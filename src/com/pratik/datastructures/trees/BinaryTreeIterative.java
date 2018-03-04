package com.pratik.datastructures.trees;

import java.util.Stack;

public class BinaryTreeIterative {
	
	private static class BinaryTreeNode {
		
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}
		
	/**
	 * O(n) time complexity
	 * O(2n) space complexity.
	 * @param root
	 */
	public static void postorderIterative(BinaryTreeNode root) {
		
		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();
		
		s1.push(root);
		
		while(!s1.isEmpty()) {
			
			BinaryTreeNode current = s1.pop();
			
			s2.push(current);
			
			if(current.left != null) {
				s1.push(current.left);
			}
			
			if(current.right != null) {
				s1.push(current.right);
			}
			
		}
		
		while(!s2.isEmpty()) {
		
			 System.out.println(s2.pop().val);
		}
		
	}
	
	/**
	 * O(n) time complexity
	 * O(n) space complexity
	 * @param root
	 */
	public static void preorderIterative(BinaryTreeNode root) {

		// Root->Left->Right

		Stack<BinaryTreeNode> s1 = new Stack<>();
		s1.push(root);

		while (!s1.isEmpty()) {

			BinaryTreeNode current = s1.pop();
			System.out.println(current.val);

			if (current.right != null) {
				s1.push(current.right);
			}

			if (current.left != null) {
				s1.push(current.left);
			}
		}

	}

	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.left.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		root.right.right.right = new BinaryTreeNode(8);
		//L->R->Root
		//4,6,5,2,8,7,3,1
		
		//root->left->right
        //1,2,4,5,6,3,7,8
         
		//postorderIterative(root);
		preorderIterative(root);

	}

}
