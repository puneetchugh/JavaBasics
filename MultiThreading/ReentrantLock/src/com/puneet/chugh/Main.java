package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;

public class Main{

	public static void main(String[] args){
		try{
			okMethod();
		}catch(InterruptedException|IllegalMonitorStateException ex){
			System.out.printf("InterruptedException encountered %s\n", ex.getMessage());
		}catch(Exception exc){
			System.out.printf("Exception caught %s\n",exc.getMessage());
		}
	}

	public static void okMethod()throws IllegalMonitorStateException, InterruptedException{
		ReentrantLocks lock = new ReentrantLocks();
		lock.lock();
		try{
			//do work
			System.out.printf("Doing work inside 1st level lock...\n");
			innerMethod(lock);	
		}catch(IllegalMonitorStateException ex){
			System.out.printf("Exception encounted %s\n",ex.getMessage());
		}finally{
			lock.unlock();
		}
		
	}

	public static void innerMethod(ReentrantLocks lock)throws IllegalMonitorStateException,InterruptedException{
		lock.lock();
		try{
			//do work
			System.out.printf("Doing work inside 2nd level lock...\n");
		}catch(IllegalMonitorStateException ex){
			System.out.printf("Exception encountered %s\n", ex.getMessage());
		}finally{
			lock.unlock();
		}
	}
}
