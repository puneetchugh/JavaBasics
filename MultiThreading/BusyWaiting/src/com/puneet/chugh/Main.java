package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;

public class Main{

	public static void workToBeDone(BusyWaiting busyWaiting){
		while(!busyWaiting.getSignal()){
			//do nothing...just the program busy in 
			//this loop until shared signal becomes
			//true
			System.out.println("Still in busy waiting loop...");
		}
		//work to be done..
		System.out.println("Doing my work now");
	}

	public static class MyRunnable implements Runnable{
		
		BusyWaiting busy;
		public MyRunnable(BusyWaiting busy){
			this.busy = busy;
		}
		
		@Override
		public void run(){
			workToBeDone(busy);
		}
	}

	public static void main(String[] args){
		BusyWaiting busyWaiting = new BusyWaiting();
		
		for(int counter=0; counter<10; counter++){
			Thread thread = new Thread(new MyRunnable(busyWaiting));
			thread.start();
		}
		
		Thread.yield();
		busyWaiting.setSignal();	
		Thread thread1 = new Thread(new MyRunnable(busyWaiting));		
		thread1.start();
	}
}
