package com.puneet.chugh;

public class Edge{
	Node start,end;
	public Edge(Node start, Node end){
		this.start = start;
		this.end = end;
	}

	public boolean equals(Object obj){
		if(obj==this)
			return true;
		
		else if(obj==null || !(obj instanceof Edge))
			return false;
	
		Edge edge = (Edge) obj;
		
		return (edge.start == start) &&
			(edge.end == end);
	}

	public int hashCode(){

		int retVal = 17;
		retVal = retVal + (31*start.name);
		retVal = retVal + (17*end.name);
		return (17*retVal);
	} 
}
