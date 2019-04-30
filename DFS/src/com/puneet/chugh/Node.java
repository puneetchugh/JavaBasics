package com.puneet.chugh;

public class Node{
	
	char name;
	Node(){}
	Node(char name){
		this.name = name;
	}
	
	public boolean equals(Object obj){
		if(obj == this)
			return true;
		
		else if(obj == null || !(obj instanceof Node))
			return false;

		Node node = (Node) obj;
		return node.name == name;
	}
	
	public int hashCode(){
		return (int)name;
	}
}
