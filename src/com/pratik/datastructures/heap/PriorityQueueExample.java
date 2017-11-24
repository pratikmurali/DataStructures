package com.pratik.datastructures.heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * [12, 35, 37, 45, 56, 94, 51, 94, 80, 76]
    Processing 12
    Processing 35
    Processing 37
    Processing 45
    Processing 51
    Processing 56
    Processing 76
    Processing 80
    Processing 94
    Processing 94
 *
 */
public class PriorityQueueExample {

	public static void main(String[] args) {
		
		Queue<Integer> pq = new PriorityQueue<>(10);
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++) {
			int j = rand.nextInt(100);
			pq.add(j);
		}
		
		System.out.println(pq.toString());
		
		while(!pq.isEmpty()) {
			System.out.println("Processing "+pq.poll());
		}
		

	}

}
