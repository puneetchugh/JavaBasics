package com.puneet.chugh;

public class SelectionSort{


	private int[] array;
	private int arraySize;
	public SelectionSort(int[] array){
		this.array = array;
		arraySize = array.length;
	}

	public void sort(){
		
		for(int outerCounter=0; outerCounter<arraySize-1; outerCounter++){
			int indexForExchange = outerCounter;
			boolean needForExchange = false;
			for(int innerCounter=outerCounter+1; innerCounter<arraySize; innerCounter++){
				if(array[innerCounter] < array[indexForExchange] ){
					indexForExchange = innerCounter;
					needForExchange = true;
					
				}
			}
			if(needForExchange){
				
				int temp = array[outerCounter];
				array[outerCounter] = array[indexForExchange];
				array[indexForExchange] = temp;
			}
			System.out.printf("\nAfter completing %dth pass...\n",outerCounter);
			for(int oneInt : array){
				System.out.printf("%d\t", oneInt);
			}
		}
	}

	public int[] getArray(){
		return array;
	}

	public static void main(String[] args){

		SelectionSort selectionSort = new SelectionSort(new int[]{19,23,11,9,99,87});
		System.out.println("Printing unsorted array...");
		for(int oneInt: selectionSort.getArray()){
			System.out.printf("%d\t",oneInt);
		}
		selectionSort.sort();
		System.out.println("\nPrinting sorted array...");
		
		for(int oneInt: selectionSort.getArray()){
			System.out.printf("%d\t",oneInt);
		}
		System.out.println("");
		
	}
}
