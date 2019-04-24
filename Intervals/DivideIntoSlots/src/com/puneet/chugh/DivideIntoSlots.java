package com.puneet.chugh;
import java.util.*;

public class DivideIntoSlots{

	List<Interval> intervalList; 
	Comparator<Interval> startTimeComparator = (i1,i2)->{
		int diff = 0;
		if(i1.start != i2.start){
			diff = i1.start - i2.start;
		}
		else{
			diff = i1.end - i2.end;
		}
		return diff;
	};

	Comparator<Interval> endTimeComparator = (i1,i2)->{
		
		return (i1.end-i2.end);
	};
	
	public DivideIntoSlots(List<Interval> intervalList){
		this.intervalList = intervalList;
	}

	public List<Interval> divideIntoSlots(List<Interval> input){
		
		int startTime = input.get(0).start;
		int nextStart = 0;
		List<Interval> prevList = new LinkedList<>();
		List<Interval> choppedList = new LinkedList<>();
		for(int counter=0; counter<input.size(); counter++){
			Interval current = input.get(counter);
			startTime = current.start;
			nextStart = ((counter+1) < input.size() && (current.end > input.get(counter+1).start))? input.get(counter+1).start : current.end;
			prevList.add(current);	
			Iterator<Interval> iterator = prevList.iterator();
			Interval internalInterval = null;
			
			while(iterator.hasNext()){
				internalInterval = iterator.next();
				if((internalInterval.end > current.start) && (internalInterval.end <= nextStart)){
				
					choppedList.add(new Interval(startTime, internalInterval.end));
					startTime = internalInterval.end;	
					iterator.remove();
				}
				else{
					break;
				}
			}
			if(startTime == current.start){
				choppedList.add(new Interval(startTime, nextStart));
			}

			if((counter+1)<input.size() && nextStart<input.get(counter+1).start){
				input.add(new Interval(startTime, input.get(counter+1).start));
				Collections.sort(input, startTimeComparator);
			}
	
		}
		
		return choppedList;	
	}

	public static void main(String[] args){

		List<Interval> intervalList = new LinkedList<>();
		
		intervalList.add(new Interval(1,5));
		intervalList.add(new Interval(3,8));
		intervalList.add(new Interval(10,17));
		intervalList.add(new Interval(15,19));
		intervalList.add(new Interval(22,25));
		
		DivideIntoSlots divide = new DivideIntoSlots(intervalList);
		List<Interval> choppedList = divide.divideIntoSlots(intervalList);
		
		for(Interval interval: choppedList){
			System.out.printf("Interval : (%d,%d)\n", interval.start, interval.end);
		}
		

	}
}
