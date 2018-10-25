package com.pratik.datastructures.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class Skyline {
	
	static class BuildingPoint implements Comparable<BuildingPoint> {
	    
	    int x;
	    boolean isStart;
	    int height;
	    
	    @Override
	    public int compareTo(BuildingPoint o) {
	        //sort by the x-values if the x values are not equal.
	        if(this.x != o.x) {
	            return this.x - o.x;
	        } else {
	            //Tie breaker sorts
	            //1. If the starts (x-values) are equal, return sorted by larger height first
	            //2. If the ends (x-values) are equal, return sorted by the smaller height first
	            //3. If the start and end (x-values) are equal, return start followed by end
	            return (this.isStart?-this.height:this.height) - (o.isStart?-o.height:o.height);
	        }
	        
	    }
	  }    
	    
	public List<int[]> getSkyline(int[][] buildings) {

		BuildingPoint[] buildingPoint = new BuildingPoint[buildings.length * 2];
		LinkedList<int[]> result = new LinkedList<>();

		int prevMaxValue = 0;
		int index = 0;

		// TreeMap gives O(Log(n)) performance compared to a PriorityQueue
		//TreeMap stores the height and how many times the height occurs
		TreeMap<Integer, Integer> rbtree = new TreeMap<>();
		// (maxvalue, count of occurences)
		//Initially put height 0 occurs once.
		rbtree.put(0, 1);

		// 1. Build an array of Building Points
		for (int[] building : buildings) {
			// Start Keypoint
			buildingPoint[index] = new BuildingPoint();
			buildingPoint[index].x = building[0];
			buildingPoint[index].isStart = true;
			buildingPoint[index].height = building[2];
			// End Keypoint
			buildingPoint[index + 1] = new BuildingPoint();
			buildingPoint[index + 1].x = building[1];
			buildingPoint[index + 1].isStart = false;
			buildingPoint[index + 1].height = building[2];

			index += 2;
		}

		// 2. Sort the array of Building Points
		Arrays.sort(buildingPoint);

		// 3. Start inserting the Building Points into a Self Balancing BST.
		for (BuildingPoint bp : buildingPoint) {

			if (bp.isStart) {
				rbtree.compute(bp.height, (key, value) -> {
					if (value != null) {
						return value + 1;
					}

					return 1;
				});
			} else {
                //if end point, remove the height or decrement it's count.
				rbtree.compute(bp.height, (key, value) -> {

					if (value == 1) {
						// remove value from map
						return null;
					}

					return value - 1;

				});
			}

			// Last key is the highest (sorted self-balancing BST)
			//peek the current max height for addition/removal of a building
			int currentMaxValue = rbtree.lastKey();

			// If prevMax != currMax, write out result
			if (prevMaxValue != currentMaxValue) {
				result.add(new int[] { bp.x, currentMaxValue });
				prevMaxValue = currentMaxValue;
			}

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
