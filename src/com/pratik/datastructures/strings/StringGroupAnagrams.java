package com.pratik.datastructures.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

public class StringGroupAnagrams {
	
    /**
     * 
     * @param str
     * @return
     */
	public static List<List<String>> groupAnagrams(String[] str) {
		Map<Integer, List<String>> map = new HashMap<>();
		for (String s : str) {
			int sum = 0;
			for (char ch : s.toCharArray()) {
				sum += ch - 'a';
			}
			if (map.containsKey(sum)) {
				map.get(sum).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(sum, list);
			}
		}

		List<List<String>> result = new ArrayList<>(map.values());
		return result;
	}
	
	
	public static void main(String[] args) {
		
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> result = groupAnagrams(input);
		
		for(List<String> list: result) {
			
			System.out.print(list.stream().collect(Collectors.joining(",")));
			System.out.println();
		}

	}

}
