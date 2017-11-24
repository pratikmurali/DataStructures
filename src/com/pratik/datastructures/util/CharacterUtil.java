package com.pratik.datastructures.util;

public class CharacterUtil {
	
	public static int getAsciiIntegerValue(char c) {

		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');

		int val = Character.getNumericValue(c);

		if (val >= a && val <= z) {

			return val - a;

		} else if (val >= A && val <= Z) {

			return val - 'A';
		}

		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
