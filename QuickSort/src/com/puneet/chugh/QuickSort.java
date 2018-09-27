package com.puneet.chugh;

public class QuickSort{


	private int[] array;
	
	QuickSort(int[] array){
		this.array = array;
	}

	public void sort(int low, int high){
		
		if(low < high){
			int pivot = array[(low+high)/2];
			int index = partition(low, high, pivot);
			
			sort(low, index-1);
			sort(index, high);
		}
	}

	public int partition(int low, int high, int pivot){
		
		while(low <= high){

			while(array[low] < pivot)
				low++;

			while(array[high] > pivot)
				high--;
		
			if(low<=high ){
				System.out.println("Exchanging "+array[low]+" with "+array[high]);
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				low++;
				high--; 
			}
		}
		System.out.println("After one pass...");
		System.out.println("Pivot = "+pivot);
		for(int oneInt : array){
			
			System.out.printf("%d  ", oneInt);
		}
		System.out.println("");
		return low;
	}
	public int[] returnArray(){
		return array;
	}

	public static void main(String[] args){

		int[] arrayToSort = new int[]{80, 8, 39, 10, 99, 23, 45, 54, 21, 11};
		for(int oneInt : arrayToSort){
			System.out.printf("%d  ", oneInt);
		}
		System.out.println(" ");
		QuickSort quickSort = new QuickSort(arrayToSort);
		quickSort.sort(0, 9);
		for(int oneInt : quickSort.returnArray()){
			System.out.printf("%d  ", oneInt);	
		}
		System.out.println(" ");
	}
}
