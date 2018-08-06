package com.puneet.chugh;

public class Cat extends Animal {
	
	public Cat(int legsCount){
		super(legsCount);
	}

	public void makeSound(){
		System.out.printf("I am a Cat...meoww...\n");
	}

	protected void printAnimal(){
		System.out.println("I am a : "+this.getClass().getName());
	}

	protected void printLegsCount(){
		//super.printLegsCount();
		System.out.println("Inside Cat class -> Legs count = "+super.legsCount);
	}
}
