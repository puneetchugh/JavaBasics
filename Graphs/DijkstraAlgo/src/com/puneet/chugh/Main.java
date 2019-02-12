package com.puneet.chugh;
import java.util.*;
public class Main{

	public static void main(String[] args){
		
		calculateBellmanFord();	
	}

	public static Node pickNextNode(HashMap<Node,Integer> map, Node nodeA){
	
		Node minNode = null;
		int minDist = 0;
		for(Map.Entry<Node,Integer> entry : map.entrySet()){
			if((minNode == null || (entry.getValue() < minDist)) && (entry.getKey()!=nodeA)){
				minNode = entry.getKey();
				minDist = entry.getValue();
			}
		}
		return minNode;
	}
	public static void calculateBellmanFord(){
		
		Node nodeA = new Node('A');
		Node nodeB = new Node('B');
		Node nodeC = new Node('C');
		Node nodeD = new Node('D');
		Node nodeE = new Node('E');

		Edge edgeAB = new Edge(nodeA, nodeB, 9);
		Edge edgeBA = new Edge(nodeB, nodeA, 10);
		Edge edgeCA = new Edge(nodeC, nodeA, 2);
		Edge edgeAC = new Edge(nodeA, nodeC, 4);
		Edge edgeCB = new Edge(nodeC, nodeB, 8);
		//Edge edgeBC = new Edge(nodeB, nodeC, 8);
		Edge edgeBD = new Edge(nodeB, nodeD, 6);
		Edge edgeDB = new Edge(nodeD, nodeB, 7);
		//Edge edgeDE = new Edge(nodeD, nodeE, 2);
		Edge edgeED = new Edge(nodeE, nodeD, 5);
		Edge edgeCE = new Edge(nodeC, nodeE, 3);
		//Edge edgeEC = new Edge(nodeE, nodeC, 3);
		//Edge edgeDC = new Edge(nodeD, nodeC, 7);
		Edge edgeCD = new Edge(nodeC, nodeD, 7);

		
		HashSet<Node> unVisited = new HashSet<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		HashMap<Node,Integer> distance = new HashMap<Node,Integer>();
		HashMap<Node,Node> parent = new HashMap<>();
		
			
		

		unVisited.add(nodeA);
		unVisited.add(nodeB);
		unVisited.add(nodeC);
		unVisited.add(nodeD);
		unVisited.add(nodeE);

		for(Node node : unVisited){
			distance.put(node, 1_00_000);
			parent.put(node, null);
			if(node == nodeA){
				distance.put(node, 0);
			}
		}	
		
		HashSet<Edge> allEdges = new HashSet<>();
		allEdges.add(edgeAB);
		allEdges.add(edgeBA);
		allEdges.add(edgeAC);
		allEdges.add(edgeCA);
		//allEdges.add(edgeBC);
		allEdges.add(edgeCB);
		allEdges.add(edgeDB);
		allEdges.add(edgeBD);
		allEdges.add(edgeED);
		//allEdges.add(edgeDE);
		//allEdges.add(edgeEC);
		allEdges.add(edgeCE);
		allEdges.add(edgeCD);
		//allEdges.add(edgeDC);
		
		findShortestDist(allEdges, nodeA, distance, parent);
		for(int counter=0; counter<unVisited.size(); counter++){
			//System.out.println("Node selected : "+node.getName());
			
			Node next = pickNextNode(distance, nodeA);
			findShortestDist(allEdges, next, distance, parent);		
				
					
			
		}
		for(Map.Entry<Node,Integer> entry : distance.entrySet()){
			System.out.printf("%c : %d\n",entry.getKey().getName(), entry.getValue());
		}

		for(Map.Entry<Node,Node> entry : parent.entrySet()){
			if(entry.getValue() == null){
				System.out.printf("%c has null parent\n", entry.getKey().getName());
			}
			else
				System.out.printf("%c has parent %c\n", entry.getKey().getName(), entry.getValue().getName());
		}
	}

	public static void findShortestDist(HashSet<Edge> edges, Node node, HashMap<Node,Integer> distance, HashMap<Node,Node> parent){

		System.out.printf("Node selected %c\n",node.getName());
		for(Edge edge : edges){
			if(edge.getEnd().getName() == 'A')
				continue;
			if(!edge.getStart().equals(node))
				continue;
			System.out.printf("Edge %c%c selected\n",edge.getStart().getName(), edge.getEnd().getName());
			int startDist = distance.get(edge.getStart());
			int endDist = distance.get(edge.getEnd());
				
			if(endDist > (startDist+edge.getDistance())){
				distance.put(edge.getEnd(), (startDist+edge.getDistance()));
				parent.put(edge.getEnd(), edge.getStart());
				
			}
		}

		for(Map.Entry<Node,Integer> entry : distance.entrySet()){
			System.out.printf("Key : %c   Value : %d\t",entry.getKey().getName(), entry.getValue());
		}
	}
}
