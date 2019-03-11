package com.puneet.chugh;
import java.lang.Runnable;
import java.lang.Thread;

public class SafeCriticalSection{

	int counter1 = 0;
	int counter2 = 0;
	Integer counterLock1  = new Integer(1);
	Integer counterLock2  = new Integer(2);

	//1. One way is to lock the entire critical block
	/*
	public void add(int val1, int val2){
		synchronized(this){
			counter1 = counter1 + val1;
			counter2 = counter2 + val2;
		}
	}*/
	
	//2. Another way is to lock parts of the critical section
	//It has a better throughput
	public void add(int val1, int val2){
		synchronized(counterLock1){
			counter1 = counter1 + val1;
		}
		synchronized(counterLock2){
			counter2 = counter2 + val2;
		}
	}

	public void printResult(){
		System.out.printf(String.format("counter1 = %d and counter2 = %d\n",counter1, counter2));
	}	

	public static class MyRunnable implements Runnable{
		
		SafeCriticalSection critical;
		int val1 = 0;
		int val2 = 0;
		public MyRunnable(SafeCriticalSection critical, int val1, int val2){
			this.critical = critical;
			this.val1 = val1;
			this.val2 = val2;
		}
		
		@Override
		public void run(){
			critical.add(val1, val2);
		} 
	}
	
	public static void main(String[] args){
		
		SafeCriticalSection critical = new SafeCriticalSection();
		critical.printResult();
		Thread thread1 = new Thread(new MyRunnable(critical, 10, 15));
		thread1.start();
		try{
			thread1.join();
		}catch(InterruptedException excep){}
		critical.printResult();
		Thread thread2 = new Thread(new MyRunnable(critical, 10, 15));
		thread2.start();
		try{
			thread2.join();
		}catch(InterruptedException excep){}
		critical.printResult();
	}
}
