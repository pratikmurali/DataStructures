package com.pratik.datastructures.recursion;

/**
 * Another classic recursion problem
 * 1. Only one disk can be moved at a time
 * 2. A disk can be moved only if it's the upper most disk on the stack
 * 3. No disk may be placed on top of a smaller disk.
 * The programs just prints the moves.
 */
public class TowersOfHanoi {
	
	/**
	 * 
	 * @param n = number of disks.
	 * @param from: Source 
	 * @param to: Destination
	 * @param spare: Intermediary 
	 * 
	 */
	public static void towerOfHanoi(int n, char from, char to, char spare) {

		if (n == 1) {
			System.out.println("Move disk: 1 from: " + from + " to: " + to);
			return;
		}

		towerOfHanoi(n - 1, from, spare, to);
		System.out.println("Move disk: "+ n + " from: " + from + " to: " + to);
		towerOfHanoi(n-1,spare,to,from);

	}

	public static void main(String[] args) {
		
		towerOfHanoi(4,'A','B','C');

	}

}
