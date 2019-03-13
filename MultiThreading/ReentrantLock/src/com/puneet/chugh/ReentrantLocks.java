package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;


//ReentrantLocks would allow 
//the same thread to re-enter the 
//lock
public class ReentrantLocks{
	
	boolean isLocked;
	int counter = 0;
	Thread lockedBy;
	
	public void lock() throws InterruptedException{
		Thread currentThread = Thread.currentThread();
		while(isLocked && lockedBy!=currentThread){
			wait();
			
		}
		System.out.println("Grabbing lock...");
		isLocked = true;
		counter++;
		lockedBy = currentThread;
		
	}

	public void unlock() throws InterruptedException{
		if(isLocked && lockedBy==Thread.currentThread())
		{
			System.out.println("Decrementing lock counter");
			counter--;
			if(counter == 0){
				isLocked = false;
				lockedBy = null;
				notify();
			}
		}
	}
}
