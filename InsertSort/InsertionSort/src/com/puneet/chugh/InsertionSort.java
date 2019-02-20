package com.puneet.chugh;


public class InsertionSort{
	
	public int[] array;

	public InsertionSort(int[] array){
		this.array = array;
	}	

	public void insertSort(){
		
		int size = array.length;
		for(int counter=1; counter<size; counter++){

			System.out.println("One pass");
			int temp = array[counter];
			int inCounter = counter-1; 
			for(; inCounter>=0; inCounter--){
				System.out.printf("Comparing %d and %d\n", array[counter], array[inCounter]);
				//int temp = array[counter];
				if(array[inCounter]>temp){// || inCounter==0){
					array[inCounter+1] = array[inCounter];
					//moveNumbers(replaceIndex+1,counter);
					//break;
				}
				else
					break;
				/*	
				else{
					if(inCounter==0){
							moveNumbers(0,counter);
					}

				}*/
			}
			array[inCounter+1] = temp;
 
			for(int num:array){
					System.out.printf("%d\t",num);
			}
			System.out.println("");

		}
	}
	/*
	public void moveNumbers(int replace1, int replace2){
		int temp = array[replace2];
		for(int counter=replace2; counter>replace1; counter--){
			array[counter] = array[counter-1];
		}
		array[replace1] = temp;
	}
	*/
	public static void main(String[] args){
		
		int[] array = new int[]{90,58,68,2,89,23,78,34};
		System.out.println("Numbers before sorting...");
		for(int num:array){
			System.out.printf("%d\t",num);
		}
		System.out.println("");
		InsertionSort inSort = new InsertionSort(array);
		inSort.insertSort();
		for(int num:array){
			System.out.printf("%d\t",num);
		}
		System.out.println("");
	}
}
