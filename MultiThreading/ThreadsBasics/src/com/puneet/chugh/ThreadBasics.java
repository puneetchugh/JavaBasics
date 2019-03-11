package com.puneet.chugh;
import java.lang.Runnable;
import java.lang.Thread;

/* Different ways of creating and starting a thread */

public class ThreadBasics{

	//1. Extending a Thread class
	public static class MyThread extends Thread{

		public MyThread(){
			super();
		}

		public MyThread(String name){
			super(name);
		}

		public MyThread(String name, Runnable runnable){
			super(runnable, name);
		}

		@Override
		public void run(){
			System.out.printf(String.format("Executing MyThread instance : %s\n",Thread.currentThread().getName()));	
		}
	}
	
	//2. Extending a Runnable class
	public static class MyRunnable implements Runnable{

		public MyRunnable(){
			super();
		}		

		@Override
		public void run(){
			System.out.printf(String.format("Executing MyRunnable instance : %s\n",Thread.currentThread().getName()));	
		}
	}

	public static void main(String[] args){

		MyThread thread1 = new MyThread("thread-1");
		thread1.start();

		MyThread thread2 = new MyThread("thread-2", new MyRunnable());
		thread2.start();	

		Thread thread3 = new Thread(()->{System.out.printf(String.format("Executing Runnable instance : %s\n",Thread.currentThread().getName()));}, "thread-3");	
		thread3.start();	

		//When running extended Thread with extended Runnable, Thread's run() method is used (not runnable's run())
		Thread thread4 = new MyThread("thread-4", new MyRunnable());
		thread4.start();

		//Thread's stop() method is deprecated. Thread's stop() has always been flaky
		//thread4.stop();
			
	}

}
