package com.puneet.chugh;
import java.util.*;

public class LRU{

	private int MAX;
	Queue<Integer> queue;
	Set<Integer> existingPages;
	public LRU(int size){
		MAX = size;
		queue = new LinkedList<>();
		existingPages = new HashSet<>();
	}

	public void refer(int page){
		if(existingPages.contains(page)){
			System.out.printf("Page %d is already in the queue...",page);
			removeSpecificPage(page);
		}
		else{
			if(queue.size() == MAX){
				int lruPage = removeLRU();
				existingPages.remove(lruPage);
				System.out.printf("Removing LRU page %d\t and adding page %d\n", lruPage, page);
			}
			existingPages.add(page);
		}
		queue.add(page);
	}
	
	public void removeSpecificPage(int page){
		Iterator<Integer> iterator = queue.iterator();
		while(iterator.hasNext()){
			if(iterator.next() == page){
				System.out.printf("Removing the specific page %d\n",page);
				iterator.remove();
				return;
			}
		}
	}
	
	public int removeLRU(){
		//System.out.println("Removing the LRU");
		return queue.remove();
	}
	
	public static void main(String[] args){
	
		LRU lru = new LRU(5);
		int[] array = {2,3,1,4,4,5,5,7,9,3,2,1};
		for(int page : array){
			lru.refer(page);
		}
	}
	
}


