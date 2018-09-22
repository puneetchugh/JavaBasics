/*********************************************************** 
*  In Huffman tree, all character nodes are the leaf nodes.*
*  The code for every character is the traversal from root *
*  to the particular leaf node.				   *
*  The characters are inserted in a min heap with their    *
*  respective frequencies. The first two characters are    *
*  withdrawn and their frequencies are added to form a new * 
*  internal node, called 'Z' in my code. We keep adding    *
*  two nodes at a time until only one node is left.        *
***********************************************************/
package com.puneet.chugh;
import java.util.*;

public class Huffman{

	Set<Node> treeSet = new TreeSet<>();
	
	public void createHuffmanTree(String pattern){
		
		Set<Node> initialNodes = createInitialTree(pattern);

		while(initialNodes.size() >= 2){
			int counter = 0;
			Node node1 = null;
			Node node2 = null;
			for(Node node : initialNodes){
				counter++;

				if(counter==1){
					node1 = node;
				}
				else if(counter == 2){
					node2 = node;
				}
				else{
					break;
				}
			}
			if(node1 != null && node2 != null){

				Node newNode = new Node(node1.getFrequency()+node2.getFrequency(),
							'Z',
							node1,
							node2);
				initialNodes.add(newNode);
			}
			initialNodes.remove(node1);
			initialNodes.remove(node2);
			
			
		}
		System.out.println("initialNodes.size() == "+initialNodes.size());	
		if(initialNodes.size()==1){
			System.out.println("Node : "+initialNodes.iterator().next().getCharacter()+
					   "\tFrequency : "+initialNodes.iterator().next().getFrequency()+
					   "\tNode left : "+initialNodes.iterator().next().getLeftNode()+
					   "\tNode right : "+initialNodes.iterator().next().getRightNode());
		}	

	}

	public  Set<Node> createInitialTree(String pattern){
		
		Set<Node> initialNodes = new TreeSet<>();
		List<Node> nodesToBeDeleted = new ArrayList<>();

		for(int counter = 0; counter < pattern.length(); counter++){
			char individualChar = pattern.charAt(counter);
			int freq = 1;
			Node newNode;
			Node oldNode = null;
			for(Node node : initialNodes){
				if(node.getCharacter() == individualChar){
					freq+=node.getFrequency();	
					oldNode = node;
				}
			}
			if(oldNode != null){
				initialNodes.remove(oldNode);
			}
			initialNodes.add(new Node(freq, individualChar));
		}

		for(Node node: initialNodes){
			System.out.println("Node : Charater : "+node.getCharacter()+
					    "\tFrequency : "+node.getFrequency());
		}	
	
		return initialNodes;
	}
	
	public static void main(String[] args){
		
		Huffman huffman = new Huffman();
//		huffman.createInitialTree("ABCBAACD");

		huffman.createHuffmanTree("ABCBAACD");
	}	
}
