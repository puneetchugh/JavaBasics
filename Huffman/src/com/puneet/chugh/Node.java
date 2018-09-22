package com.puneet.chugh;

public class Node implements Comparable<Node>{

	int freq;
	char character;
	Node left;
	Node right;

	public Node(int freq, char character, Node left, Node right){
		this.freq = freq;
		this.character = character;
		this.left = left;
		this.right = right;
	}

	public Node(int freq, char character){
		this(freq, character, null, null);
	}

	public void setLeftNode(Node left){
		this.left = left;
	}
	
	public Node getLeftNode(){
		return left;
	}
	
	public void setRightNode(Node right){
		this.right = right;
	}	

	public Node getRightNode(){
		return right;
	}

	public int getFrequency(){
		return freq;
	}

	public char getCharacter(){
		return character;
	}
	
	@Override
	public int compareTo(Node node){
		if(this==node)
			return 0;

		if(freq != node.getFrequency()){
			return freq-node.getFrequency();
		}	
		else{
			return character-node.getCharacter();
		}
	}
}

