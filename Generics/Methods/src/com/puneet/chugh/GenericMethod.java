package com.puneet.chugh;
import java.util.*;
import java.lang.Number;

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
	
	//Generic with upper bound
	public static <T extends Number> T returnOneNumber(T[] array){
		
		Random random = new Random();
		return array[random.nextInt(array.length)];
		
	}
	//Generic unbounded
	public static void displayList(List<?> list){
		for(Object obj : list){
			System.out.println("Object : "+obj);
		}
	}
	//Generic lower bound
	public static void addIntegersToList(List<? super Integer> list){
		list.add(new Integer(111));
	}
	
	public static void main(String[] args){

		Integer[] intArray = new Integer[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
		System.out.println("Randomly selected number from int array is : "+returnOneNumber(intArray));
		String[] stringArray = new String[]{"Puneet", "Pankaj", "Patrick", "Peter", "Raven", "Camilo", "Chris", "David", "Liz"};
		List<Integer> list = addIntToMyList(intArray);
		addIntegersToList(list);
		
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

		Double[] doubleArray = new Double[]{11.11, 22.22, 33.33, 44.44, 55.55, 66.66};
		System.out.println("Randomly chosen number from the double array is : "+returnOneNumber(doubleArray));


		//Displaying Integers using generic class
		displayList(list);
		//Displaying Strings using generic class
		displayList(intList);

		
	}
}
