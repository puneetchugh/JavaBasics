package com.puneet.chugh;
import java.lang.Runnable;
import java.lang.Thread;

//The concept of synchronizing the code on
//objects is always on some monitor object
//1. If 'synchronized' keyword is declared 
//in the method signature, then its sychronized 
//on the instance object
//2. If 'synchronized' keyword is used on a
//block of code like synchronized(this){},
//then, this is also sycrhronized on the instance 
//object.
//3. If a block is synchronized on any monitor
//object, then only one thread can execute inside 
//it at any point of time.
//4. If multiple blocks are synchronized on a monitor
//object, then also, only one thread can execute inside
//one of them at any point of time

public class MonitorObject{

	Integer monitorObj = new Integer(1);
	
	int counter = 0;
	
	/*
	public synchronized void add(int val){
		counter = counter + val;
	}*/
	
	//The previous method is same as the next 
	//add(), both of them are synchronized on the 
	//instance object
	
	/*
	public void add(int val){
		synchronized(this){
			counter = counter + val;
		}
	}*/
	
	//This add() is synchronized on monitorObj object as
	//monitorObj belongs to the instance, so, only one 
	//thread will be able to run inside add() at one point
	//of time.
	public void add(int val){
		synchronized(monitorObj){
			counter = counter + val;
		}
	}	

	public void printVal(){
		System.out.printf("The value is %d\n", counter);
	}
	
	public static class MyRunnable implements Runnable{
		
		int val = 0;
		MonitorObject obj;
		public MyRunnable(MonitorObject obj, int val){
			this.val = val;
			this.obj = obj;
		}
		
		@Override
		public void run(){
			obj.add(val);
		}
	}

	public static void main(String[] args){
		
		//The following example shows the same 
		//MonitorObject being used for both the threads
		//so only one will execute inside add() at once
		MonitorObject obj = new MonitorObject();
		Thread thread1 = new Thread(new MyRunnable(obj, 11));
		thread1.start();	
		try{
			thread1.join();
		}catch(InterruptedException ex){}
		
		Thread thread2 = new Thread(new MyRunnable(obj, 25));
		thread2.start();
		try{
			thread2.join();
		}catch(InterruptedException ex){}
		obj.printVal();

		//The follwing example uses different MonitorObject 
		//being used for the different threads. Hence, this
		//will not need thread synchronizing part as both of 
		//them can run on their monitor object
		MonitorObject obj1 = new MonitorObject();
		MonitorObject obj2 = new MonitorObject();	
		
		Thread thread11 = new Thread(new MyRunnable(obj1, 44));
		Thread thread22 = new Thread(new MyRunnable(obj2, 66));
		thread11.start();
		thread22.start();	
		try{
			thread11.join();
		}catch(InterruptedException ex){}
		
		try{
			thread22.join();
		}catch(InterruptedException ex){}
		obj1.printVal();
		obj2.printVal();

	
	}
}
