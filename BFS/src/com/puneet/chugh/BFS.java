package com.puneet.chugh;

import java.util.*;

public class BFS{

	private Graph graph;
	
	public BFS(Graph graph){
		this.graph = graph;
	}

	public void traverseBFS(){
		
		boolean[] visited = new boolean[graph.getGraph().length];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		
		while(!queue.isEmpty()){
			
			int visiting = queue.remove();
			visited[visiting] = true;
			System.out.printf("Visiting %d\n", visiting);
			for(int neighbor : graph.getGraph()[visiting]){
				if(visited[neighbor])
					continue;

				visited[neighbor] = true;

				queue.add(neighbor);
			}
		}
		
	}

	public static void main(String[] args){
		
		Graph graph = new Graph(9);
		graph.addEdge(0,2);
		graph.addEdge(2,0);
		graph.addEdge(2,8);
		graph.addEdge(8,2);
		graph.addEdge(2,3);
		graph.addEdge(3,2);
		graph.addEdge(2,5);
		graph.addEdge(5,2);
		graph.addEdge(3,0);
		graph.addEdge(0,3);
		graph.addEdge(1,3);
		graph.addEdge(3,1);
		graph.addEdge(3,7);
		graph.addEdge(7,3);
		graph.addEdge(3,6);
		graph.addEdge(6,3);
		graph.addEdge(8,0);
		graph.addEdge(0,8);
		graph.addEdge(4,0);
		graph.addEdge(0,4);
		
		BFS bfs = new BFS(graph);
		bfs.traverseBFS();
	}

}
