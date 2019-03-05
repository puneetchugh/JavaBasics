package com.puneet.chugh;


public class QuickSort{

	private int[] array;
	
	public QuickSort(int[] array){
		this.array = array;
	}

	private void quickSort(int low, int high){
		System.out.println("quickSort() called...");	
		if(low < high){
			//int partition = regularPartition(low, high);
			//quickSort(low,partition-1);
			//quickSort(parition,high);

			int partition = lomutoPartition(low, high);
			quickSort(low,partition-1);
			quickSort(partition,high);

			//int partition = hoarsePartition(low,high);
			//quickSort(low,partition);
			//quickSort(partition+1,high);
		}
	}

	private int regularPartition(int low, int high){
		
		int lowPointer = low;
		int highPointer = high;
		int pivot = array[(low+high)/2];
		while(lowPointer<=highPointer){
			System.out.printf("Value of lowpointer : %d, highpointer : %d\n",lowPointer,highPointer);
			System.out.println("Inside while loop...");	
			while(array[lowPointer] < pivot)
				lowPointer++;
			while(array[highPointer] > pivot)
				highPointer--;

			if(lowPointer <= highPointer){
				System.out.printf("Swapping %d and %d\n", array[lowPointer], array[highPointer]);
				swap(lowPointer, highPointer);
				lowPointer++;
				highPointer--;
			}
			printArray();
		}
		return lowPointer;
	}
		
	private int hoarsePartition(int low, int high){
		
		int pivot = array[low];
		int lowPointer = low-1;
		int highPointer = high+1;
		
		while(true){
		
			do{
				lowPointer++;
			}while(array[lowPointer] < pivot);

			do{
				highPointer--;
			}while(array[highPointer] > pivot);

			if(lowPointer >= highPointer){
				return highPointer;
			}
			swap(lowPointer, highPointer);
		}
	}

	private int lomutoPartition(int low, int high){
		
		int pivot = array[high];
		int i = (low-1);

		for(int j=low; j<=high-1; j++){
			if(array[j] <= pivot){
				i++;
				swap(i,j);
			}
		}
		swap(i+1,high);
		return (i+1);
	}

	private void swap(int index1, int index2){
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private void printArray(){
		System.out.println("Printing array...");
		for(int num : array){
			System.out.printf("%d\t", num);
		}
		System.out.println("");
	}	

	public static void main(String[] args){
		
		int[] array = {90,89,99,21,56,95,3,55,2,1};
		QuickSort quickSort = new QuickSort(array);
		System.out.println("Before sorting...");
		quickSort.printArray();
		quickSort.quickSort(0,9);
		System.out.println("After sorting...");
		quickSort.printArray();

		array = new int[]{90,89,99,21,56,95,3,55,2,1};
		quickSort = new QuickSort(array);
		System.out.println("Before sorting...");
		quickSort.printArray();
		quickSort.quickSort(0,9);
		System.out.println("After sorting...");
		quickSort.printArray();

	}
}
