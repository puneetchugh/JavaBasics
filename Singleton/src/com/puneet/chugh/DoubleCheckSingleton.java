package com.puneet.chugh;

public class DoubleCheckSingleton{

	private static DoubleCheckSingleton instance;

	private DoubleCheckSingleton(){}

	public static DoubleCheckSingleton getInstance(){

		if(instance == null){
			synchronized(DoubleCheckSingleton.class){
				instance = new DoubleCheckSingleton();
			}
		}
		return instance;
	}
}
