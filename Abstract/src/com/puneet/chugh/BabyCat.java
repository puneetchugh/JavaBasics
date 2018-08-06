package com.puneet.chugh;

class BabyCat extends Cat{

	public BabyCat(int legs){
		super(legs);
	}

	public void printAnimal(){
		System.out.println("I am a : "+this.getClass().getName());
	}

}
