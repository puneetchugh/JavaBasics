package com.puneet.chugh;

public class BubbleSort{

	private int[] array;

	public BubbleSort(int[] array){
		
		this.array = array;
	}

	public void sort(){
		
		int size = array.length;
		for(int outerCounter=0; outerCounter<(size-1); outerCounter++){
			System.out.println("outerCounter value : "+outerCounter);
			for(int innerCounter=0; innerCounter<(size-outerCounter-1); innerCounter++){
				if(array[innerCounter] > array[innerCounter+1]){
					int temp = array[innerCounter];
					array[innerCounter] = array[innerCounter+1];
					array[innerCounter+1] = temp;
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

		BubbleSort bubbleSort = new BubbleSort(new int[]{19, 56, 23, 11, 87, 28});
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
