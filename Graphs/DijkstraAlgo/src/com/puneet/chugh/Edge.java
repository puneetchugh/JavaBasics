package com.puneet.chugh;

public class Edge{

	Node start;
	Node end;
	int dist;
	public Edge(Node start, Node end, int dist){
		this.start = start;
		this.end = end;
		this.dist = dist;
	}

	public int getDistance(){
		return dist;
	}
	
	public Node getStart(){
		return start;
	}
	
	public Node getEnd(){
		return end;
	}

	@Override
	public boolean equals(Object obj){
		
		if(this==obj)
			return true;
		
		else if(obj==null || !(obj instanceof Edge)){
			return false;
		}

		Edge edge = (Edge)obj;

		return edge.getStart().equals(start) &&
			edge.getEnd().equals(end) &&
			edge.getDistance() == dist;
	}

	@Override 
	public int hashCode(){
		return 31 * ((17*start.hashCode())+(31*end.hashCode()));
	}
}

