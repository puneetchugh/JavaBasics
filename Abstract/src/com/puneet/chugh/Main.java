package com.puneet.chugh;

public class Main{

	public static void main(String[] args){
		
		Cat cat = new Cat(4);
		cat.makeSound();
		cat.printLegsCount();
		cat.printAnimal();
		
		Animal animal;
		BabyCat babyCat = new BabyCat(8);
		animal = babyCat;
		animal.printLegsCount();
		((Cat)animal).printLegsCount();	

		animal = cat;
		animal.printLegsCount();
		((Animal)animal).printLegsCount();
		
		cat = babyCat;
		
		BabyCat babyCat1 = (BabyCat)cat;
		((Cat)babyCat1).printAnimal();
	}
}
