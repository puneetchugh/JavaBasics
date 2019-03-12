package com.puneet.chugh;
import java.lang.Runnable;
import java.lang.Thread;

//Busy waiting as we have seen previously
//does nothing but keeps the cpu busy, that's
//not an approach that is recommended
//So, we make use of wait() and notify()
//calls for signalling which is a reactive
//approach of programming.

//If the program calls wait(), then it would
//wait until notify() is called to wake it up
//After calling wait(), the program relinquishes 
//the monitor lock and cpu.

//wait() and notify() are always required to be
//called from inside synchronized block, otherwise
//IllegalStateMonitorException would be thrown
public class NoBusyWaiting{
	//signal is the monitor object
	Integer signal = new Integer(1);

	public void doWait(){
		synchronized(signal){
			try{
				signal.wait();
			}catch(InterruptedException ex){
				System.out.printf("InterruptedException caught %s\n",ex.getMessage());
			}
		}
	}

	public void doNotify(){
		
		synchronized(signal){
			signal.notify();
		}
	}
}
