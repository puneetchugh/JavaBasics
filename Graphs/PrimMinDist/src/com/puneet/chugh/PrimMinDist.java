package com.puneet.chugh;
import java.util.*;
public class PrimMinDist{


	class Node{
		int name;
		int dist;
		
		public Node(int name, int dist){
			this.name = name;
			this.dist = dist;
		}

		
	}
	Object[] object;

	public PrimMinDist(int size){
		object = new Object[size];
	}

	public void addEdge(int nodeA, int nodeB, int dist){
		List<Node> list;

		System.out.printf("Adding edge %d-%d\tDistance : %d\n", nodeA, nodeB, dist);
		if((list = (List<Node>)object[nodeA]) == null){
			list = new LinkedList<>();
		}
		list.add(new Node(nodeB, dist));
		object[nodeA] = list;	
	
		if((list = (List<Node>)object[nodeB]) == null){
			list = new LinkedList<>();
		}
		list.add(new Node(nodeA, dist));
		object[nodeB] = list;
	}

	public void displayGraph(){
		
		for(int counter=0; counter<object.length; counter++){

			System.out.printf("Node %d :",counter);
			List<Node> list = (List<Node>)object[counter];
			for(Node node : list){
				System.out.printf("Edge %d%d (cost:%d)\t", counter, node.name, node.dist);
			}
			System.out.println("");
		}
	}

	public void calPrimMin(){

		//Map<Integer,Boolean> includedMap = new HashMap<Integer,Boolean>();
		//Map<Integer,Integer> minDist = new HashMap<Integer,Integer>();
		boolean[] includeNodes = new boolean[object.length];
		int[] minDist = new int[object.length];

		Arrays.fill(includeNodes, false);
		Arrays.fill(minDist, 1000);
		minDist[0] = 0;
		int minVal = 0;
		for(int counter=0; counter<object.length; counter++){
			int[] min = findMin(minDist, includeNodes);
			
			//while(includeNodes[min[1]]==true){}
			includeNodes[min[1]] = true;
			for(Node node : (List<Node>)object[min[1]]){
				if(includeNodes[node.name]!=true){
					minDist[node.name]=node.dist;
				}
			}	
		}	
		/*
		for(int counter=0; counter<object.length; counter++){

			includeMap.put(counter,false);
			minDist.put(counter, 1000);
		}*/
		for(int counter=0; counter<object.length; counter++){
			System.out.printf("Node : %d\tDistance : %d\n", counter,minDist[counter] );
		}	
		
	}
	
	public int[] findMin(int[] array, boolean[] includeNodes){

		int min = Integer.MAX_VALUE;
		int index = 0;
		for(int counter=0; counter<array.length; counter++){
			if(array[counter] < min) {
			
				if(!includeNodes[counter]){
					min = array[counter];
					index = counter;
				}	
			}
		}
		return new int[]{min, index};
	}	
/*
	public int findIndex(int val, int[] array){
		
		for(int counter=0; counter<array.length; counter++){
			
			if(val==array[counter]){
				return counter;
			}
			//val==array[counter] ? return counter : continue;
		}
	}
*/
	public static void main(String[] args){
		
		PrimMinDist object = new PrimMinDist(10);

		object.addEdge(0,1,1);
		object.addEdge(0,2,4);
		object.addEdge(1,2,8);
		object.addEdge(9,1,2);
		object.addEdge(8,1,1);
		object.addEdge(7,2,7);
		object.addEdge(7,8,4);
		object.addEdge(3,2,9);
		object.addEdge(5,4,8);
		object.addEdge(2,6,6);
		object.addEdge(4,7,2);
		object.addEdge(6,4,8);
		object.addEdge(2,8,6);
		object.displayGraph();

		object.calPrimMin();
		
	}
}
