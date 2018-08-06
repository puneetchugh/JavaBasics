package com.puneet.chugh;
/* 
1. Abstract classes need to have abstract keyword
2. Abstract classes need not have any abstract method
3. Abstract classes cannot be instantiated
4. However, abstract classes can have constructors
5. super call to the constructor should be the first in the subclass constructor
6. The extending class if not declared abstract need to define all the superclass abstract methods
7. An abstract class can extend another abstract class
8. You cannot use 2 super(2) like super.super 
*/

public abstract class Animal{

	public int legsCount;
	public Animal(int legsCount){
		this.legsCount = legsCount;
	}
	
	public abstract void makeSound();
	protected abstract void printAnimal();
	
	protected void printLegsCount(){
		System.out.println("Inside Animal class -> Legs count = "+legsCount);
	}
	

}
