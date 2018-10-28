package com.puneet.chugh;

public class AdjacencyMatrix{

	
	private int[][] adjacencyMatrix;

	public AdjacencyMatrix(int[][] adjMatrix){
		adjacencyMatrix = adjMatrix;
	}

	public void addEdge(int start, int end, int length){
		
		if(start < adjacencyMatrix.length && end < adjacencyMatrix.length){

			adjacencyMatrix[start][end] = length;
			adjacencyMatrix[end][start] = length;
		}
	}

	public void displayGraph(){
		
		for(int i=0; i<adjacencyMatrix.length; i++){
			System.out.printf("Node  %d : ",i);
			for(int j=0; j<adjacencyMatrix.length; j++){
				System.out.printf("%d (len:%d)\t",j,adjacencyMatrix[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args){
		
		int[][] ajdMatrix = new int[10][10];
		

		AdjacencyMatrix object = new AdjacencyMatrix(ajdMatrix);
		object.addEdge(0,1,6);
		object.addEdge(1,9,4);
		object.addEdge(3,4,4);
		object.addEdge(3,9,8);
		object.addEdge(6,9,9);
		object.addEdge(5,2,2);
		object.addEdge(9,7,5);
		object.addEdge(8,4,1);
		object.addEdge(3,2,3);
		
		object.displayGraph();
		
	}
}
