package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;

public class Main{

	public static void main(String[] args) throws Exception{
		try{
			okScenario();
			notOkScenario();	
		}catch(InterruptedException ex){
			System.out.printf("Caught an Interrupted Exception %s\n",ex);
		}
			
	}

	//when lock is called only once.
	public static void okScenario() throws InterruptedException{
		Locks lock = new Locks();
		lock.lock();
		//do work
		//try{
			System.out.println("Doing work");
		//}finally{
			lock.unlock();
		//}
	}

	//when lock() is called inside lock()
	//then it gets stuck. Lock re-entrance
	//is not supported in this implementation
	public static void notOkScenario() throws InterruptedException{
		
		Locks lock = new Locks();
		lock.lock();
		//do work
		System.out.println("Inside notOkScenario()...Doing work..first level lock...");
		innerMethod(lock);
		lock.unlock();
	}

	public static void innerMethod(Locks lock) throws InterruptedException{
		lock.lock();
		//do work
		System.out.println("Doing work..inside double lock");
		lock.unlock();
	}
}
