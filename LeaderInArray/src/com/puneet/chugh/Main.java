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

	public static void main(String[] args){

		System.out.printf("The leaders are :");
		for(int oneInt : leaders(new int[]{16, 17, 4, 3, 5, 2})){
			System.out.printf("%d\t", oneInt);
		}
	}
}
