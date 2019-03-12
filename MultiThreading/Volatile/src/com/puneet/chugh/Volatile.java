package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;
import java.util.Random;

public class Volatile{

	private int var1;
	private int var2;
	private volatile int volatileVar;
	
	public synchronized void readVariables(){
		int variableVolatile = volatileVar;
		int variable1 = var1;
		int variable2 = var2;
		
		System.out.printf("var1 is %d, var2 is %d, var3 is %d\n",variable1, variable2, variableVolatile);
	}
	
	public synchronized void update(int var1, int var2, int volVar){
		this.var1 = var1;
		this.var2 = var2;
		this.volatileVar = volVar;
	}

	public static class MyUpdateRunnable implements Runnable{
		
		private Volatile vol;
		public MyUpdateRunnable(Volatile vol){
			this.vol = vol;
		}

		@Override
		public void run(){
			Random random = new Random();
			int var1 = random.nextInt(1000);
			int var2 = random.nextInt(1000);
			int varVolatile = random.nextInt(1000);
			System.out.printf("Updating var1 : %d, var2 : %d, var3 : %d\n", var1, var2, varVolatile);
			vol.update(var1, var2, varVolatile);	
		}
	}

	public static class MyReadRunnable implements Runnable{
		
		Volatile vol;
		public MyReadRunnable(Volatile vol){
			this.vol = vol;
		}
		
		@Override
		public void run(){
			vol.readVariables();	
		}
	}

	public static void main(String[] args){
		
		Volatile vol = new Volatile();
		
		for(int counter=0; counter<5; counter++){
			try{
				Thread thread1 = new Thread(new MyUpdateRunnable(vol));
				thread1.start();
				thread1.join();
				Thread thread2 = new Thread(new MyReadRunnable(vol));
				thread2.start();
				thread2.join();
			}catch(InterruptedException ex){
				System.out.println("Interrupted exception encountered : "+ex.getMessage());
			}
		}	
	}	
}
