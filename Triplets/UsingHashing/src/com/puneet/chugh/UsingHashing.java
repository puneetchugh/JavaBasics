package com.puneet.chugh;
import java.util.*;

public class UsingHashing{

	private int[] array;
	public UsingHashing(int[] array){
		this.array = array;
	}
		
	public int findTriplets(int sum){
		
		int total = 0;
		
		for(int counter=0; counter<array.length-2; counter++){
			System.out.printf("Outer loop is %d\n",array[counter]);
			int diff = sum - array[counter];
			HashMap<Integer,Integer> map = new HashMap<>();
			for(int i=counter+1; i<array.length; i++){
				if(map.containsKey(array[i]))
					map.put(array[i], map.get(array[i])+1);
				else
					map.put(array[i], 1);

			}
			
			for(int inCounter=counter+1; inCounter<array.length-1; inCounter++){
				int diff2 = diff - array[inCounter];
				System.out.printf("Inner Loop is %d\n", array[inCounter]);	
				//remove the current element from the map
				if(map.containsKey(array[inCounter]) && map.get(array[inCounter])==1){
					map.remove(array[inCounter]);
				}
				else{
					map.put(array[inCounter], map.get(array[inCounter])-1);
				}
				
				if(map.containsKey(diff2)){
					System.out.printf("Triplet found : (%d,%d,%d)\n",array[counter], array[inCounter], diff2);
					if(map.get(diff2) == 1)
						total++;
					else{
						total = total + map.get(diff2);
						System.out.printf("Total count increasing by : %d\n",map.get(diff2));
					}
				}
				
			}
		}
		return total;		

	}

	public static void main(String[] args){	
		
		//UsingHashing usingHashing = new UsingHashing(new int[]{2,6,5,9,3,1,2,8,2,1,4}); 
		//System.out.printf("Total triplets : %d\n", usingHashing.findTriplets(8));
	
		//{-2, 0, 1, 1, 2}		
		//UsingHashing usingHashing = new UsingHashing(new int[]{-2, 0, 1, 1, 2}); 
		//System.out.printf("Total triplets : %d\n", usingHashing.findTriplets(0));
		
		//1 2 4 5 7 8 10
		//UsingHashing usingHashing = new UsingHashing(new int[]{1 2 4 5 7 8 10}); 
		//System.out.printf("Total triplets : %d\n", usingHashing.findTriplets(15));
		
		//{1, -2, 0, 5, -1, -4}
		//UsingHashing usingHashing = new UsingHashing(new int[]{1, -2, 0, 5, -1, -4}); 
		//System.out.printf("Total triplets : %d\n", usingHashing.findTriplets(2));

		//{-1 0 1 2 -1 -4}
		UsingHashing usingHashing = new UsingHashing(new int[]{-1, 0, 1, 2, -1, -4}); 
		System.out.printf("Total triplets : %d\n", usingHashing.findTriplets(0));
	

		//UsingHashing usingHashing = new UsingHashing(new int[]{12, 3, 6, 1, 6, 9}); 
		//System.out.printf("Total triplets : %d\n", usingHashing.findTriplets(24));

	}
}
