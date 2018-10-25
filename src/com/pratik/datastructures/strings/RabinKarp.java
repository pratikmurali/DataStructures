package com.pratik.datastructures.strings;

public class RabinKarp {
	
	public static boolean isSubstringOf(String T, String S) {

		if (T == null || S == null)
			return false;

		if (T.isEmpty())
			return true;

		if (T.length() > S.length())
			return false;

		int hashT = 0;
		int hashS = 0;
		int prime = 53;

		// calculate the hashcode for the first block of substring length characters.
		for (int i = 0; i < T.length(); i++) {

			hashT = hashT * prime + T.charAt(i);
			hashS = hashS * prime + S.charAt(i);
		}

		if (hashT == hashS && T.equals(S.substring(0, T.length())))
			return true;

		int powerOfPrime = 1;
		for (int i = 0; i < T.length() - 1; i++) {
			powerOfPrime *= prime;
		}

		for (int i = T.length(); i < S.length(); i++) {

			int toRemove = S.charAt(i - T.length());
			hashS = (hashS - toRemove * powerOfPrime) * prime + S.charAt(i);
			if (hashS == hashT && T.equals(S.substring(i - T.length() + 1, i + 1))) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		
		System.out.println(" Is pra a substring of pratik ? "+isSubstringOf("pra","pratik"));
		System.out.println(" Is prat a substring of pratik ? "+isSubstringOf("prat","pratik"));
		System.out.println(" Is Prat a substring of pratik ? "+isSubstringOf("Prat","pratik"));
		System.out.println(" Is tarp a substring of pratik ? "+isSubstringOf("tarp","pratik"));

	}

}
