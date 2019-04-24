package com.puneet.chugh;
import java.util.*;
public class EmptyIntervals{

	private List<Pair> pairList;
	private long startTime;
	private long endTime;

	private Comparator<Pair> pairComparator = (p1,p2)->{
							long diff = 0;
							if(p1.start != p2.start){
								diff = p1.start-p2.start;
							}
							else{
								diff = p1.end-p2.end;
							}
							return (diff>0) ? 1 : 
								((diff<0)? -1 : 0);
						};
	
	public EmptyIntervals(List<Pair> pairList, int startTime, int endTime){
		this.pairList = pairList;
		this.startTime = startTime;
		this.endTime = endTime;
	}

		

	public List<Pair> fillEmptyIntervals(){

		List<Pair> emptyIntervals = new LinkedList<>();
		
		Collections.sort(pairList, pairComparator);
		long globalEnd = 0;

		if(startTime < pairList.get(0).start){
			Pair pair = new Pair(startTime, pairList.get(0).start, "empty");
			emptyIntervals.add(pair);
			globalEnd = pairList.get(0).start;
		}
		for(int counter=0; counter<pairList.size(); counter++){
			Pair pair = pairList.get(counter);
			if((globalEnd!=0) && (pair.start > globalEnd)){
				emptyIntervals.add(new Pair(globalEnd, pair.start, "empty"));	
			}
			
			if(globalEnd < pair.end){
				globalEnd = pair.end;
			}
		}
		
		if(globalEnd < endTime){
			emptyIntervals.add(new Pair(globalEnd, endTime, "empty"));
		}

		pairList.addAll(emptyIntervals);
		Collections.sort(pairList, pairComparator);
		return pairList;
	}
	

	public static void main(String[] args){
		
		Pair p1 = new Pair(1,5, "Kaku");
		Pair p2 = new Pair(3,8, "Puneet");
		Pair p3 = new Pair(10,17, "Punnu");
		Pair p4 = new Pair(15,19, "Chugh");
		Pair p5 = new Pair(22,25, "Puns");
		List<Pair> list = new LinkedList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		EmptyIntervals intervals = new EmptyIntervals(list, 0, 30);
		for(Pair pair : intervals.fillEmptyIntervals()){
			System.out.printf("(%d,%d) - %s\n", pair.start, pair.end, pair.name);
		}
	}

}
