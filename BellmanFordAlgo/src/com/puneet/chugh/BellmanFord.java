package com.puneet.chugh;
import java.util.*;

public class BellmanFord{

	Map<Node,List<Edge>> nodes;
	HashSet<Edge> edgeSet;
	Map<Node,Node> parent;
	Map<Node,Integer> distance;

	public BellmanFord(){
		nodes = new HashMap<>();
		parent = new HashMap<>();
		distance = new HashMap<>();
		edgeSet = new HashSet<>();
	}

	public void addInitialDistance(){
		//System.out.println("addInitialDistance() called...");
		for(Map.Entry<Node, List<Edge>> entry : nodes.entrySet()){
			distance.put(entry.getKey(), 10000);
		}
	}

	public void addNode(Node node){
		//Node node = createNode(name);
		nodes.put(node, null);
	}
	
	//Not being used
	public Node createNode(char name){
		return new Node(name);
	}

	public void addEdge(Node start, Node end, int distance){
		
		Edge edge = new Edge(start, end, distance);
		List<Edge> edges;
		if(nodes.get(start) == null){
			edges = new LinkedList<>();
			edges.add(edge);
		}
		else{
			edges = nodes.get(start);
			edges.add(edge);
		}
		nodes.put(start,edges);
		edgeSet.add(edge);
	}

	public boolean findPath(Node source){
	
		Node visit = source;
		int counter = nodes.size()-1;
		distance.put(visit, 0);
		parent.put(visit,null);
		while(counter > 0){
			//System.out.printf("Visiting node : %c\n",visit.getName());
			counter--;
			for(Edge edge : edgeSet){
				if(distance.get(edge.getStart()) != 10000 &&
					(distance.get(edge.getEnd()) > (distance.get(edge.getStart())+edge.getDistance()))){
						distance.put(edge.getEnd(), (distance.get(edge.getStart())+edge.getDistance()));
						parent.put(edge.getEnd(), edge.getStart());	
				}
			}
		}

		for(Edge edge : edgeSet){
				//System.out.println("Running to find out negative cycle....");
				if(distance.get(edge.getStart()) != 10000 &&
					(distance.get(edge.getEnd()) > (distance.get(edge.getStart())+edge.getDistance()))){
						System.out.println("Negative cycle found...");
							return true;
						}
			}
		return false;
	}	

	public void printPath(){
		
		for(Map.Entry<Node,Integer> entry : distance.entrySet()){
			System.out.printf("Node %c, distance %d\n", entry.getKey().getName(), entry.getValue());
		}
	}

	public static void main(String[] args){
		
		BellmanFord bellmanFord = new BellmanFord();
		Node nodeA = new Node('A');
		Node nodeB = new Node('B');
		Node nodeC = new Node('C');
		Node nodeD = new Node('D');
		Node nodeE = new Node('E');
		Node nodeF = new Node('F');
		
		bellmanFord.addNode(nodeA);
		bellmanFord.addNode(nodeB);
		bellmanFord.addNode(nodeC);
		bellmanFord.addNode(nodeD);
		bellmanFord.addNode(nodeE);
		bellmanFord.addNode(nodeF);

		bellmanFord.addInitialDistance();
		bellmanFord.addEdge(nodeA, nodeB, 9);
		bellmanFord.addEdge(nodeB, nodeA, -9);
		bellmanFord.addEdge(nodeA, nodeC, 2);
		bellmanFord.addEdge(nodeC, nodeA, 2);
		bellmanFord.addEdge(nodeB, nodeD, 3);
		//bellmanFord.addEdge(nodeD, nodeB, -3);
		bellmanFord.addEdge(nodeC, nodeE, 4);
		bellmanFord.addEdge(nodeE, nodeC, 4);
		bellmanFord.addEdge(nodeC, nodeD, 6);
		bellmanFord.addEdge(nodeD, nodeC, 6);
		bellmanFord.addEdge(nodeB, nodeE, 5);
		bellmanFord.addEdge(nodeE, nodeB, 5);
		bellmanFord.addEdge(nodeD, nodeF, 1);
		bellmanFord.addEdge(nodeF, nodeD, 1);
		bellmanFord.addEdge(nodeE, nodeF, 7);
		bellmanFord.addEdge(nodeF, nodeE, 7);
		
		boolean negativeCycle = bellmanFord.findPath(nodeA);
		if(negativeCycle){
			System.out.println("There's a negative cycle in the..no min distances");
			return;
		}
		System.out.println("The minimum distances to every node are : ");
		bellmanFord.printPath();
	}
}
