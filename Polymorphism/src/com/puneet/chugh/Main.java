package com.puneet.chugh;

public class Main{

	public static void main(String[] args){

		System.out.println("Class Hierarchy : Vehicle->Car->Mercedes");
		Mercedes myMerc = new Mercedes("Benz", "E");
		myMerc.printAllInfo();
		myMerc.printMaxSpeed();

		//Upcasting - doesn't require explicit Classname to be used for casting
		Vehicle vehicle = myMerc;
		//Runtime Polymorphism : Method overriding
		vehicle.printMaxSpeed();

		//Downcast not allowed
		//Mercedes myMerc_DOWNCAST = new Vehicle("Mercedes", "Benz");
		
		//But downcast allowed using the following
		Mercedes myMerc_DOWNCAST_ALLOWED = (Mercedes) vehicle;
		myMerc_DOWNCAST_ALLOWED.printMaxSpeed();
	}
}
