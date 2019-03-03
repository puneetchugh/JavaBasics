package com.puneet.chugh;

public class Node implements Comparable<Node>{

	char name;	
	public Node(char name){
		this.name = name;
	}
	
	public char getName(){
		return name;
	}
	
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		
		if(obj==null || !(obj instanceof Node))
			return false;

		Node node = (Node) obj;
		return name==node.getName(); 
	}
	
	public int hashCode(){
		return (int)name;
	}

	public int compareTo(Node node){
		return (int)name-(int)node.getName();	
	}

}
