package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;
import java.lang.IllegalMonitorStateException;
//Locks already have implementation in the Java
//Lock has 2 methods lock() and unlock()

public class Locks{

	boolean isLocked;
	Integer monitorObj = new Integer(1);
	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
		}
		isLocked = true;
	}

	public synchronized void unlock() throws InterruptedException{
		try{
			notify();
		}catch(IllegalMonitorStateException ex){
			System.out.printf("IllegalStateMonitorException encountered : %s\n",ex.getMessage());
		}
		isLocked = false;
	}
}
