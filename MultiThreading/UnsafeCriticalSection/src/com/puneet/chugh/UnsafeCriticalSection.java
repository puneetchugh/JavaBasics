package com.puneet.chugh;
import java.lang.Runnable;
import java.lang.Thread;


//This example is not thread safe example. 
//add() is a critical section that has race condition
public class UnsafeCriticalSection{

	int counter=0;

	//
	public void add(int val){
		counter = counter + val;
	}

	public int getCounter(){
		return counter;
	}

	public static class MyRunnable implements Runnable{
		
		UnsafeCriticalSection critical;
		int val;
		public MyRunnable(UnsafeCriticalSection critical, int val){
			this.critical = critical;
			this.val = val;
		}
		@Override
		public void run(){
			critical.add(val);
		}
	}

	public static void main(String[] args){
		
		UnsafeCriticalSection critical = new UnsafeCriticalSection();
		//Using same critical object and using its add() method
		//from different thread results in different results
		new Thread(new MyRunnable(critical,10)).start();
		new Thread(new MyRunnable(critical,5)).start();
		new Thread(new MyRunnable(critical,10)).start();
	
		System.out.printf("Counter value  :  %d\n", critical.getCounter());	
		
	}
}
