package com.pratik.datastructures.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Quicksort implementation with Hoare Partition.
 * @author pratikm
 *
 */
public class Quicksort {
	
	public static <T extends Comparable<T>> void sort(T[] a) {

		if (a.length <= 1) {
			return;
		}
		
		//Randomize/shuffle the array, so that the worst case (already sorted) is not hit.
		Collections.shuffle(Arrays.asList(a));

		sort(a, 0, a.length - 1);
	}
	
	private static <T extends Comparable<T>> void sort(T[] a, int start, int end) {

		if ((end - start) <= 0) {
			return;
		}

		int pIndex = hoare_partition(a, start, end);
		sort(a, start, pIndex - 1);
		sort(a, pIndex + 1, end);

	}
	
	/**
	 * Hoare's partition.
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	private static <T extends Comparable<T>> int hoare_partition(T[] a, int start, int end) {

		int left = start + 1;
		int right = end;
		T pivot = a[start];

		while (true) {
			
			while (left <= right) {
				if (a[left].compareTo(pivot) < 0) {
					left++;
				} else {
					break;
				}
			}

			while (right > left) {
				if (a[right].compareTo(pivot) < 0) {
					break;
				} else {
					right--;
				}
			}

			if (left >= right) {
				break;
			}

			// swap left and right items
			T temp = a[left];
			a[left] = a[right];
			a[right] = temp;
			// advance each one step
			left++;
			right--;
		}

		// swap pivot with left-1 position
        a[start] = a[left-1];
        a[left-1] = pivot;
        // return the split point
         
        return left-1;

	}	
	
	
	public static void main(String[] args) {
		
		String[] arr = {"Pratik","Mohit","Joel","Parul","Ravneet","Chuyi","Sung","Ashkon"};
		System.out.println("Before:"+Arrays.toString(arr));
		sort(arr);
		System.out.println("After:"+Arrays.toString(arr));
		
		Integer[] arr2 = {23,4,-3,5,66,43,37,19,10};
		System.out.println("Before:"+Arrays.toString(arr2));
		sort(arr2);
		System.out.println("After:"+Arrays.toString(arr2));

	}

}
