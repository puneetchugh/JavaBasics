package com.puneet.chugh;

import java.util.*;

//only for unique triplet{1, 2, 4, 5, 7, 8, 10}s
public class UsingSorting{

	private int[] array;
	public UsingSorting(int[] array){
		this.array = array;
	}

	public int findTriplets(int sum){

		Arrays.sort(array);
		int total = 0;
		for(int counter=1; counter<array.length-1; counter++){
			
			int left=0,
			    right=array.length-1;
			
			int leftPointer=counter-1,
			    rightPointer=counter+1;

			while(leftPointer>=0 && rightPointer<array.length){

				if((array[counter]+array[leftPointer]+array[rightPointer]) == sum){
					total++;
					System.out.printf("Triplet (%d,%d,%d)\n",array[leftPointer], array[counter], array[rightPointer]);
					break;
				}
				else if((array[counter]+array[leftPointer]+array[rightPointer]) < sum){
					rightPointer++;
				}
				else if((array[counter]+array[leftPointer]+array[rightPointer]) > sum)
					leftPointer--;
			}	
		}
		return total;
		
	}

	public static void main(String[] args){
	
		//UsingSorting usingSorting = new UsingSorting(new int[]{1, -2, 0, 5, -1, -4});
		//System.out.printf("Total triplets : %d\n", usingSorting.findTriplets(2));

		//new int[]{1, 2, 4, 5, 7, 8, 10}
		//UsingSorting usingSorting = new UsingSorting(new int[]{1, 2, 4, 5, 7, 8, 10});
		//System.out.printf("Total triplets : %d\n", usingSorting.findTriplets(15));

		//{-1 0 1 2 -1 -4}
		UsingSorting usingSorting = new UsingSorting(new int[]{-1, 0, 1, 2, -1, -4}); 
		System.out.printf("Total triplets : %d\n", usingSorting.findTriplets(0));


	}
}
