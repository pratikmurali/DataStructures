package com.pratik.datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Uses an Array of Linked Lists to create an adjacency list representation 
 * of a graph.
 * @author pratikm
 *
 */

public class AlternateGraph {
	
	public static class Graph {
		
		//Array of Linked Lists
		private LinkedList<Integer> adjlist[]; 
		private int V;
		private int[] edgeTo;
		
		//Initialize the Adjacency List graph
		public Graph(int v) {
			this.V = v;
			//Initialize the Array
			adjlist = new LinkedList[v];
			edgeTo = new int[v];
			for(int i = 0; i < V; i++) {
				adjlist[i] = new LinkedList<>();
			}
		}
		
		/**
		 * 
		 * @param v1
		 * @param v2
		 */
		public void addEdge(int v1, int v2) {
			
			adjlist[v1].add(v2);
		}
		
		/**
		 * Get Neighbors for a Vertex.
		 */
		public List<Integer> getNeighbors(int v) {
			
			return adjlist[v];
		}
		
		/**
		 * Depth First Search
		 */
		public void dfs() {
			
			boolean[] visited = new boolean[V];
			
			for(int i = 0; i < V; i++) {
				if(!visited[i]) {
					dfsUtil(i,visited);
				}
			}
		}
		
		public void dfsUtil(int i, boolean[] visited) {

			visited[i] = true;
			System.out.println(i);

			for (int neighbor : getNeighbors(i)) {

				if (!visited[neighbor]) {
					edgeTo[neighbor] = i;
					dfsUtil(neighbor, visited);
				}
			}

		}
		
		public void getPath() {
			
			for(int i = 0; i < edgeTo.length; i++) {
				if(edgeTo[i] != 0) {
					System.out.println(i+" -- "+edgeTo[i]);
				}
			}
			
		}
			
		
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.dfs();
		g.getPath();

	}

}
