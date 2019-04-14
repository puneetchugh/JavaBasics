package com.puneet.chugh;
import java.util.Set;
import java.util.HashSet;
public class Main{

	public static Set<Pair> visited = new HashSet<>();
	public static class Pair{

		int x,y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj){
			if(obj == this)
				return true;

			if(obj == null || !(obj instanceof Pair))
				return false;

			Pair p = (Pair) obj;

			return ((p.x==x) &&
				(p.y ==y));
		}
		
		@Override
		public int hashCode(){
			int result = 31;
			result += 17*(x);
			result += 31*(y);
			return result;
		}
		
	}
	public static int findBiggestIsland(int[][] matrix, int x, int y){
		System.out.printf("Visiting (%d,%d)\n", x,y);	
		int count = 0;
		visited.add(new Pair(x,y));
		
		if(matrix[x][y] == 1)
			count++;
		else
			return count;	
		
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		
		
		if((x+1)<rowCount &&  matrix[x+1][y]==1 && !(visited.contains(new Pair(x+1,y))) ){
			count += findBiggestIsland(matrix, x+1, y);
		}

		if((x-1)>=0 && matrix[x-1][y]==1 && !(visited.contains(new Pair(x-1,y))) ){
			count += findBiggestIsland(matrix, x-1, y);
		}

		if((y+1)<colCount  && matrix[x][y+1]==1 && !(visited.contains(new Pair(x,y+1)))){
			count += findBiggestIsland(matrix, x, y+1);
		}

		if((y-1)>=0  && matrix[x][y-1]==1 && !(visited.contains(new Pair(x,y-1)))){
			count += findBiggestIsland(matrix, x, y-1);
		}
		//System.out.printf("New count : %d\n",count);
		return count;
	}

	public static void main(String[] args){
		
		int[][] matrix = new int[][]{{1,0,1,0,1,1},
					     {0,0,1,1,1,0},
					     {0,0,1,1,0,0}};

		int biggest = 0;
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		//System.out.printf("rowCount = %d, colCount = %d\n", rowCount, colCount);
		for(int rowCounter=0; rowCounter<rowCount; rowCounter++){
			//System.out.printf("On row %d\n",rowCounter);
			for(int colCounter=0; colCounter < colCount; colCounter++){
				//System.out.printf("Visiting (%d,%d) inside loop\n", rowCounter, colCounter);
				if(!visited.contains(new Pair(rowCounter,colCounter))){
					int localBiggest = findBiggestIsland(matrix, rowCounter, colCounter);
					if(localBiggest > biggest)
						biggest = localBiggest;
	
				}
			}
		}
	
		System.out.printf("Biggest island : %d\n", biggest);
	}	
}
