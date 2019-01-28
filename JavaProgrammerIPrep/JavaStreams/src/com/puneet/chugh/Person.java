package com.puneet.chugh;

public class Person{

	private int age;
	private String name;
	private String telNumber;
	public Person(int age, String name, String telNumber){
		this.age = age;
		this.name = name;
		this.telNumber = telNumber;
	}

	public int getAge(){
		return age;
	}
	
	public void incrementAge(int incrementVal){
		age+=10;
	}

	public String getName(){
		return name;
	}
	
	public String getTelNumber(){
		return telNumber;
	}
}
