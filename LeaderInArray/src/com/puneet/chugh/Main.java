package com.puneet.chugh;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.stream.*;

public class Main{

	public static List<Integer> leaders(int[] array){
		
		List<Integer> list = new LinkedList<>();
		for(int counter=0; counter<array.length-1; counter++){
			if(array[counter] >= IntStream.range(counter, array.length).reduce(array[counter+1], (a,b) -> Integer.max(a,b)))
				list.add(array[counter]);
		}
		if(array.length > 0)
			list.add(array[array.length-1]);	
		return list;
	}

	//another way
	public static List<Integer> leaders1(int[] array){

		List<Integer> list = new LinkedList();
		list.add(array[array.length-1]);
		int max = array[array.length-1];
		for(int counter=array.length-2; counter>=0; counter--){
			if(max < array[counter]){
				max = array[counter];
				list.add(array[counter]);
			}
		}
		return list;
	}

	public static void main(String[] args){

		System.out.printf("The leaders are : ");
		for(int oneInt : leaders(new int[]{16, 17, 4, 3, 5, 2})){
			System.out.printf("%d\t", oneInt);
		}
		
		System.out.println("");
		System.out.printf("The leaders are : ");
		for(int oneInt : leaders1(new int[]{16, 17, 4, 3, 5, 2})){
			System.out.printf("%d\t", oneInt);
		}
	}
}
