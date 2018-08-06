package com.puneet.chugh;

public class StaticInitialization{

	private static StaticInitialization instance;

	static{
		instance = new StaticInitialization();
	}
	//Singleton pattern's constructor is always private. 
	//Singleton cannot have a public constructor to be initialized from outside.
	private StaticInitialization(){}
	
	public static StaticInitialization getInstance(){
		return instance;
	}
}
