package com.puneet.chugh;

public class Mercedes extends Car{

	private String carClass;

	public Mercedes(String mercedesModel, String mercedesClass){
		super("Mercedes", mercedesModel, true);
		this.carClass = carClass;
	}

	public String getCarClass(){
		return carClass;
	}
	
	public void printAllInfo(){
		System.out.println("carClass() from Mercedes.java : "+getCarClass()+
				   "\ngetVehicleMake() from Vehicle.java : "+getVehicleMake()+
				   "\ngetVehicleModel() from Vehicle.java : "+getVehicleModel()+
				   "\ngetCarMake() from Car.java : "+getCarMake()+
				   "\ngetCarModel() from Car.java : "+getCarModel()+
				   "\ncheckIfLuxury() from Car.java : "+checkIfLuxury());

		System.out.println("Printing a variable with 'default' access type from super super class : vehicleModel : "+vehicleModel);
		System.out.println("Printing a variable with public access type from super super class : vehicleMake : "+vehicleMake);
	}

	protected void printMaxSpeed(){
		System.out.println("Mercedes maximum speed : 199mph");
	}
}
