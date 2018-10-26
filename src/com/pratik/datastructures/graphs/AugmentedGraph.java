package com.pratik.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AugmentedGraph {

	List<Vertex> vertices;

	public static class Vertex {
		int val;
		State state;
		List<Vertex> neighbors;

		public Vertex(int data) {
			this.val = data;
			neighbors = new ArrayList<>();
			state = state.UNVISITED;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public List<Vertex> getNeighbors() {
			return neighbors;
		}
		
		@Override
		public String toString() {
			return "["+this.val+"]";
		}

	}

	public AugmentedGraph(List<Vertex> vertices) {
		this.vertices = vertices;
	}
	
	/**
	 * 
	 * @param v
	 */
	public void dfs(Vertex v) {

		Stack<Vertex> stack = new Stack<>();
		stack.push(v);

		while (!stack.isEmpty()) {

			Vertex curr = stack.pop();
			curr.setState(State.VISITING);
			System.out.println(curr + " ");

			for (Vertex neighbor : curr.getNeighbors()) {
				if (neighbor.getState() == State.UNVISITED) {
					stack.add(neighbor);
				}
			}

			curr.setState(State.VISITED);
		}
	}
	
	/**
	 * 
	 * @param v
	 */
	public void recursiveDfs(Vertex v) {
		
		v.setState(State.VISITING);
		System.out.println(" "+v);
		for(Vertex neighbor:v.neighbors) {
			if(neighbor.state == State.UNVISITED)
				recursiveDfs(neighbor);
		}
		
		v.setState(State.VISITED);
		
	}
	
	public void bfs(Vertex v) {

		Queue<Vertex> q = new LinkedList<>();
		q.offer(v);
		v.setState(State.VISITING);

		while (!q.isEmpty()) {

			Vertex curr = q.poll();
			System.out.println(curr);
			for (Vertex neighbor : curr.getNeighbors()) {
				if (neighbor.getState() == State.UNVISITED)
					q.add(neighbor);
			}

			curr.setState(State.VISITED);
		}

	}
	
	/**
	 * Topological Sort
	 * @param v
	 * @param s
	 */
	public void topsort(Vertex v, Stack<Vertex> s) {

		v.setState(State.VISITING);
		for (Vertex neighbor : v.getNeighbors()) {
			if (neighbor.getState() == State.UNVISITED)
				topsort(neighbor, s);
		}

		v.setState(State.VISITED);
		s.push(v);

	}


	public static void main(String[] args) {

		List<Vertex> vertices = new ArrayList<>();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);

		v1.getNeighbors().add(v2);
		v1.getNeighbors().add(v3);
		v2.getNeighbors().add(v4);
		v4.getNeighbors().add(v6);
		v3.getNeighbors().add(v5);

		AugmentedGraph graph = new AugmentedGraph(vertices);
		
		//graph.dfs(v1);
		//graph.recursiveDfs(v1);
		//graph.bfs(v1);
		
		clearGraph(vertices);
		
		Stack<Vertex> s = new Stack<>();
		graph.topsort(v1, s);
		
		System.out.println("Topological Order");
		while(!s.isEmpty())
			System.out.println(s.pop());

	}

	/**
	 * @param vertices
	 */
	private static void clearGraph(List<Vertex> vertices) {
		for(Vertex v:vertices) {
			v.setState(State.UNVISITED);
		}
	}

}
