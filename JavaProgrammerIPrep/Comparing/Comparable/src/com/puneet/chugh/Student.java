package com.puneet.chugh;

public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private int age;

	public Student(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}

	
	@Override
	public boolean equals(Object obj){
		
		if(this == obj)
			return true;
		
		else if(obj == null || !(obj instanceof Student))
			return false;

		Student std = (Student) obj;
		return this.id == std.id &&
			this.name == std.name && 
			this.age == std.age;

	}

	@Override 
	public int hashCode(){
		return id;
	}
	
	@Override
	public int compareTo(Student student){
		return this.hashCode() - student.hashCode();
	}
}
