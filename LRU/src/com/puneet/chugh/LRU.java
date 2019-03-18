package com.puneet.chugh;
import java.util.*;
public class LRU{

	private int MAX;
	private Queue<Integer> cacheQueue;
	private Map<Integer,Integer> frequency;
	LRU(int size){
		this.MAX = size;
		cacheQueue = new LinkedList<>();
		frequency = new HashMap<>();
	}
	
	public void refer(int page){
		
		//if cache queue is not full, then 
		//we need to find if the page already 
		//exists, then delete it from the cache queue
		if(cacheQueue.size() < MAX && !frequency.containsKey(page)){
			System.out.println("cache Queue is not full and this is the first occurence");
			cacheQueue.add(page);
			frequency.put(page,1);
		}
		else{
				int currentSize = cacheQueue.size();
				//find out if previously this page existed
				boolean isDeleted = deletePrevious(page);
				if(!isDeleted && currentSize==MAX){
					System.out.printf("%d didn't exist earlier, and cache queue is full, so deleting LFU...\n",page);
					deleteLFUPage();
				}
				cacheQueue.add(page);				
				frequency.put(page, (!isDeleted) ? 1 : frequency.get(page)+1);
		}
	}

	public boolean deletePrevious(int page){
		
		Iterator<Integer> iterator = cacheQueue.iterator();
		while(iterator.hasNext()){
			if(iterator.next() == page){
				iterator.remove();
				System.out.printf("Removing previous occurence of %d\n",page);
				return true;
			}
		}
		System.out.println();
		return false;
	}	
	
	public void deleteLFUPage(){
		int pageToDelete = Integer.MAX_VALUE;
		int tempFreq = Integer.MAX_VALUE;
		for(Map.Entry<Integer,Integer> entry : frequency.entrySet()){
			
			if(entry.getValue() < tempFreq){
				pageToDelete = entry.getKey();
				tempFreq = entry.getValue();
			}
		}
		if(pageToDelete != Integer.MAX_VALUE){
			frequency.remove(pageToDelete);
			Iterator<Integer> iterator = cacheQueue.iterator();
			int counter = 0;
			while(iterator.hasNext()){
				if(iterator.next() == pageToDelete){
					iterator.remove();
					break;
				}
			}
		}
	}
	
	public static void main(String[] args){
		
		LRU lru = new LRU(5);
		int[] pages = {5,4,3,6,4,4,5,5,9,2,2,3,4,1,2,8};
		for(int page : pages){
			System.out.printf("Refering page %d\n",page);
			lru.refer(page);	
		}
	}	

}
