package com.puneet.chugh;
import java.util.*;
public class Graph{

	private List<Integer>[] adjList;
	
	public Graph(int size){
		adjList = (LinkedList<Integer>[])new LinkedList[size];
	}
	
	public List<Integer>[] getGraph(){
		return adjList;
	}
	
	public void addEdge(int start, int end){
		List<Integer> neighborList = adjList[start];
		if(neighborList == null){
			neighborList = new LinkedList();
		}
		neighborList.add(end);
		adjList[start] = neighborList;
	}

	
}
