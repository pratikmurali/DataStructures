package com.pratik.datastructures.arrays;

public class TrappingRainwater {
	
	/**
	Solution2: imagine there is always 2 bar that holds the water in middle; or imagine: we only have one side of the wall (right wall in this case),
	and we are adding a hard-paper on leftside of the water, thus we can calculate the volumn of water in middle.
	Idea is: two artificial wall has to both > water in middle, then will have water in middle.
	Also, another idea of shifting highest wall: the highest wall from left and highest wall from right will hold a triangle shape of water in between,
	when calculating the water in middle index by index, we can simulate the two walls in by comparing max.
	Note: the true volumn for each index calculated should respect the min of the 2 highest walls.
	Note2: leftSideHighWall always store the heigest wall on left side of current index.
	*/
	    public int trap(int[] heights) {
	        if (heights == null || heights.length == 0) {
	            return 0;
	        }   
	        int[] leftSideHighWall = new int[heights.length + 1];
	        leftSideHighWall[0] = 0;
	        for (int i = 0; i < heights.length; i++) {
	            leftSideHighWall[i + 1] = Math.max(leftSideHighWall[i], heights[i]);
	        }
	        int rightSideHighWall = 0;
	        int sum = 0;
	        for (int i = heights.length - 1; i >= 0; i--) {
	            int minOfTwoWalls = Math.min(leftSideHighWall[i], rightSideHighWall);
	            sum += minOfTwoWalls > heights[i] ? minOfTwoWalls - heights[i] : 0;
	            rightSideHighWall = Math.max(heights[i], rightSideHighWall);
	        }
	        return sum;
	    }
	    
	    public static void main(String[] args) {
	    	
	    }

}
