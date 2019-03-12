package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;

//Signalling is used between various threads 
//to sharedSignal from one thread to another when 
//the other thread can start/stop or other
//reasons
//Busy waiting keeps the program busy waiting
//in a loop

public class BusyWaiting{

	//sharedSignal element
	boolean sharedSignal = false;

	public synchronized void setSignal(){
		sharedSignal = true;
	}
		
	public synchronized boolean getSignal(){
		return sharedSignal;
	}
	
}
