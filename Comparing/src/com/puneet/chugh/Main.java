package com.puneet.chugh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List; 
import java.util.Collections;

public class Main{

	public static void main(String[] args){

		List<Person> personList = new ArrayList<>();

		personList.add(new Person("Puneet", 27));
		personList.add(new Person("John", 30));
		personList.add(new Person("Megan", 25));
		personList.add(new Person("Savana", 26));
		
		System.out.println("List before sort");
		for(Person person : personList){
			System.out.println("Name : "+person.getName()+"\tAge : "+person.getAge());
		}
		Collections.sort(personList);
		System.out.println("List after sorting according to Comparable ie according to name...");
			
		System.out.println("List before sort");
		for(Person person : personList){
			System.out.println("Name : "+person.getName()+"\tAge : "+person.getAge());
		}
		System.out.println("List after sorting according to AgeComparator ie according to age...");
		Collections.sort(personList, new AgeComparator());
		System.out.println("List before sort");
		for(Person person : personList){
			System.out.println("Name : "+person.getName()+"\tAge : "+person.getAge());
		}
	}
}
