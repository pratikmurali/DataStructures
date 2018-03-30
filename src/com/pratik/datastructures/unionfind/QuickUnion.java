package com.pratik.datastructures.unionfind;

import java.util.Arrays;

/**
 * Quick Union with Weight Union and Path Compression.
 * From Sedgewick's lectures.
 * Any M union-find ops on N array elements makes c(N+Mlg*N) array accesses
 * lg*N is an iteraritive log function.
 * @author pratikm
 *
 */
public class QuickUnion {

	private int[] id;//stores the parents
	private int[] sz;//stores the sizes of each component.

	/**
	 * Constructor.
	 * Initialization takes linear time.
	 * @param N
	 */
	public QuickUnion(int N) {

		id = new int[N];
		sz = new int[N];

		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}

	}

	/**
	 * Chase the root
	 * Path compression
	 * @param i
	 * @return
	 */
	private int root(int i) {

		while (id[i] != i) {
			//get the grandparent.
			id[i] = id[id[i]];
			i = id[i];
		}

		return i;
	}

	/**
	 * Query connectivity
	 * Takes time proportional to the depth of p and q which is lg(n)
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}

	/**
	 * Weighted Union Find.
	 * Takes constant time given the roots.
	 * Roots tekes lg(n)
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {

		int i = root(p);
		int j = root(q);

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}

	}
	
	public int[] getUnionArray() {
		return this.id;
	}
	
	public int[] getWeightArray() {
		return this.sz;
	}

	public static void main(String[] args) {
		
		QuickUnion QU = new QuickUnion(10);
		
		//Create Components
		QU.union(4, 3);
		QU.union(3, 8);
		QU.union(6, 5);
		QU.union(9, 4);
		QU.union(2, 1);
		QU.union(5, 0);
		QU.union(7, 2);
		QU.union(6, 1);
		QU.union(7, 3);
		
		Arrays.stream(QU.getUnionArray()).forEach(x->System.out.print(x+" "));
		System.out.println();
		Arrays.stream(QU.getWeightArray()).forEach(y->System.out.print(y+" "));
		

	}

}
