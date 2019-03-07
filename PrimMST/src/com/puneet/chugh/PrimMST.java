package com.puneet.chugh;
import java.util.*;
public class PrimMST{

	private Map<Node,List<Edge>> nodes;
	public PrimMST(){
		nodes = new HashMap<>();
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
	}


	public void findMST(Node source){
		Set<Node> visited = new HashSet<>();
		Set<Node> unvisited = new HashSet<>();

		HashSet<Edge> openSet = new HashSet<>();
		HashSet<Edge> minEdgeSet = new HashSet<>();		
		HashMap<Node,Node> parent = new HashMap<>();
		HashMap<Node,Integer> distance = new HashMap<>();

		for(Node node : nodes.keySet()){
			System.out.printf("Adding node %c to unvisited\n",node.getName());
			unvisited.add(node);
		}
		
		Node nodeToVisit = source;
		Edge nextEdge = null;
		while(visited.size() != nodes.entrySet().size()){
			System.out.printf("Vising node %c \n", nodeToVisit.getName());
			visited.add(nodeToVisit);
			if(nodeToVisit.equals(source)){
				parent.put(nodeToVisit, null);
				distance.put(nodeToVisit, 0);
			}			
			else{
				parent.put(nodeToVisit, nextEdge.getStart());
				distance.put(nodeToVisit, nextEdge.getDistance());
			}

			for(Edge edge : nodes.get(nodeToVisit)){
				System.out.printf("Adding edge %c%c to openSet\n", edge.getStart().getName(), edge.getEnd().getName());
				openSet.add(edge);
			}
			nextEdge = findNext(visited, openSet);
			nodeToVisit = nextEdge == null ?  null : nextEdge.getEnd();
			printMST(distance,parent);
		}
		
		System.out.println("Print Prim MST");
		printMST(distance, parent);	
	}

	private Edge findNext(Set<Node> visited, HashSet<Edge> edgeSet){
		Edge minEdge = null;
		int min = Integer.MAX_VALUE;
		int counter = 0;
		for(Edge edge : edgeSet){
			if(counter==0 && !visited.contains(edge.getEnd())){
				minEdge = edge;
				//min = edge.getDistance();
			}
			
			if(!visited.contains(edge.getEnd()) && (edge.getDistance() < min)){
				minEdge = edge;
				min = edge.getDistance();
			}
			counter++;
		}
		return minEdge;
	}

	public void printMST(HashMap<Node,Integer> distance, HashMap<Node,Node> parent){
		
		for(Map.Entry<Node,Node> entry : parent.entrySet()){
			int dist = distance.get(entry.getKey());
			if(entry.getValue() != null){
				System.out.printf("Node %c : Parent %c : Distance %d\n",entry.getKey().getName(),entry.getValue().getName(),dist);	
			}
			else{
				System.out.printf("Node %c : Parent %s : Distance %d\n", entry.getKey().getName(), "null", dist);
			}
		}

	}

	public static void main(String[] args){
		PrimMST prim = new PrimMST();
		Node nodeA = new Node('A');
		Node nodeB = new Node('B');
		Node nodeC = new Node('C');
		Node nodeD = new Node('D');
		Node nodeE = new Node('E');
		Node nodeF = new Node('F');
		
		prim.addNode(nodeA);
		prim.addNode(nodeB);
		prim.addNode(nodeC);
		prim.addNode(nodeD);
		prim.addNode(nodeE);
		prim.addNode(nodeF);

		prim.addEdge(nodeA, nodeB, 9);
		//prim.addEdge(nodeB, nodeA, 9);
		prim.addEdge(nodeA, nodeC, 2);
		prim.addEdge(nodeC, nodeA, 2);
		prim.addEdge(nodeB, nodeD, 3);
		//prim.addEdge(nodeD, nodeB, 3);
		prim.addEdge(nodeC, nodeE, 4);
		prim.addEdge(nodeE, nodeC, 4);
		prim.addEdge(nodeC, nodeD, 6);
		//prim.addEdge(nodeD, nodeC, 6);
		prim.addEdge(nodeB, nodeE, 5);
		prim.addEdge(nodeE, nodeB, 5);
		prim.addEdge(nodeD, nodeF, 1);
		//prim.addEdge(nodeF, nodeD, 1);
		prim.addEdge(nodeE, nodeF, 7);
		prim.addEdge(nodeF, nodeE, 7);
		prim.findMST(nodeA);
		//prim.printMST();
		
	}
}
