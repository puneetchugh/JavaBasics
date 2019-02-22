package com.puneet.chugh;

public class MergeSort{

	private int[] array;
	private int[] new_array;
	public MergeSort(int[] array){
		this.array = array;
		new_array = new int[array.length];
	} 

	public void sort(int min, int max){
		
		if(min<max){
			int mid = (min+max)/2;
			
			sort(min, mid);
			sort(mid+1, max);
			merge(min, max);
		}
	}

	public void merge(int min, int max){
		
		System.out.println("Entering merge");
		int[] new_array=new int[max-min+1];
		int low = min;
		int mid = (min+max)/2;
		int high = mid+1;
		int counter = 0;
		while((low <= mid) && (high <= max) && (counter <= max-min)){
		
			//System.out.printf("Comparing index-%d val-%d and index-%d val-%d\n",low, array[low], high, array[high]);	
			if(array[low] < array[high]){
				new_array[counter++] = array[low++];	
			}
			else{
				new_array[counter++] = array[high++];
			}
		}

		while(low <= mid){
			//System.out.printf("1Putting %d at index %d\n", array[low], counter);
			new_array[counter++] = array[low++];
		}

		while(high <= max){
			//System.out.printf("2Putting %d at index %d\n", array[high], counter);
			new_array[counter++] = array[high++];
		}
		low = min;
		for(int num : new_array){
			array[low++]=num;	
		}
	}
	

	public void beforeSort(){
		
		System.out.println("Before sorting...");
		for(int num : array){
			System.out.printf("%d\t",num);
		}
		System.out.println("");
	}
	
	public void afterSort(){
		
		System.out.println("After sorting...");
		for(int num : array){
			System.out.printf("%d\t",num);
		}
		System.out.println("");
	}

	public static void main(String[] args){

		int[] array = new int[]{89, 57, 23, 99, 25, 12, 79, 40, 2};
		MergeSort mSort = new MergeSort(array);
		mSort.beforeSort();
		mSort.sort(0,array.length-1);
		mSort.afterSort();	
		
	}
}
