package com.puneet.chugh;

//max heap
public class HeapSort{


	int[] array;
	int size;

	public HeapSort(int[] array){
		this.array = array;
		this.size = array.length;
	}

	public void insert(){
		//System.out.println("Entered insert()");
		for(int counter=size/2-1; counter>=0; counter--){
			//System.out.printf("Number : %d\n",array[counter]);
			heapify(counter, array.length);
			//showArray();
		}
	}

	public void heapSort(){
		for(int counter=(array.length)-1; counter>0; counter--){
			int temp = array[counter];
			array[counter] = array[0];
			array[0] = temp;
			heapify(0, counter);
		}
	}

	public void heapify(int index, int size){

		//int index = size;
		if(size == 1 || index>size/2){
			return;	
		}
		int largest = index;
		int leftIndex = 2*index+1;
		int rightIndex = 2*index+2;

		if((leftIndex<size) && array[leftIndex]>array[largest])
			largest = leftIndex;
		
		if((rightIndex<size) && array[rightIndex]>array[largest])
			largest = rightIndex;
		
		if(largest!=index){
			//System.out.printf("Exchanging numbers %d and %d\n",array[largest], array[index]);
			int temp = array[largest];
			array[largest] = array[index];
			array[index] = temp;
			heapify(largest, size);
		}
		//showArray();	
	}

	public void showArray(){
		for(int num : array){
			System.out.printf("%d\t", num);
		}
		System.out.println("");
	}
	
	public static void main(String[] args){

		HeapSort sort = new HeapSort(new int[]{12,34,79,44,80,77,21,65});
		System.out.println("Before creating max heap...");
		sort.showArray();
		sort.insert();
		System.out.println("After creating max heap...");
		sort.showArray();
		System.out.println("Now applying heap sort..");
		sort.heapSort();
		System.out.println("After sorting...");
		sort.showArray();
	}
}
