package com.pratik.datastructures.unionfind;

/**
 * From Sedgewick lectures.
 * Eager access takes quadratic time.
 * @author pratikm
 *
 */
public class QuickFind {

	private int[] id;

	/**
	 * Constructor
	 * 
	 * @param n
	 */
	public QuickFind(int n) {

		id = new int[n];

		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}

	}

	/**
	 * Quick Find
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	/**
	 * Union (Takes quadratic time)
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		
		int pid = id[p];
		int qid = id[q];
		
		//Go through the whole array and set the 
		//id of the first argument equal to the id
		//of the second argument. 
		for(int i = 0; i < id.length; i++) {
			
			if(id[i] == pid) {
				id[i] = qid;
			}
		}

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
