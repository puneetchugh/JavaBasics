package com.puneet.chugh;
import java.util.*;
import java.lang.Math;

public class AStar{

	boolean[][] path;
	Distance[][] dist;
	boolean[][] openList;
	boolean[][] closedList;
	int[][][] parent;
	int size;
	public AStar(int size){
		this.size = size;
		path = new boolean[size][size];
		dist = new Distance[size][size]; 
		for(int counterX=0; counterX<size; counterX++){
			for(int counterY=0; counterY<size; counterY++)
				dist[counterX][counterY] = new Distance(Double.MAX_VALUE, Double.MAX_VALUE);
		}
		openList = new boolean[size][size];
		closedList = new boolean[size][size];
		parent = new int[size][size][2];
	}
	
	class Distance{

		double g;
		double h;
		
		public Distance(double g, double h){
			this.g = g;
			this.h = h;
		}
		public double getG(){
			return g;
		}
		public double getH(){
			return h;
		}
	}
		
	public void findPath(int startX, int startY, int endX, int endY){
		
		dist[startX][startY] = new Distance(0.0, 0.0);
		openList[startX][startY] = true;
		int[] newNode = new int[]{startX, startY};	
		while(newNode[0]!=endX || newNode[1]!=endY){
			System.out.println("Parent : ["+newNode[0]+","+newNode[1]+"]");
			System.out.println("Printing path list : ");
for(int x=0; x<size; x++){
					for(int y=0; y<size; y++)
						System.out.println("["+x+","+y+"] : "+path[x][y]);
				}
			int initXCounter, initYCounter;
			int counterX = initXCounter = newNode[0]==0?0:newNode[0]-1;
			int counterY = initYCounter = newNode[1]==0?0:newNode[1]-1;
			for(; counterX<=newNode[0]+1 && counterX>=0 && counterX<size; counterX++){
				//System.out.println("Inspecting row : "+counterX);
				for(; counterY<=newNode[1]+1 && counterY>=0 && counterY<size; counterY++){
					System.out.println("Checking node : ["+counterX+","+counterY+"]");	
					//condition to stop
					if(counterX==newNode[0] && counterY==newNode[1]){
						System.out.println("continuing...");
						continue;
					}

					//
					if(!closedList[counterX][counterY] && path[counterX][counterY]){ 
						if(openList[counterX][counterY]){
							dist[counterX][counterY].g = dist[counterX][counterY].g
												+Math.sqrt(Math.pow((counterX-parent[counterX][counterY][0]),2)+
												Math.pow((counterY-parent[counterX][counterY][1]),2)); 
						}
						else{
							dist[counterX][counterY].g = Math.sqrt(Math.pow((counterX-newNode[0]),2)+Math.pow((counterY-newNode[1]),2)); 
						}
						
						dist[counterX][counterY].h = Math.sqrt(Math.pow((endX-counterX),2) + Math.pow((endY-counterY),2));
						parent[counterX][counterY][0] = newNode[0];
						parent[counterX][counterY][1] = newNode[1];
						openList[counterX][counterY]=true;
						System.out.println("Adding ["+counterX+","+counterY+"] to openList");
					}

						
				}
				counterY = initYCounter;
				/*
				for(int x=0; x<size; x++){
					for(int y=0; y<size; y++)
						System.out.println("["+x+","+y+"] : "+openList[x][y]+"\t"+closedList[x][y]);
				}	
				*/
			}
			closedList[newNode[0]][newNode[1]]=true;
			openList[newNode[0]][newNode[1]]=false;
			newNode = findNext();
			/*	
			for(int x=0; x<size; x++){
				for(int y=0; y<size; y++)
					System.out.println("["+x+","+y+"] : "+openList[x][y]+"\t"+closedList[x][y]);
			}*/			
		}
		closedList[newNode[0]][newNode[1]] = true;
		System.out.println("Path includes : ");
			for(int counterX=0; counterX<size; counterX++){
				for(int counterY=0; counterY<size; counterY++){
					if(closedList[counterX][counterY])
						System.out.println("["+counterX+","+counterY+"]");
				}
			}
	}

	public int[] findNext(){

		double min = Double.MAX_VALUE;
		int[] next = new int[2];
		for(int counterX=0; counterX<size; counterX++){
			for(int counterY=0; counterY<size; counterY++){

				if(openList[counterX][counterY] && path[counterX][counterY]){
					if((dist[counterX][counterY].g+dist[counterX][counterY].h) < min){
						min = dist[counterX][counterY].g+dist[counterX][counterY].h;
						next[0] = counterX;
						next[1] = counterY;
					}
				}
			}
		}

		return next;
	}
	
	public void print(){

		for(int x=0; x<size; x++){
			for(int y=0; y<size; y++){
				System.out.println("["+x+","+y+"] = "+dist[x][y].g);
			}
		}
	}

	public static void main(String[] args){

		AStar aStar = new AStar(4);
		Arrays.fill(aStar.path[0], true);
		Arrays.fill(aStar.path[1], true);
		Arrays.fill(aStar.path[2], true);
		Arrays.fill(aStar.path[3], true);
		//aStar.findPath(1,1,3,3);	
		aStar.path[1][1] = aStar.path[2][2] = false;	
		aStar.findPath(0,0,3,3);
		//aStar.findPath(1,2,3,3);	
		//aStar.print();
	}
}
