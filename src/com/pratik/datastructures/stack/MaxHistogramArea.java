package com.pratik.datastructures.stack;

/**
 * This one is a hard problem, 
 * Problem statement:Find the largest rectangular area possible in a
 * given histogram where the largest rectangle can be made of a number of
 * contiguous bars. For simplicity, assume that all bars have same width and the
 * width is 1 unit. Input is given as an array. O(n) solution.
 */
public class MaxHistogramArea {

	public static int maxArea(int[] hist) {

		int top = 0;
		int area = 0;
		int max_area = 0;
		Stack<Integer> stack = new Stack<>();
		int n = hist.length;
		int i = 0;

		while (i < n) {

			// stack is empty or current bar (hist[i]) is > top of stack
			if (stack.isEmpty() || hist[stack.peek()] < hist[i]) {
				stack.push(i);
				i++;
			} else { // stack is not empty and current bar is hist[i] < than top of stack

				top = stack.peek();
				stack.pop();
				// very important formula.
				area = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

				if (area > max_area) {
					max_area = area;
				}

			}
		}

		// If the stack is not empty pop all elements and calculate max area.
		while (!stack.isEmpty()) {
			top = stack.peek();
			stack.pop();

			// very important formula.
			area = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

			if (area > max_area) {
				max_area = area;
			}
		}

		return max_area;
	}

	public static void main(String[] args) {

		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Max Rectangular Area =" + maxArea(hist));

	}

}
