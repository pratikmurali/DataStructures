package com.pratik.datastructures.strings;

import com.pratik.datastructures.util.CharacterUtil;

public class StringOneEditDistance {

	/**
	 * Check in O(n) time if one edit distance.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isOneEditDistance(String s1, String s2) {

		if (Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}

		if (s1.length() == s2.length()) {

			return isEditReplace(s1, s2);

		} else {

			return isEditInsertOrDelete(s1, s2);
		}

	}

	/**
	 * Check if a char has been replaced
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isEditReplace(String s1, String s2) {

		int replaceCount = 0;

		for (int i = 0; i < s1.length(); i++) {

			if (replaceCount > 1) {
				return false;
			}

			if (s1.charAt(i) != s2.charAt(i)) {
				replaceCount++;
			}

		}

		return (replaceCount != 0);

	}

	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isEditInsertOrDelete(String s1, String s2) {

		String toTest = s1 + s2;
		int bitvector = 0;

		for (int i = 0; i < toTest.length(); i++) {

			int mask = 1 << CharacterUtil.getAsciiIntegerValue(toTest.charAt(i));

			//check if set.
			if ((bitvector & mask) == 0) {

				//set
				bitvector |= mask;

			} else {

				//reset:  (x&(~i<<n))
				bitvector &= ~mask;
			}

		}

		return checkIfExactlyOneBitSet(bitvector);
	}

	/**
	 * ((bitvector & (bitvector - 1)) == 0) is a bit-twiddling trick. If you
	 * subtract 1 from a number then 'AND'it to the original number and you get 0,
	 * it can only happen if there was just 1 bit set.
	 * 
	 * @param bitvector
	 * @return
	 */
	public static boolean checkIfExactlyOneBitSet(int bitvector) {

		return ((bitvector & (bitvector - 1)) == 0);
	}

	public static void main(String[] args) {

		// One edit replace testcase
		String s1 = "geeks";
		String s2 = "peeks";

		// One edit insert testcase
		String s3 = "pratik";
		String s4 = "pratiks";

		// one edit delete testcase
		String s5 = "coder";
		String s6 = "code";

		// Too many edit negative testcase
		String s7 = "amazon";
		String s8 = "airbnb";

		// length different > 1 testcase
		String s9 = "fishing";
		String s10 = "fish";
		
		//Negative testcase exact same strings
		String s11 = "pratik";
		String s12 = "pratik";

		System.out.println("Are geeks and peeks one replace away? " + isOneEditDistance(s1, s2));
		System.out.println("Are pratik and pratiks one insert away? " + isOneEditDistance(s3, s4));
		System.out.println("Are coder and code one delete away? " + isOneEditDistance(s5, s6));
		System.out.println("Are amazon and airbnb one edit away? " + isOneEditDistance(s7, s8));
		System.out.println("Are fishing and fish one edit away? " + isOneEditDistance(s9, s10));
		System.out.println("Are pratik and pratik one edit away? "+isOneEditDistance(s11,s12));

	}

}
