package com.puneet.chugh;
import java.util.*;

public class DFS{

	boolean[] visited;
	Stack<Integer> stack;
	Graph graph;
	public DFS(int size){
		graph = new Graph(size);
		visited = new boolean[size];
		stack = new Stack<Integer>();	
	}
	
	class Graph{
		int size;
		LinkedList<Integer> adj[];
		Graph(int size){
			this.size = size;
			adj = new LinkedList[size];
		}
		public void addEdge(int a, int b){

			if(adj[a]==null){
				adj[a] = new LinkedList<>();
			}
			if(adj[b]==null)
				adj[b] = new LinkedList<>();

			LinkedList<Integer> list = adj[a];
			list.add(b);
			list = adj[b];
			list.add(a);
		}

	}

	public void traverseDFS(int v){
		
		if(visited[v])
			return;
		visited[v] = true;
		System.out.println("Visited : "+v);
		if(graph.adj[v]==null)
			return;
		//System.out.println("Adding to stack....");
		for(int ver : graph.adj[v]){
		//	if(!stack.isEmpty()){
				if(!stack.contains(ver) && !visited[ver]){
					//System.out.printf("%d\t",ver);
					stack.push(ver);
				}
		//	}
					
		}
		System.out.println("");	
		if(!stack.isEmpty())
			traverseDFS(stack.pop());

		return;
	}
	
	public static void main(String[] args){
		DFS dfs = new DFS(10);
		dfs.graph.addEdge(0,8);
		dfs.graph.addEdge(1,7);
		dfs.graph.addEdge(2,6);
		dfs.graph.addEdge(3,5);
		dfs.graph.addEdge(4,3);
		dfs.graph.addEdge(5,2);
		dfs.graph.addEdge(6,1);
		dfs.graph.addEdge(7,0);
		dfs.graph.addEdge(8,9);
		dfs.graph.addEdge(9,4);
		dfs.graph.addEdge(5,2);
		dfs.graph.addEdge(6,7);
		dfs.traverseDFS(0);
	
	}
}
