package com.puneet.chugh;

public class MyObject{

	private int age;
	private String name;
	private String telNumber;
	public MyObject(int age, String name, String telNumber){
		this.age = age;
		this.name = name;
		this.telNumber = telNumber;
	}

	public int getAge(){
		return age;
	}

	public String getName(){
		return name;
	}
	
	public String getTelNumber(){
		return telNumber;
	}
}
