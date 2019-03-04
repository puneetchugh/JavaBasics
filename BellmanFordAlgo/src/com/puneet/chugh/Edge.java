package com.puneet.chugh;


public class Edge{

	private Node start;
	private Node end;
	private int distance;

	public Edge(Node start, Node end, int distance){
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	public int getDistance(){
		return distance;
	}
	
	public Node getEnd(){
		return end;
	}

	public Node getStart(){
		return start;
	}

	public boolean equals(Object obj){
		
		if(this==obj)
			return true;

		if(obj==null || !(obj instanceof Edge))
			return false;

		Edge edge = (Edge) obj;

		return start.equals(edge.getStart()) &&
			end.equals(edge.getEnd()) &&
				distance==edge.getDistance();
	}

	public int hashCode(){
		
		int result = 31;
		result = 17 * result + 31*start.getName();
		result = 31 * result + 17*end.getName();
		result = 17 * result + 31*distance;
		return result; 
	}
}
