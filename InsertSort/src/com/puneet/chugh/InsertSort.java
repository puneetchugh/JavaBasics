
package com.puneet.chugh;

public class InsertSort{

	private int[] array;

	public InsertSort(int[] array){
		
		this.array = array;
	}

	public void sort(){
		
		int size = array.length;
		for(int outerCounter=0; outerCounter<(size-1); outerCounter++){
			System.out.println("outerCounter value : "+outerCounter);
			for(int innerCounter=outerCounter+1; innerCounter<(size); innerCounter++){
				if(array[outerCounter] > array[innerCounter]){
					int temp = array[innerCounter];
					array[innerCounter] = array[outerCounter];
					array[outerCounter] = temp;
				}

			}
			System.out.printf("Array after %dth pass\n",outerCounter+1);
			for(int oneInt: array){
				System.out.printf("%d\t", oneInt);
			}
			System.out.println("");
		}
	}

	public int[] getArray(){
		return array;
	}


	public static void main(String[] args){

		InsertSort bubbleSort = new InsertSort(new int[]{19, 56, 23, 11, 87, 28});
		System.out.println("Unsorted array : ");
		for(int oneInt : bubbleSort.getArray()){
			System.out.printf("%d\t",oneInt);	
		}
		System.out.println("");
		bubbleSort.sort();
		System.out.println("");
		
		System.out.println("Sorted array : ");
		for(int oneInt : bubbleSort.getArray()){
			System.out.printf("%d\t",oneInt);	
		}

		System.out.println("");
	}
}
