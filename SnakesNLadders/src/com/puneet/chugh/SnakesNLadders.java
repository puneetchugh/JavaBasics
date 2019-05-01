package com.puneet.chugh;
import java.util.*;

public class SnakesNLadders{

	private int[] moves;
	private int[][] ladders;
	private int[][] snakes;
	public SnakesNLadders(int size, int[][] ladders, int[][] snakes){
		this.moves = new int[size];
		this.ladders = ladders;
		this.snakes = snakes;
		fillMoves();
	}

	private void fillMoves(){
		for(int counter=0; counter<moves.length; counter++){
			moves[counter] = -1;
		}
		for(int counter=0; counter<ladders.length; counter++){
			int[] ladder = ladders[counter];
			moves[ladder[0]-1] = ladder[1]-1;
		}
		for(int counter=0; counter<snakes.length; counter++){
			int[] snake = snakes[counter];
			moves[snake[0]-1] = snake[1]-1;
		}
	}

	public int calculateLeastDieRoll(){

		Queue<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[moves.length];
		queue.add(new Node(0,0));

		while(!queue.isEmpty()){
			
			Node visiting = queue.remove();
			visited[visiting.pathPoint] = true;
			if(visiting.pathPoint == (moves.length-1)){
				return visiting.dist;
			}
			
			System.out.printf("Visiting %d\n",visiting.pathPoint);
			for(int counter=1; counter<=6; counter++){
				System.out.printf("Exploring %d\n",(visiting.pathPoint+counter));
				if((visiting.pathPoint+counter >= moves.length) || (visited[visiting.pathPoint+counter]))
					continue;
				Node neighbor = new Node();
				
				neighbor.dist = visiting.dist+1;

				if(moves[visiting.pathPoint+counter] != -1)
					neighbor.pathPoint = moves[visiting.pathPoint+counter];

				else
					neighbor.pathPoint = visiting.pathPoint+counter;

				queue.add(neighbor);
			}
		}
		
		return 0;	
	}

	
	public static void main(String[] args){

		int size = 30;
		int[][] ladders = new int[4][];
		ladders[0] = new int[]{2,21};
		ladders[1] = new int[]{4,7};
		ladders[2] = new int[]{10,25};
		ladders[3] = new int[]{19,28};
		
		int[][] snakes = new int[4][];
		snakes[0] = new int[]{26,0};
		snakes[1] = new int[]{20,8};
		snakes[2] = new int[]{16,3};
		snakes[3] = new int[]{18,6};
		SnakesNLadders snl = new SnakesNLadders(size,ladders,snakes);
		System.out.printf("Least number of dice roll : %d\n",snl.calculateLeastDieRoll());	
	}
}
