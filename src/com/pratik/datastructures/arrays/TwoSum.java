package com.pratik.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    
    private Map<Integer,Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        
        int count = map.containsKey(number)?map.get(number):0;
        map.put(number,count+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            
            int key = entry.getKey();
            int val = value - key;
            if(map.keySet().contains(val)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	
    	    TwoSum ts = new TwoSum();
    	    ts.add(0);
    	    ts.add(0);
    	    System.out.println(ts.find(0));
    	
    	
    }
}