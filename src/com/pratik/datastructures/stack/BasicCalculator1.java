package com.pratik.datastructures.stack;

/**
 * Application of Stack to implement a basic  calculator 
 * to calculate expressions like
 * "1 + 1"
 * "(1 + (2+3) - (4+5+6) -7)"
 * @author pratikm
 *
 */
public class BasicCalculator1 {

	public static int calculate(String s) {

		Stack<Integer> stack = new Stack<>();
		int result = 0;
		int sign = 1;
		int num = 0;

		//Stack used to save signs.
		stack.push(sign);

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (Character.isDigit(c)) {

				num = 10 * num + s.charAt(i) - '0';

			} else if (c == '+' || c == '-') {

				result += sign * num;
				sign = stack.peek() * (c == '+' ? 1 : -1);
				num = 0;

			} else if (c == '(') {

				stack.push(sign);

			} else if (c == ')') {

				stack.pop();

			} else {
				continue;
			}

		}

		result += sign * num;

		return result;
	}

	public static void main(String[] args) {

		String expr1 = "1 + 1 + (3 - 7)";
		System.out.println(calculate(expr1));

	}

}
