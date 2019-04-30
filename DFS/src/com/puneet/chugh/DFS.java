package com.puneet.chugh;
import java.util.*;
public class DFS{

	Map<Node,List<Edge>> adjList;
	
	DFS(){
		adjList = new HashMap<>();
	}

	public void addNode(Node node){

		System.out.printf("Adding node : %c\n", node.name);
		adjList.put(node, null);
	}

	public void addEdge(Node start, Node end){
		System.out.printf("Adding edge (%c,%c)\n",start.name, end.name);
		List<Edge> neighborList;
		if(adjList.containsKey(start)){

			if(adjList.get(start) != null){
				neighborList = adjList.get(start);
			}
			else
				neighborList = new LinkedList<>();
			
			neighborList.add(new Edge(start,end));
			adjList.put(start, neighborList);
		}
	}

	public void DFSUtils(Node node, Stack<Node> stack, Set<Node> visited){

		if(visited.contains(node)){
			return;
		}
		visited.add(node);
		System.out.printf("Visiting %c \n",node.name);
		for(Edge edge : adjList.get(node)){
			Node dest = edge.end;
			if(visited.contains(dest)){
				continue;
			}
			System.out.printf("Adding %c to stack\n",dest.name);
			stack.push(dest);
		}
		if(stack.size() > 0)	
			DFSUtils(stack.pop(), stack, visited);
	}
	
	public void DFSTraversal(Node start){
			
		Stack<Node> stack = new Stack();
		Set<Node> visited = new HashSet();
		DFSUtils(start, stack, visited);
	}

	public static void main(String[] args){
		Node nodeA = new Node('A');
		Node nodeB = new Node('B');
		Node nodeC = new Node('C');
		Node nodeD = new Node('D');
		Node nodeE = new Node('E');
		Node nodeF = new Node('F');
		Node nodeG = new Node('G');
		Node nodeH = new Node('H');
		Node nodeI = new Node('I');
		Node nodeJ = new Node('J');
		Node nodeK = new Node('K');

		DFS dfs = new DFS();
		dfs.addNode(nodeA);
		dfs.addNode(nodeB);
		dfs.addNode(nodeC);
		dfs.addNode(nodeD);
		dfs.addNode(nodeE);
		dfs.addNode(nodeF);
		dfs.addNode(nodeG);
		dfs.addNode(nodeH);
		dfs.addNode(nodeI);
		dfs.addNode(nodeJ);
		dfs.addNode(nodeK);

		dfs.addEdge(nodeA,nodeB);
		dfs.addEdge(nodeB,nodeA);
		dfs.addEdge(nodeA,nodeC);
		dfs.addEdge(nodeC,nodeA);
		dfs.addEdge(nodeA,nodeD);
		dfs.addEdge(nodeD,nodeA);
		dfs.addEdge(nodeB,nodeE);
		dfs.addEdge(nodeE,nodeB);
		dfs.addEdge(nodeB,nodeF);
		dfs.addEdge(nodeF,nodeB);
		dfs.addEdge(nodeC,nodeG);
		dfs.addEdge(nodeG,nodeC);
		dfs.addEdge(nodeC,nodeH);
		dfs.addEdge(nodeH,nodeC);
		dfs.addEdge(nodeD,nodeI);
		dfs.addEdge(nodeI,nodeD);
		dfs.addEdge(nodeE,nodeJ);
		dfs.addEdge(nodeJ,nodeE);
		dfs.addEdge(nodeF,nodeK);
		dfs.addEdge(nodeK,nodeF);

		dfs.DFSTraversal(nodeA);
	}
}
