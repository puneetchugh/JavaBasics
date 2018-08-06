//BillPughSingleton pattern uses an inner private static class to create and initialized the Singleton object

package com.puneet.chugh;

public class BillPughSingleton{

	private BillPughSingleton(){}

	private static class CreateSingleton{

		private static final BillPughSingleton INSTANCE = new BillPughSingleton();

	}
	public static BillPughSingleton getInstance(){
		return CreateSingleton.INSTANCE;
	}
}
