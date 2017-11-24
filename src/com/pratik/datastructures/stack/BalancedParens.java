package com.pratik.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BalancedParens {
	
	private Map<Character, Character> map = new HashMap<>();
	
	

	public BalancedParens() {
		super();

		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
	}
	
	public boolean match(String parens) {

		Deque<Character> s = new ArrayDeque<>();

		for (char c : parens.toCharArray()) {
			if (map.containsKey(c)) {
				s.push(c);
			} else {
				if (c == map.get(s.peek())) {
					s.pop();
				} else {
					return false;
				}
			}
		}

		return s.isEmpty();

	}

	public static void main(String[] args) {
		
		BalancedParens bp = new BalancedParens();
		String s1 = "{[(){[()]}]}";
		String s2 = "{[(){[()]}]}";
		System.out.println(" Result of checking string "+bp.match(s1));
		System.out.println(" Result of checking string "+bp.match(s2));

	}

}
