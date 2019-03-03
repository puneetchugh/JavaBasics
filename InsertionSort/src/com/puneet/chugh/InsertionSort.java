package com.puneet.chugh;

public class InsertionSort{

	private int[] array;
	
	public InsertionSort(int[] array){
		this.array = array;
	}

	public void insertionSort(){

		for(int counter=1; counter<array.length; counter++){
			int temp = array[counter];
			int inCounter = counter-1;
			for(; inCounter>=0; inCounter--){
				if(array[inCounter]>temp){
					array[inCounter+1] = array[inCounter];
				}
				else
					break;
			}
			array[inCounter+1] = temp;
		}
	}

	public void printArray(){
		System.out.println("Array looks like : ");
		for(int num : array){
			System.out.printf("%d\t",num);
		}
		System.out.println("");
	}


	public static void main(String[] args){
		
		int[] array = new int[]{20,89,11,56,28,96,22,44,55};
		System.out.println("Before sorting...");
		InsertionSort insertSort = new InsertionSort(array);
		insertSort.printArray();
		insertSort.insertionSort();
		System.out.println("After sorting...");
		insertSort.printArray();
	}
	
}
