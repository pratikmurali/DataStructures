package com.pratik.datastructures.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Recursive method to print all subsets of a set. Also called a Power Set.
 * A set has 2^n subsets. 
 *
 */
public class SubsetsGeneration {
	
	public static void printAllSubsets(int[] a) {
		Set<Integer> subsetSofar = new HashSet<Integer>();
		printAllSubsetsHelper(a, 0, subsetSofar);

	}
	
	public static void printAllSubsetsHelper(int[] a, int i, Set<Integer> subsetSofar) {

		if (i == a.length) {
			print(subsetSofar);
		} else {
            //Recurse by removing a[i]
			printAllSubsetsHelper(a, i + 1, subsetSofar);
			//Recurse again by adding a[i]
			subsetSofar.add(a[i]);
			printAllSubsetsHelper(a, i + 1, subsetSofar);
			//Backtrack (un-choose)
			subsetSofar.remove(a[i]);

		}

	}
	
	private static void print(Set<Integer> subsetSofar) {

		if (subsetSofar.isEmpty()) {
			System.out.println("{ }");
		} else {

			System.out.print('{');
			for (int i : subsetSofar) {
				System.out.print(i + ",");
			}
			System.out.print('}');
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4};
		printAllSubsets(a);
	}

}
