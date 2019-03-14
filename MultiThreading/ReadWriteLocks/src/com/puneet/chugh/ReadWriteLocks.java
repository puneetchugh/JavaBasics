package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;

public class ReadWriteLocks{

	private int readers = 0,
		int writers = 0,
		int writeRequests = 0;

	public synchronized void lockRead() throws InterruptedException{
		
		while((writers > 0) && (writeRequests > 0))
			wait();
		readers++;
	}

	public synchronized void lockWrite() throws InterruptedException{
		
		lockRequested++;
		
		while((readers > 0) && (writers > 0)){
			wait();
		}
		lockRequests--;
		writers++;
	}

	public synchronized void unlockRead() throws InterruptedException{
		
		readers--;
		notifyAll();
	}

	public synchronized void unlockWrite() throws InterruptedException{

		writers--;
		notifyAll();
	}
}
