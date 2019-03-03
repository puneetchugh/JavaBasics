package com.puneet.chugh;
import java.util.Arrays;
public class ArraysClass{

	public static int[][] createTwoDArray(){
		
		int[][] twoDimArray = {
					{1,2,3,4},
					{9,8,7,6},
					{100,200,300},
				  };
		return twoDimArray;
	}

	public static void runLoopOn2DArray(int[][] twoDArray){

		System.out.println("Number of rows in 2-D array : "+twoDArray.length);
		for(int[] row : twoDArray){
			System.out.println("Size of row : "+row.length);
			for(int element : row){
				System.out.printf("Element : %d\n",element);
			}
		}
	}

	public static void createArray(){
		
		//This is not allowed..The second one is however allowed
		//int array[] = int[]{99,199,299};
		//for(int element : array){
		//	System.out.printf("Individiual element : %d\n", element);
		//}
		
		int array1[] = {22,33,44};
		for(int element : array1){
			System.out.printf("Individiual element : %d\n", element);
		}
	}

	public static void createCustomObjectArray(){

		CustomObject[][] array = new CustomObject[2][2];
		Arrays.fill(array[0], new CustomObject());//This puts the same reference of the newly created 
							  //CustomObject in all the objects in that array. So,
							  //making the change below would change all the objects 
							  //in that array object
		array[0][0].object1 = 10;
		array[0][0].object2 = "Puneet";

		for(CustomObject object : array[0]){
			System.out.println("Object1 : "+object.object1);
			System.out.println("Object1 : "+object.object2);
		}
	}	

	public static void main(String[] args){

		runLoopOn2DArray(createTwoDArray());
		createArray();
		createCustomObjectArray();
	}
}
