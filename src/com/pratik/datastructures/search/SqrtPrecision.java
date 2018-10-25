package com.pratik.datastructures.search;
/**
 * Basically this requires a computation of 
 * the integral part and a fractional part.
 * All using binary search.
 * @author pratikm
 *
 */
public class SqrtPrecision {
	
	public static float sqrt(int x, int precision) {

		int ans = 0;
		
		int low = 0;
		int high = x >> 1;

		//Calculate the integral part using Binary Search
		while (low <= high) {

			int mid = (low + high) >> 1;
		
			if (mid < x / mid) {
				// go right
				low = mid + 1;
				ans = mid;

			} else if (mid > x/mid) {
				// go left
				high = mid - 1;

			} else
				ans = mid;
		}
		
		//Calculate the fractional part
		
		float increment = 0.1f;
		float res = (float)ans;
		
		for (int i = 1; i <= precision; i++) {
			
			while ((res * res) < x) {
				
				System.out.println("ans = " + res + " x = " + x);
				res = res +  increment;
			}

			res = res - increment;
			increment /= 10.0f;
			System.out.println("increment ="+increment);
		}

		return res;
	}

	public static void main(String[] args) {
		
		//Calculate sqrt of 72 to three decimal places.
		System.out.println(sqrt(72,3));

	}

}
