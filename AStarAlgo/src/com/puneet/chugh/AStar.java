package com.puneet.chugh;
import java.util.*;
public class AStar{

	private TreeSet<Node> openList;
	private List<Node> closedList;
	private HashSet<Node> visited;
	private Node start,end;
	private int size;
	public AStar(int size, Node start, Node end){
 		closedList = new LinkedList<>();
		openList = new TreeSet<>();
		
		this.size = size;
		this.start = start;
		this.end = end;
	}

	public void findPathAStar(){
		
		int counter=0;
		Node parent = start;
		while((counter==0) || !(parent.equals(end))){
			//System.out.printf("next node is (%d,%d)\n", parent.getX(), parent.getY());
			counter++;
			closedList.add(parent);
			if(openList.contains(parent))
				openList.remove(parent);
			List<Node> neighbors = getNeighborList(parent);
			addToOpenList(parent, neighbors);
			parent = findNext();
		}
		closedList.add(parent);
	}

	public void printPath(){

		System.out.printf("Path from (%d,%d) -> (%d,%d) : \n", start.getX(), start.getY(), end.getX(), end.getY());
		for(Node node : closedList){
			System.out.printf("(%d,%d)\n", node.getX(), node.getY());
		}
	}

	public Node findNext(){
		Iterator<Node> iterator = openList.iterator();
		Node parent = null;
		while(iterator.hasNext()){
			parent = iterator.next();
			break;
		}
		//iterator.close();
		return parent;
	}

	//this would return the neighbor list of the 
	//input node
	public List<Node> getNeighborList(Node node){
	
		int x=node.getX();
		int y=node.getY();
		int initX = (x==0) ? x : x-1;
		int initY = (y==0) ? y : y-1;
		int endX = (x==(size-1)) ? x : x+1;
		int endY = (y==(size-1)) ? y : y+1;
		int counterX = initX,
		    counterY = initY;
		//System.out.printf("End node is (%d,%d)\n", endX, endY);	
		List<Node> neighborList = new LinkedList<Node>();
		
		//System.out.println("Adding neighbor list...");
		for(;counterX <= endX; counterX++){
			for(;counterY <= endY; counterY++){
				//System.out.printf("Inspecting neighbor node (%d,%d)\n", counterX, counterY);
				if(counterX == x && counterY == y)
					continue;
				//System.out.printf("Adding node : (%d,%d)\n", counterX, counterY);
				neighborList.add(new Node(counterX, counterY));	
			}
			counterY=initY;	
		}
		return neighborList;
	}

	//this would formally add the distances g and h to each node
	//in the open list. Only those nodes would be added that 
	//haven't been visited yet. This method would also identify 
	//the nodes already in the openlist and would calcuate distance 
	//for them accordingly
	public void addToOpenList(Node parent, List<Node> neighborList){
		
		//System.out.println("Neighbor list");
		for(Node node : neighborList){
			if(!closedList.contains(node)){
				//System.out.printf("Node (%d,%d)\n", node.getX(), node.getY());
				double g = parent.getG()+
					Math.sqrt(Math.abs(Math.pow((node.getX()-parent.getX()),2)+Math.pow((node.getY()-parent.getY()),2)));
				double h = Math.sqrt(Math.abs(Math.pow((end.getX()-node.getX()),2)+Math.pow((end.getY()-node.getY()),2)));
				double f = g+h;
				//if the node already exists in the open list, check if 
				//previous total distance is less than new total distance
				if(openList.contains(node) && node.getDistance()<f){
					//System.out.println("Node already exists..");
					continue;
				}
				else{
					//System.out.println("Adding node...");
					node.setG(g);
					node.setH(h);
					openList.add(node);
				}
			}
		}
	}

	public static void main(String[] args){
		Node start = new Node(0,0);
		Node end = new Node(0,4);
		AStar aStar = new AStar(5, start, end);
		aStar.findPathAStar();
		aStar.printPath();
		
		
		start = new Node(0,4);
		end = new Node(4,0);
		aStar = new AStar(5, start, end);
		aStar.findPathAStar();
		aStar.printPath();

		start = new Node(4,4);
		end = new Node(1,1);
		aStar = new AStar(5, start, end);
		aStar.findPathAStar();
		aStar.printPath();
	}
}
