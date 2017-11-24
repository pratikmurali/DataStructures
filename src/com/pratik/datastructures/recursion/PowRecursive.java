package com.pratik.datastructures.recursion;

public class PowRecursive {
	
	public static int pow(int base, int exp) {

		if (exp == 0) {
			return 1;
		}  else {
			return base * pow(base, exp - 1);
		}
	}

	public static void main(String[] args) {
		
         System.out.println("pow(3,7) = "+pow(3,7));
         System.out.println("pow(2,6) = "+pow(2,6));
         System.out.println("pow(4,4) = "+pow(4,4));
         System.out.println("pow(9,3) = "+pow(9,3));

	}

}
