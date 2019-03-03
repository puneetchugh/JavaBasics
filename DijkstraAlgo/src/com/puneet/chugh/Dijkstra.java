package com.puneet.chugh;
import java.util.*;

public class Dijkstra{

	Map<Node,List<Edge>> nodes;
	Map<Node,Node> parent;
	Map<Node,Integer> distance;
	Set<Node> visited;
	Map<Node,Integer> openList;

	public Dijkstra(){
		nodes = new HashMap<>();
		parent = new HashMap<>();
		distance = new HashMap<>();
		visited = new HashSet<>();
		openList = new HashMap<>();
		//addInitialDistance();
	}

	public void addInitialDistance(){
		//System.out.println("addInitialDistance() called...");
		for(Map.Entry<Node, List<Edge>> entry : nodes.entrySet()){
			openList.put(entry.getKey(), 10000);
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
	}

	public void findPath(Node source){
	
		Node visit = source;
		int counter = nodes.size();
		
		while(counter > 0){
			//System.out.printf("Visiting node : %c\n",visit.getName());
			counter--;
			if(visit.equals(source)){
				distance.put(visit,0);
				parent.put(visit,null);
			}
			else{
				distance.put(visit, openList.get(visit));
			}
			visited.add(visit);
			if(openList.containsKey(visit))
				openList.remove(visit);
			exploreNeighbors(visit);
			visit = findNext();
		}
	}	

	public void exploreNeighbors(Node par){
		
		List<Edge> edges = nodes.get(par);
		for(Edge edge : edges){
			Node node = edge.getEnd();
			//System.out.printf("Exploring neighbor %c\n",node.getName());
			if(!visited.contains(node)){
				//System.out.printf("Distance of %c via %c is %d\n", node.getName(), edge.getStart().getName(),(distance.get(par)+ edge.getDistance()) );
				if(openList.get(node) > (distance.get(par)+ edge.getDistance())){
					openList.put(node, (distance.get(par)+edge.getDistance()));
					parent.put(node, par);
				}
			}
		}
		//System.out.println("openList contains");
		//for(Map.Entry<Node,Integer> entry : openList.entrySet()){
		//	System.out.printf("Node : %c\tdistance : %d\n", entry.getKey().getName(), entry.getValue());
		//}
	}

	public Node findNext(){
		
		int min = Integer.MAX_VALUE;
		Node minNode = null;	
		for(Map.Entry<Node,Integer> entry: openList.entrySet()){
			if(entry.getValue()<min){
				minNode = entry.getKey();
				min = entry.getValue();
			}
		}
		return minNode;
	}
	
	public void printPath(){
		
		for(Node node : visited){
			int dist = distance.get(node);
			Node par = parent.get(node);
			if(par!=null)
				System.out.printf("Node : %c, Parent : %c, Distance : %d\n", node.getName(), par.getName(), dist);
			else
				System.out.printf("Node : %c, Parent : %s, Distance : %d\n", node.getName(), "null", dist);
		}
	}

	public static void main(String[] args){
		
		Dijkstra dijkstra = new Dijkstra();
		Node nodeA = new Node('A');
		Node nodeB = new Node('B');
		Node nodeC = new Node('C');
		Node nodeD = new Node('D');
		Node nodeE = new Node('E');
		Node nodeF = new Node('F');
		
		dijkstra.addNode(nodeA);
		dijkstra.addNode(nodeB);
		dijkstra.addNode(nodeC);
		dijkstra.addNode(nodeD);
		dijkstra.addNode(nodeE);
		dijkstra.addNode(nodeF);

		dijkstra.addInitialDistance();
		dijkstra.addEdge(nodeA, nodeB, 9);
		dijkstra.addEdge(nodeB, nodeA, 9);
		dijkstra.addEdge(nodeA, nodeC, 2);
		dijkstra.addEdge(nodeC, nodeA, 2);
		dijkstra.addEdge(nodeB, nodeD, 3);
		dijkstra.addEdge(nodeD, nodeB, 3);
		dijkstra.addEdge(nodeC, nodeE, 4);
		dijkstra.addEdge(nodeE, nodeC, 4);
		dijkstra.addEdge(nodeC, nodeD, 6);
		dijkstra.addEdge(nodeD, nodeC, 6);
		dijkstra.addEdge(nodeB, nodeE, 5);
		dijkstra.addEdge(nodeE, nodeB, 5);
		dijkstra.addEdge(nodeD, nodeF, 1);
		dijkstra.addEdge(nodeF, nodeD, 1);
		dijkstra.addEdge(nodeE, nodeF, 7);
		dijkstra.addEdge(nodeF, nodeE, 7);
		
		dijkstra.findPath(nodeA);
		dijkstra.printPath();
		
		
		
	}
}
