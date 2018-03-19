package com.pratik.datastructures.util;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomArray {
	
	public static int[] genRandArray(int size) {

		Random rand = new Random();
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(size + 1);
		}

		return arr;
	}

	public static void main(String[] args) {
		
		int[] arr = genRandArray(25);
		
		System.out.println(Arrays.toString(arr));

	}

}
