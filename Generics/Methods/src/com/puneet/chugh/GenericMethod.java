package com.puneet.chugh;
import java.util.*;

public class GenericMethod{

	public static <T> List<T> addIntToMyList(T[] receivedArray){
		
		int counter = 0;
		List<T> list = new ArrayList<>();
		for(T oneInt : receivedArray){
			list.add(counter++, oneInt);
		}
		return list;
	}

	public static <K,V> void addtoMyMap(Map<K,V> myMap, K key, V value){
		
		myMap.put(key, value);
	}
	
	public static void main(String[] args){

		Integer[] intArray = new Integer[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
		String[] stringArray = new String[]{"Puneet", "Pankaj", "Patrick", "Peter", "Raven", "Camilo", "Chris", "David", "Liz"};
		List<Integer> list = addIntToMyList(intArray);
		List<String> intList = addIntToMyList(stringArray);
		
		Iterator<Integer> listIterator = list.iterator();
		Iterator<String> iterator = intList.iterator();

		while(listIterator.hasNext()){
			System.out.println("List Item : "+listIterator.next());
		}
	
		while(iterator.hasNext()){
			System.out.println("List Item : "+iterator.next());
		}

		//method with 2 Generic parameters
		Map<Integer,String> myMap = new HashMap<>();
		
		for(int counter=0; counter<intArray.length; counter++){

			addtoMyMap(myMap, intArray[counter], stringArray[counter]);
			
		}

		for(int key : myMap.keySet()){
			
			System.out.println("Key : "+key+"\t"+myMap.get(key));
		}
	}
}
