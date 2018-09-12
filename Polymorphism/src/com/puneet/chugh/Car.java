package com.puneet.chugh;

public class Car extends Vehicle{

	private boolean isLuxury;
	public Car(String carMake, String carModel, boolean isLuxury){
		super(carMake, carModel);
		this.isLuxury = isLuxury;
	}

	public String getCarMake(){
		return getVehicleMake(); // calling without super
	}
	
	public String getCarModel(){
		return super.getVehicleModel(); //calling with super
	}

	public boolean checkIfLuxury(){
		return isLuxury;
	}
}
