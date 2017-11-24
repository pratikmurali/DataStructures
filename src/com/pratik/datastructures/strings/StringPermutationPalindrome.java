package com.pratik.datastructures.strings;

import com.pratik.datastructures.util.CharacterUtil;

public class StringPermutationPalindrome {

	public static boolean checkPermutationOfPalindrome(String str) {

		int bitvector = createBitVectorForString(str);
		boolean check = checkIfExactlyOneBitSet(bitvector);

		return (bitvector == 0) || check;

	}

	/**
	 * O(n) scan for the string.
	 * 
	 * @param str
	 * @return
	 */
	public static int createBitVectorForString(String str) {

		int bitvector = 0;

		for (int i = 0; i < str.length(); i++) {
			
			if(Character.isWhitespace(str.charAt(i))) {
				continue;
			}

			int number = CharacterUtil.getAsciiIntegerValue(str.charAt(i));
            
			//create a bit mask by left shifting 1
			int mask = 1 << number;

			// If bit is not set, then set it
			if ((bitvector & mask) == 0) {
				bitvector |= mask;
			} else { // if its set then clear it.
				bitvector &= ~mask;
			}
		}

		return bitvector;
	}

	/**
	 * ((bitvector & (bitvector - 1)) == 0) is a bit-twiddling trick.
	 * If you subtract 1 from a number then 'AND'it to the original number
	 * and you get 0, it can only happen if there was just 1 bit set.
	 * @param bitvector
	 * @return
	 */
	public static boolean checkIfExactlyOneBitSet(int bitvector) {

		return ((bitvector & (bitvector - 1)) == 0);
	}

	public static void main(String[] args) {
		
		String s1 = "tact coa";
		System.out.println("Is tact coa permutaion of a palindrome ? "+checkPermutationOfPalindrome(s1));
	}

}
