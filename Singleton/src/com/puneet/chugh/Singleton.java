package com.puneet.chugh;

public class Singleton{

	private static Singleton singleton;
	
	static{
		if(singleton==null){
			singleton = new Singleton();
		}
	}

	public static Singleton getInstance(){

		return singleton;
	}

	public static void main(String[] args){

		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton);
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton1);

		StaticInitialization instance = StaticInitialization.getInstance();
		StaticInitialization instance1 = StaticInitialization.getInstance();
		
		System.out.println("instance = "+instance+
				   "\ninstance1 = "+instance1);
		
		DoubleCheckSingleton doubleCheckInstance = DoubleCheckSingleton.getInstance();
		DoubleCheckSingleton doubleCheckInstance1 = DoubleCheckSingleton.getInstance();
		
		System.out.println("doubleCheckInstance = "+doubleCheckInstance+
				   "\ndoubleCheckInstance1 = "+doubleCheckInstance1);

		
		ThreadSafeSingleton threadSafeInstance = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton threadSafeInstance1 = ThreadSafeSingleton.getInstance();
		
		System.out.println("threadSafeInstance = "+threadSafeInstance+
				   "\nthreadSafeInstance1 = "+threadSafeInstance1);
		
		Eager eagerInstance = Eager.getInstance();
		Eager eagerInstance1 = Eager.getInstance();
		
		System.out.println("eagerInstance = "+eagerInstance+
				   "\neagerInstance1 = "+eagerInstance1);
		
		BillPughSingleton billPughInstance = BillPughSingleton.getInstance();
		BillPughSingleton billPughInstance1 = BillPughSingleton.getInstance();
		
		System.out.println("billPughInstance = "+billPughInstance+
				   "\nbillPughInstance1 = "+billPughInstance1);
	}
}
