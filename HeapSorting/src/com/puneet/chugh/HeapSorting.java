package com.puneet.chugh;

public class HeapSorting{

	private int[] array;

	public HeapSorting(int[] array){
		this.array = array;
	}

	public void createHeap(){
		int counter = 0;
		for(int num : array){
			heapify(counter++);
		}
	}	

	public void heapify(int index){
		
		//System.out.printf("Heapify called with index %d\n", index);	
		if(index >= ((array.length-1)/2)){
			return;
		}
		int largest = index;
		int leftIndex = (2*index)+1;
		int rightIndex = (2*index)+2;

		if((leftIndex < array.length) && (array[leftIndex] > array[largest]))
			largest = leftIndex;

		if((rightIndex < array.length) && (array[rightIndex] > array[largest]))
			largest = rightIndex;

		if(index != largest){
			System.out.printf("Swapping %d and %d\n", array[index], array[largest]);
			swap(index, largest);
		}
	}
	
	public void swap(int index1, int index2){
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public void printHeap(){
		System.out.println("Heap looks like : ");
		for(int num : array){
			System.out.printf("%d\t",num);
		}
	}

	public static void main(String[] args){
		int[] array = {90,99,45,23,95,88,65,20};
		HeapSorting heapSort = new HeapSorting(array);
		System.out.println("Before creating heap...");
		heapSort.printHeap();
		heapSort.createHeap();
		System.out.println("After creating heap...");
		heapSort.printHeap();
	}
}
