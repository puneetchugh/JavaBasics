package com.puneet.chugh;
import java.lang.Thread;
import java.lang.Runnable;
import java.util.ArrayList;

public class Main{

	public static class MyTextWritingRunnable implements Runnable{
		
		NoSpuriousCalls noSpuriousCalls;
		ArrayList<String> list;
		String string;
		boolean isLast;
		public MyTextWritingRunnable(NoSpuriousCalls noSpuriousCalls, String string, ArrayList<String> list, boolean isLast){
			this.noSpuriousCalls = noSpuriousCalls;
			this.list = list;
			this.string = string;
			this.isLast = isLast;
		}

		@Override
		public void run(){
			list.add(string);
			if(isLast)
				noSpuriousCalls.doNotify();
		}
	}

	public static class MyTextReadingRunnable implements Runnable{

		NoSpuriousCalls noSpuriousCalls;
		ArrayList<String> list;
		public MyTextReadingRunnable(NoSpuriousCalls noSpuriousCalls, ArrayList<String> list){
			this.noSpuriousCalls = noSpuriousCalls;
			this.list = list;
		}

		@Override
		public void run(){
			noSpuriousCalls.doWait();
			StringBuilder sb = new StringBuilder();
			for(String string : list){
				sb.append(string);
			}
			System.out.printf("The combined string is %s\n",sb.toString());
		}
	}

	public static void main(String[] args){

		NoSpuriousCalls noSpuriousCalls = new NoSpuriousCalls();
		ArrayList<String> list = new ArrayList<>();
		
		Thread readThread = new Thread(new MyTextReadingRunnable(noSpuriousCalls, list));
		readThread.start();
		String string = "My name is Puneet Chugh";
		for(String one : string.split(" ")){
			Thread thread = new Thread(new MyTextWritingRunnable(noSpuriousCalls, one, list, false));
			thread.start();
		}
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.printf("Caught an Interrupted Exception : %s\n",e);
		}
		Thread thread1 = new Thread(new MyTextWritingRunnable(noSpuriousCalls, ".", list, true));
		thread1.start();
	}
}
