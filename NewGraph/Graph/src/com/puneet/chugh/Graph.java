package com.puneet.chugh;
import java.util.*;
public class Graph{

	Map<Node,Set<Edge>> graphHashMap;

	public Graph(){
		graphHashMap = new HashMap<>();
	}

	public Map<Node, Set<Edge>> getGraph(){
		return graphHashMap;
	}

	public Node createNode(char name){

		return new Node(name);
		
	}

	public Edge createEdge(Node start, Node end, int distance){
		return new Edge(start, end, distance);
	}

	public void addNodeNEdges(Node node, Edge...edges){

		Set<Edge> edgesSet = new HashSet<>();
		for(Edge edge: edges){
			edgesSet.add(edge);
		}

		graphHashMap.put(node, edgesSet);
	}

	public void showGraph(){

		System.out.println("Showing the graph....");
		for(Map.Entry<Node, Set<Edge>> entry : graphHashMap.entrySet()){
			char nodeName = entry.getKey().getName();
			for(Edge edge: entry.getValue()){
				System.out.printf("%c -> %c : %d\n",nodeName,edge.getEnd().getName(), edge.getDistance());
			}
			System.out.printf("\n");
			
		}
	}
/*
	public static void main(String[] args){


		Graph graph = new Graph();	
		Node nodeA = graph.createNode('A');
		Node nodeB = graph.createNode('B');
		Node nodeC = graph.createNode('C');
		Node nodeD = graph.createNode('D');
		Node nodeE = graph.createNode('E');

		Edge edgeAB = graph.createEdge(nodeA, nodeB, 5);
		Edge edgeBA = graph.createEdge(nodeB, nodeA, 5);
		Edge edgeAC = graph.createEdge(nodeA, nodeC, 2);
		Edge edgeCA = graph.createEdge(nodeC, nodeA, 2);
		Edge edgeBD = graph.createEdge(nodeB, nodeD, 7);
		Edge edgeDB = graph.createEdge(nodeD, nodeB, 7);
		Edge edgeBC = graph.createEdge(nodeB, nodeC, 2);
		Edge edgeCB = graph.createEdge(nodeC, nodeB, 2);
		Edge edgeCE = graph.createEdge(nodeC, nodeE, 3);
		Edge edgeEC = graph.createEdge(nodeE, nodeC, 3);
		Edge edgeDE = graph.createEdge(nodeD, nodeE, 1);
		Edge edgeED = graph.createEdge(nodeE, nodeD, 1);
		
		graph.addNodeNEdges(nodeA, edgeAB, edgeAC);
		graph.addNodeNEdges(nodeB, edgeBA, edgeBD, edgeBC);
		graph.addNodeNEdges(nodeC, edgeBC, edgeCE, edgeCA);
		graph.addNodeNEdges(nodeD, edgeDB);
		graph.addNodeNEdges(nodeE, edgeEC, edgeED);
		
		graph.showGraph();	
			
	}*/	
}
