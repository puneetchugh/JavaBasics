package com.puneet.chugh;
import com.puneet.chugh.Node;
import com.puneet.chugh.Edge;
import com.puneet.chugh.Graph;
import java.util.*;

public class Dijkstra{


	public void runDijkstra(Node src, Map<Node, Set<Edge>> graph){
		
		Map<Node,Integer> minDistance = new HashMap<>();
		Map<Node,Node> childParent = new HashMap<>();
		Set<Node> visited = new HashSet<>();

		setInitialDistance(graph, minDistance);
		
		
		int counter=0;
		Set<Node> keySet = graph.keySet();
		Node nodeToExplore = src;
		while(visited.size() != keySet.size()){
			if(nodeToExplore == null){
				for(Node node: keySet){
					if(!visited.add(node)){
						nodeToExplore = node;
						break;
					}
				}
			}
			System.out.println("Exploring node : "+nodeToExplore.getName());	
			if(nodeToExplore == src){
				minDistance.put(src, 0);
				childParent.put(src, null);	
			}	
			Set<Edge> edgeSet = graph.get(nodeToExplore);
			visited.add(nodeToExplore);
			nodeToExplore = exploreNeighbors(nodeToExplore, edgeSet, childParent, minDistance, visited);
				
		}

		for(Map.Entry<Node,Integer> entry : minDistance.entrySet()){
			System.out.println("Node : "+entry.getKey().getName()+"\tMin Distance : "+entry.getValue());
		}

		for(Map.Entry<Node,Node> entry : childParent.entrySet()){
			System.out.printf("Child : %c \tParent : %s\n",entry.getKey().getName(), entry.getValue() == null ? "null" : String.valueOf(entry.getValue().getName()));
			//System.out.println("Child : "+entry.getKey().getName()+"\tParent : "+ entry.getValue() == null ? "null":entry.getValue() );
		}
		
	}

	public Node exploreNeighbors(Node start, Set<Edge> edgeSet, Map<Node,Node> childParent, Map<Node, Integer> minDistance, Set<Node> visited){
	
		System.out.println("Inside exploreNeighbors()..exploring node : "+start.getName());	
		int closestNeighborDistance = 0;//This will be used for selecting the next neighbor to be explored
		Node nextClosestNeighbor = null;
		for(Edge edge : edgeSet){
			int newMinDist;
			if(minDistance.get(edge.getEnd()) > (newMinDist = minDistance.get(edge.getStart())+edge.getDistance())){
				minDistance.put(edge.getEnd(), newMinDist);
				System.out.println("Min distance found....start node : "+start.getName()+"\tend node : "+edge.getEnd().getName());	
				childParent.put(edge.getEnd(), start);
				if((closestNeighborDistance == 0 || edge.getDistance() < closestNeighborDistance) && !visited.contains(edge.getEnd())){
					closestNeighborDistance = edge.getDistance();
					nextClosestNeighbor = edge.getEnd();
				}
			}
		}
		return nextClosestNeighbor;
	}

	public void setInitialDistance(Map<Node, Set<Edge>> graph,Map<Node,Integer> minDistance){
		for(Node node: graph.keySet()){
			minDistance.put(node, Integer.MAX_VALUE);
		}
	}

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
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.runDijkstra(nodeA, graph.getGraph());

	}
}

	
