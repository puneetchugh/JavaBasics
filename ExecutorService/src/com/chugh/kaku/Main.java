package com.chugh.kaku;

import java.util.*;
import java.util.concurrent.*;

class Main{

	public static void main(String[] args){
		
		Set<Callable<String>> callables = new HashSet<Callable<String>>();
		callables.add(new Callable<String>(){
			public String call() throws Exception{
				System.out.println("Doing task 1.....");
				for(int i=0;i<10;i++){
					System.out.println("Inside Task1");
				}
				return "Task 1";
			}
		});

		callables.add(new Callable<String>(){
			public String call() throws Exception{
				System.out.println("Doing task 2......");
				return "Task 2";
			}
		});

		callables.add(new Callable<String>(){
			public String call() throws Exception{
				System.out.println("Doing task 3......");
				return "Task 3";
			}
		});

		ExecutorService pool = Executors.newFixedThreadPool(2);
		//String result = ""; 
		try{
			List<Future<String>> futureList = pool.invokeAll(callables);
			for(Future<String> oneFuture: futureList)
			{
				System.out.println("Future Result : "+oneFuture.get());
			}
			/*
			for(Callable<String> callable : callables){
				Future<String> result = pool.submit(callable);
			
				System.out.println("Result : "+result.get());
			}*/

		
		}catch(Exception exception){

		}
		//System.out.println("Result : "+result.get());

		pool.shutdown(); 
		
	}
}
