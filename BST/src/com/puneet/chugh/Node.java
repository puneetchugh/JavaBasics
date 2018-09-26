package com.puneet.chugh;

public class Node{

	int data;
	Node left,right;

	public Node(int data){
		this.data = data;
	}
	
	public Node(){}	

	public void setLeft(Node left){
		this.left = left;
	}
	public Node getLeft(){
		return left;
	}

	public void setRight(Node right){
		this.right = right;
	}
	
	public Node getRight(){
		return right;
	}

	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
}
