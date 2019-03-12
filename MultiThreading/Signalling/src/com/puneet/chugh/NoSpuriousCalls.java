package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;

public class NoSpuriousCalls{

	boolean wasSignalled = false;
	Integer signal = new Integer(1);

	//The below doWait() is useful for 
	//missed signals. wasSignalled will
	//prevent that from happening. 
	/*
	public void doWait(){
		synchronized(signal){
			try{
				if(!wasSignalled)
					signal.wait();
			}catch(InterrruptedException ex){
				System.out.printf("InterruptedException encountered %s\n",ex.getMessage());
			}
		}
	}*/

	//The below doWait() is useful for 
	//guarding against the spurious calls
	//If a spurious call woke up the doWait(),
	//then the while loop would run once and 
	//then call wait() on the signal	
	public void doWait(){
		synchronized(signal){
			try{
				while(!wasSignalled)
					signal.wait();
					
			}catch(InterruptedException ex){
				System.out.printf("InterruptedException encountered %s\n",ex.getMessage());
			}
			System.out.println("crossed wait()...doing work");
			//do work here
			wasSignalled = false;
		}
	}

	public void doNotify(){
		synchronized(signal){
			wasSignalled = true;
			signal.notify();
			System.out.println("Just notified...");
		}
	}

}
