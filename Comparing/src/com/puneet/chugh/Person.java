package com.puneet.chugh;

public class Person implements Comparable<Person>{

	private String name;
	private int age;
	

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	@Override
	public int compareTo(Person person){
		
		if(person == null || person.getName() == null || person.getName() == "")
			return 1;
		if(getName()!= null && getName() != ""){
			
			return getName().compareTo(person.getName());
		}
		else{
			return -1;
		}
	}

	@Override
	public boolean equals(Object object){

		if(this == object)
			return true;
		
		if(this == null || object == null || !(object instanceof Person))
			return false;
		
		else{
			return getName().equals(((Person)object).getName()) &&
				(getAge() == ((Person)object).getAge());
		}
		
	}

	@Override
	public int hashCode(){
		
		int result = 17;
		
		result = 31*result + name.hashCode();
		result = 31*result + age;
		return result;
	}
}
