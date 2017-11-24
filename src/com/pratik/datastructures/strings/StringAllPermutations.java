package com.pratik.datastructures.strings;

import java.util.Map;
import java.util.TreeMap;

public class StringAllPermutations {
	
	public void permute(char[] arr) {

		//First build a count map.
		Map<Character, Integer> countMap = new TreeMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (!countMap.containsKey(arr[i])) {
				countMap.put(arr[i], 1);
			} else {
				countMap.put(arr[i], countMap.get(arr[i]) + 1);
			}
		}
		
		//Initialize a char array [a,b,c]
		char[] str = new char[countMap.size()];
		//initialize a count array [2,1,1]
		int[] count = new int[countMap.size()];
		int index = 0;
		
		// Read the key and values in the count map into the str and 
		// count arrays respectively.
		for(Map.Entry<Character, Integer> entry: countMap.entrySet()) {		
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		
		//This will store the output
		char[] result = new char[arr.length];
		
		permuteUtil(str,count,result,0);
		
	}
	
	/**
	 * 
	 * @param str : char array of the distinct characters
	 * @param count: count of each of the distinct characters.
	 * @param result: stores the result at each level
	 * @param level: Recursion depth.
	 */
	public void permuteUtil(char[] str, int[] count, char[]result, int level) {
		
		if(result.length == level) {
			//printArray(result);
			return;
		}
		
		for(int i = 0; i < str.length; i++) {
			
			if(count[i] == 0) {
				return;
			}
			
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level + 1);
			count[i]++;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
