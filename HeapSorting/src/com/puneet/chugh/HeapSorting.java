package com.puneet.chugh;

public class HeapSorting{

	private int[] array;

	public HeapSorting(int[] array){
		this.array = array;
	}

	public void createHeap(){
		int counter = 0;
		for(int num : array){
			heapify(counter++, array.length-1);
		}
	}	

	public void heapify(int index, int size){
		
		//System.out.printf("Heapify called with index %d\n", index);	
		if(index >= (size/2)){
			return;
		}
		int largest = index;
		int leftIndex = (2*index)+1;
		int rightIndex = (2*index)+2;

		if((leftIndex < size) && (array[leftIndex] > array[largest]))
			largest = leftIndex;

		if((rightIndex < size) && (array[rightIndex] > array[largest]))
			largest = rightIndex;

		if(index != largest){
			System.out.printf("Swapping %d and %d\n", array[index], array[largest]);
			swap(index, largest);
		}
	}
	
	public void sort(){
		
		for(int counter=array.length-1; counter > 0; counter--){
			swap(0, counter);
			heapify(0, counter);
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
		System.out.println("");
	}

	public static void main(String[] args){
		int[] array = {90,99,45,23,95,88,65,20};
		HeapSorting heapSort = new HeapSorting(array);
		System.out.println("Before creating heap...");
		heapSort.printHeap();
		heapSort.createHeap();
		System.out.println("After creating heap...");
		heapSort.printHeap();
		heapSort.sort();
		System.out.println("After heap sort...");
		heapSort.printHeap();
	}
}
