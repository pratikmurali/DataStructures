package com.pratik.datastructures.trees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.pratik.datastructures.trees.BinaryTree.TreeNode;


public class BinaryTree<E extends Comparable<? super E>> {

	public static class TreeNode<E> {

		E key;
		TreeNode<E> left;
		TreeNode<E> right;


		TreeNode(E key) {
			this.key = key;
			left = right = null;
		}

	}
	
	private String NULL = "NULL";
	private String splitter = ",";

	public TreeNode<E> root;

	/**
	 * Inorder Traversal Left -> Root -> Right
	 * 
	 * @param node
	 */
	public void inorder(TreeNode<E> root) {

		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.println(root.key);
		inorder(root.right);

	}

	/**
	 * Postorder Traversal Left -> Right -> Root
	 * 
	 * @param node
	 */
	public void postorder(TreeNode<E> root) {

		if (root == null) {
			return;
		}

		postorder(root.left);
		postorder(root.right);
		System.out.println(root.key);
	}

	/**
	 * Preorder Traversal Root-> Left-> Right
	 * 
	 * @param node
	 */
	public void preorder(TreeNode<E> root) {

		if (root == null) {
			return;
		}

		System.out.println(root.key);
		preorder(root.left);
		preorder(root.right);

	}
	
	/**
	 * Level order uses a plain ol' BFS
	 * @param root
	 */
	public void levelOrder(TreeNode<E> root) {
		
		Queue<TreeNode<E>> q = new LinkedList<>();
		
		if(root == null) {
			return;
		}
		
		q.add(root);
		
		//Plain Vanilla Breadth First Search
		while(!q.isEmpty()) {
			
			TreeNode<E> current = q.poll();
			
			if(current.left != null) {
				q.add(current.left);
			}
			
			if(current.right != null) {
				q.add(current.right);
			}
			
			System.out.print(" "+current.key);
			
		}
		
	}
	
	/**
	 * Use a deque to print a tree in spiral order.
	 * Tushar Roy's solution :
	 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversalInSpiralOrder.java
	 * @param root
	 */
	public void spiralOrder(TreeNode<E> root) {

		Deque<TreeNode<E>> dq = new LinkedList<>();

		dq.offerFirst(root);
		boolean flip = true;
		int count = 1;
		while (!dq.isEmpty()) {

			int currentCount = 0;

			while (count > 0) {

				if (flip) {
					root = dq.pollFirst();
					System.out.println(" " + root.key);

					if (root.left != null) {
						dq.offerLast(root.left);
						currentCount++;
					}

					if (root.right != null) {
						dq.offerLast(root.right);
						currentCount++;
					}

				} else {

					root = dq.pollLast();
					System.out.println(" " + root.key);

					if (root.right != null) {
						dq.offerFirst(root.right);
						currentCount++;
					}

					if (root.left != null) {
						dq.offerFirst(root.left);
						currentCount++;
					}

				}

				count--;
			}
			
			flip = !flip;
			count = currentCount;

		}

	}
	
	/**
	 * Find the inorder successor of a tree node.
	 * @param root
	 * @param current
	 * @return
	 */
	public TreeNode<E> getNextNode(TreeNode<E> current) {

		if (current == null) {
			return null;
		}

		TreeNode<E> succ = null;

		// case 1: Node has a right substree, find left most node in right
		// subtree
		if (current.right != null) {
			succ = getLeftMostNode(current.right);
		} else { // case 2: No right child.

			// Walk down from the root. (No Parent Pointer)
			TreeNode<E> tempRoot = root;
			while (tempRoot != null) {
				if (current.key.compareTo(tempRoot.key) < 0) {
					// walk down left subtree
					succ = tempRoot;
					tempRoot = tempRoot.left;
				} else if (current.key.compareTo(tempRoot.key) > 0) {
					tempRoot = tempRoot.right;
				}
			}

		}

		return succ;
	}
	
	/**
	 * Helper method to walk the left children of the right subtree.
	 * @param node
	 * @return
	 */
	private TreeNode<E> getLeftMostNode(TreeNode<E> node) {

		if (node == null) {
			return null;
		}

		
		while (node.left != null) {
			node = node.left;
		}

		return node;

	}
	
	
	static boolean found = false;
	static boolean done = false;
	public static void findInorderSucc(TreeNode root, TreeNode n) {

		if (root == null || done) {
			return;
		}

		findInorderSucc(root.left, n);

		if (found) {
			System.out.print("Inorder successor = " + root.key);
			found = false;
			done = true;
			return;
		} else if (root.key == n.key) {
			found = true;
		}

		findInorderSucc(root.right, n);

	}
	
	/**
	 * Find the Least common ancestor of two nodes in a Binary Tree
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public TreeNode<E> lowestCommonAncestor(TreeNode<E> root, TreeNode<E> n1, TreeNode<E> n2) {

		// Base case for going off a leaf or could be an invalid case.
		if (root == null) {
			return null;
		}

		// Return the match.
		if (root == n1 || root == n2) {
			return root;
		}

		// Recurse through the left subtree
		TreeNode<E> left = lowestCommonAncestor(root.left, n1, n2);
		// Recurse through the right subtree
		TreeNode<E> right = lowestCommonAncestor(root.right, n1, n2);

		// 1. Fell off the tree with no match to n1 or n2.
		if (left == null && right == null)
			return null;

		// 2. Match found in both subtrees
		if (left != null && right != null)
			return root;

		// 3. Match found in Left or Right subtree.
		return (left != null) ? left : right;
	}
	
	/**
	 * Min Max method to check if binary tree is a BST
	 * Warning: Will only work for Integer BSTs
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean isBST(TreeNode<Integer> root, Integer min, Integer max) {
		
		if(root == null) {
			return true;
		}
		
		if((root.key.compareTo(min) < 0) || (root.key.compareTo(max) > 0)) {
			return false;
		}
		
		return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
		
	}
	
	/**
	 * Gets the max height of the binary tree.
	 * @param root
	 * @return
	 */
	public int getHeight(TreeNode<E> root) {

		if (root == null) {
			return 0;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		return Math.max(leftHeight, rightHeight) + 1;

	}
	
	/**
	 * Get the minimum height using BFS
	 * @param root
	 * @return
	 */
	public int getMinHeight(TreeNode<E> root) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode<E>> q = new LinkedList<>();
		q.add(root);

		TreeNode<E> rightmost = root;
		int depth = 1;

		while (!q.isEmpty()) {

			TreeNode<E> node = q.poll();

			if (node.left == null && node.right == null)
				break;

			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);

			// If the node is the rightmost in that level
			// update depth.
			if (node == rightmost) {
				depth++;
				rightmost = (node.right != null) ? node.right : node.left;
			}
		}

		return depth;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public int getSize(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftSize = getSize(root.left);
		int rightSize = getSize(root.right);

		return leftSize + rightSize + 1;

	}
	
	/**
	 * Serialize a Binary Tree
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode<E> root) {

		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		
		return sb.toString();
	}
	
	private void buildString(TreeNode<E> root, StringBuilder sb) {

		if (root == null) {
			sb.append(NULL).append(splitter);
		} else {
            //Build a tree in pre-order.
			sb.append(String.valueOf(root.key)).append(splitter);
			buildString(root.left, sb);
			buildString(root.right, sb);
		}

	}
	
	/**
	 * Deserialize a binary tree
	 * @param root
	 * @return
	 */
	public TreeNode deserialize(String data) {

		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(splitter)));

		return buildTree(nodes);

	}
	
	private TreeNode<Integer> buildTree(Deque<String> nodes) {

		String val = nodes.remove();

		if (val.equals(NULL)) {
			return null;
		} else {

			TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}

	}
	
	/**
	 * Check if root to leaf sum exists.
	 * Warning only for Integer Trees.
	 * @param root
	 * @return
	 */
	public boolean rootToLeafSum(TreeNode<Integer> root, int sum, List<Integer> result) {

		if (root == null) {
			return false;
		}

		// Check if sum exists at leaf node
		if (root.left == null && root.right == null) {

			if (root.key == sum) {
				result.add(root.key);
				return true;
			} else {
				return false;
			}
		}

		if (rootToLeafSum(root.left, sum - root.key, result)) {
			result.add(root.key);
			return true;
		}

		if (rootToLeafSum(root.right, sum - root.key, result)) {
			result.add(root.key);
			return true;
		}

		return false;
	}
	
	public static Pair<Integer,Integer> diameterAndHeight(TreeNode root) {
		
		if(root == null) {
			return new Pair(0,0);
		}
		
		Pair<Integer,Integer> lo = diameterAndHeight(root.left);
		Pair<Integer,Integer> ro = diameterAndHeight(root.right);
		
		int height = 1 + Math.max(lo.getK(), ro.getK());
		
		int option1 = lo.k + ro.k;
		int option2 = lo.v;
		int option3 = ro.v;
		
		int diameter =  Math.max(option1, Math.max(option2, option3));
		
		return new Pair(height,diameter);
		
	}
	
	
	/**
	 * Reconstruct a tree
	 * @param inorder
	 * @param preorder
	 * @return
	 */
	public static TreeNode<Integer> reconstruct(int[] inorder, int[] preorder) {

		return reconstruct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private static TreeNode<Integer> reconstruct(int[] preorder, int prestart, int preend, int[] inorder, int instart,
			int inend) {

		if (prestart == preend || instart == inend) {
			return null;
		}

		int rootValue = preorder[prestart];
		TreeNode<Integer> root = new TreeNode(rootValue);

		int k = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}

		if (k == -1)
			throw new IllegalArgumentException(" Given Inorder and Preorder don't match");

		root.left = reconstruct(preorder, prestart + 1, prestart + (k - instart), inorder, instart, k - 1);
		root.right = reconstruct(preorder, prestart + (k - instart) + 1, preend, inorder, k + 1, inend);

		return root;

	}
	
	/**
	 * Create an Integer Binary Tree
	 */
	private static BinaryTree<Integer> createIntegerBinaryTree() {
		BinaryTree<Integer> intTree = new BinaryTree<>();
		intTree.root = new TreeNode<>(1);
		intTree.root.left = new TreeNode<>(2);
		intTree.root.right = new TreeNode<>(3);
		intTree.root.left.left = new TreeNode<Integer>(4);
		intTree.root.left.right = new TreeNode<Integer>(5);
		intTree.root.right.left = new TreeNode<Integer>(6);
		intTree.root.right.right = new TreeNode<Integer>(7);
		intTree.root.left.left.left = new TreeNode<Integer>(8);
		intTree.root.left.left.right = new TreeNode<Integer>(9);
		intTree.root.right.left.left = new TreeNode<Integer>(10);
		return intTree;
	}
	
	private static BinaryTree<Integer> createExoticBinaryTreeToFindDiameter() {
		BinaryTree<Integer> intTree = new BinaryTree<>();
		intTree.root = new TreeNode<>(5);
		intTree.root.left = new TreeNode<>(3);
		intTree.root.left.left = new TreeNode<>(2);
		intTree.root.right = new TreeNode(4);
		intTree.root.right.left = new TreeNode(3);
		intTree.root.right.left.left = new TreeNode(4);
		intTree.root.right.left.left.right = new TreeNode(6);
		intTree.root.right.right = new TreeNode(8);
		intTree.root.right.right.left = new TreeNode(7);
		intTree.root.right.right.right = new TreeNode(9);
		intTree.root.right.right.right.left = new TreeNode(10);

		return intTree;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = createIntegerBinaryTree();
		//tree.levelOrder(tree.root);	
		tree.inorder(tree.root);
		System.out.println("\n");
		//tree.preorder(tree.root);
		//BinaryTree<Integer> tree1 = createIntegerBinaryTree();
		//System.out.println(tree.serialize(tree1.root));
		
		BinaryTree<Integer> tree2 = createIntegerBinaryTree();
		System.out.println("Find inorder successor for "+tree2.root.left.left.key);
		findInorderSucc(tree2.root, tree2.root.left.left.right);
		
		
		///BinaryTree<Integer> exoticTree = createExoticBinaryTreeToFindDiameter();
		///tree.levelOrder(exoticTree.root);
		///System.out.println();
		//System.out.println("Diameter of the tree = "+diameterAndHeight(exoticTree.root).getV());
		
		
		

	}

	

}

