package com.puneet.chugh;
import java.util.*;

public class BellmanFord{


	int[] nodes;
	Set<Edge> edges;
	int nodeCount;
	public BellmanFord(int size){
		nodes = new int[size];
		edges = new HashSet<>();
		nodeCount = size;
	}

	class Edge{
		int endPt1;
		int endPt2;
		int dist;

		public Edge(int A, int B, int dist){
			endPt1 = A;
			endPt2 = B;
			this.dist = dist;
		}
	}

	public void addEdge(int A, int B, int dist){
		edges.add(new Edge(A,B,dist));
	}

	public void bellmanFordAlgo(){

		Map<Integer, Integer> distMap = new HashMap<>();
		Map<Integer, Integer> parentMap = new HashMap<>();

		for(int counter=0; counter<nodeCount; counter++){
			distMap.put(counter, 100);
			parentMap.put(counter, -1);
		}
		distMap.put(0,0);
		parentMap.put(0,0);
		
		boolean negLoopCyc = reduce(distMap, parentMap);
		if(negLoopCyc){
			System.out.println("There's a negative loop cycle");
			return;
		}

		for(Map.Entry<Integer,Integer> entry: parentMap.entrySet()){
			System.out.printf("Node : %d\tParent : %d\n", entry.getKey(), entry.getValue());
		}

		for(Map.Entry<Integer,Integer> entry: distMap.entrySet()){
			System.out.printf("Node : %d\tDistance : %d\n", entry.getKey(), entry.getValue());
		}

		
	}

	public boolean reduce(Map<Integer, Integer> distMap, Map<Integer, Integer> parentMap){
		
		for(int counter=0; counter<nodeCount-1; counter++){
			//System.out.println("Running loop : "+counter);	
			for(Edge edge:edges){
				//System.out.println("Checking edge : "+edge.endPt1+"-"+edge.endPt2+"\tDistance (cummulative) : "+(distMap.get(edge.endPt1)+edge.dist)+
				//				"\tDistance of endPt2 : "+distMap.get(edge.endPt2));
				if((distMap.get(edge.endPt1)+edge.dist) < distMap.get(edge.endPt2)){
					distMap.put(edge.endPt2,(distMap.get(edge.endPt1)+edge.dist));
					parentMap.put(edge.endPt2, edge.endPt1);
				}
			}
		}
		
		for(Edge edge:edges){
				//System.out.println("Checking edge : "+edge.endPt1+"-"+edge.endPt2+"\tDistance (cummulative) : "+(distMap.get(edge.endPt1)+edge.dist)+
				//				"\tDistance of endPt2 : "+distMap.get(edge.endPt2));
			if((distMap.get(edge.endPt1)+edge.dist) < distMap.get(edge.endPt2)){
				return true;
				//distMap.put(edge.endPt2,(distMap.get(edge.endPt1)+edge.dist));
				//parentMap.put(edge.endPt2, edge.endPt1);
			}
		}
		return false;
	}

	public static void main(String[] args){

		BellmanFord object = new BellmanFord(10);
		object.addEdge(0,2,1);
		object.addEdge(2,1,9);
		object.addEdge(0,8,8);
		object.addEdge(1,5,7);
		object.addEdge(5,8,5);
		object.addEdge(8,6,3);
		object.addEdge(6,9,7);
		object.addEdge(9,7,9);
		object.addEdge(7,6,1);
		object.addEdge(3,9,4);
		object.addEdge(4,3,5);
		object.addEdge(8,3,2);
		object.addEdge(7,8,7);
		object.addEdge(0,4,8);
		object.addEdge(1,0,4);
		object.addEdge(3,0,5);
		object.addEdge(6,0,9);
		object.addEdge(9,8,-8);
		object.bellmanFordAlgo();
	}	
}
