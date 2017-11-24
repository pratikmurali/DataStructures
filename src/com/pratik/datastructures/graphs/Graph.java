package com.pratik.datastructures.graphs;

import java.util.List;

public abstract class Graph {

	private int numVertices;
	private int numEdges;

	public Graph() {

		numVertices = 0;
		numEdges = 0;
	}

	public int getNumVertices() {

		return numVertices;
	}

	public int getNumEdges() {

		return numEdges;
	}

	public void addVertex() {

		implementAddVertex();
		numVertices++;

	}
	
	public void addEdge(int v, int w) {

		implementAddEdge(v,w);
		numEdges++;

	}


	public abstract void implementAddVertex();
	
	public abstract void implementAddEdge(int v, int w);

	public abstract List<Integer> getNeighbors(int v);

}
