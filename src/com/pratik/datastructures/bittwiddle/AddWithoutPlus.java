package com.pratik.datastructures.bittwiddle;

/**
 * Trick problem to add two numbers, but calculating their sum and carry
 * separately, then adding them. SUM = a XOR B CARRY = (a AND b) << 1
 * 
 * @author pratikm
 *
 */
public class AddWithoutPlus {

	public static int addWithoutPlus(int a, int b) {
		if (b == 0)
			return a;

		int sum = a ^ b;
		System.out.println("Sum == "+ sum);
		int carry = (a & b) << 1;
		System.out.println("Carry == "+carry);

		return addWithoutPlus(sum, carry);
	}

	public static void main(String[] args) {

		System.out.println("779+854 = " + addWithoutPlus(779, 854));

	}

}
