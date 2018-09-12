package com.puneet.chugh;

public class Vehicle{

	//private variable
	public String vehicleMake;
	//default variable
	String vehicleModel;

	public Vehicle(String vehicleMake, String vehicleModel){
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleMake(){
		return vehicleMake;
	}

	public String getVehicleModel(){
		return vehicleModel;
	}

	public void printAverageSpeed(){
		System.out.println("Vehicle has average speed of 50mph");
	}

	protected void printMaxSpeed(){
		System.out.println("Vehicle has Max Speed of greater than 100mph");
	}
}
