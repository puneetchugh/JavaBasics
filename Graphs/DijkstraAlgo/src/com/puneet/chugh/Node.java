package com.puneet.chugh;

public class Node{
	
	char name;
	public Node(char name){
		this.name = name;
	}

	public char getName(){
		return name;
	}

	@Override
	public boolean equals(Object obj){

		if(this==obj)
			return true;
		else if(obj == null || !(obj instanceof Node))
			return false;

		Node node = (Node) obj;
		return node.getName() == name;
	}	
}
