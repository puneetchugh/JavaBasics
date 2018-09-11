package com.puneet.chugh;

import java.util.stream.Stream;
import java.util.*;
import java.util.regex.Pattern;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.*;
import java.util.function.Function;
public class MyStreams{

	public Stream<String> streamOf(List<String> list){

		return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}

	public static void main(String[] args){

		List<String> stringList = Arrays.asList("Puneet", "Jyoti", "OmParkash", "Saroj", "Pawan", "Pranav");
		System.out.println("Printting stringList : "+stringList);	
		//Stream of Collections
		Collection<String> collection = Arrays.asList("Puneet", "Jyoti", "OmParkash", "Saroj");
		Stream<String> streamOfCollection = collection.stream();

		//Stream of Array
		Stream<String> streamOfArray = Stream.of("Puneet", "Piyush", "Kamran", "Manmohan");

		String[] arr = {"Kaku", "Pankaj", "Pawan", "Durga", "Prasad"};		
		Stream<String> fullArrayStream = Arrays.stream(arr);
		System.out.println("Printing String array : "+arr);
		
		String[] intArray = {"121", "212", "131" , "313"};
			
		System.out.println("Stream : "+streamOfCollection);	
		System.out.println("String List : "+stringList);

		
		//Stream generate()
		Stream<String> streamGenerated = Stream.generate(() -> "element").limit(20);
		
		//Break string into sub-strings 
		Stream<String> streamOfString = Pattern.compile(",").splitAsStream("a,b,c");

		stringList
			.stream()
			.filter(s->s.startsWith("P"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);

		Stream<String> intStream = Arrays.stream(intArray);
			intStream
			.mapToInt(s->Integer.parseInt(s))
			.filter(s->(s>200))
			//.sum();
			.sorted()
			.forEach(System.out::println);

		streamOfCollection
			.forEach(System.out::println);

		fullArrayStream
			.findFirst();
			
		Optional<String> optionalString = streamOfArray
							.findFirst();
		System.out.println("optionalString : "+optionalString.get());
	
		//int optionalIntSum =  Arrays.stream(intArray) //when using mapToInt() and sum(), it returns int
		//OptionalInt optionalIntSum = Arrays.stream(intArray)
		Optional<Integer> optionalIntSum = Arrays.stream(intArray)
							//.mapToInt(s->Integer.parseInt(s))
							.map(Integer::parseInt)
							//.map(x->Integer.parseInt(x))
							.reduce(Integer::sum);
							//.reduce((x,y)->(x+y)); //Here reduce will return Optional<Integer> as we have used .map, using mapToInt() will return OptionalInt
		System.out.println("Optional<Integer> : "+optionalIntSum.get());

		//OptionalInt optionalIntSum2 =  Arrays.stream(intArray) 
							Arrays.stream(intArray) 
							.mapToInt(s->Integer.parseInt(s))
							//.mapToInt(Integer::parseInt) //same as previous one
							//.sum(); //you won't be able to use sum on map(Integer::parseInt)
							.reduce((x,y)->x+y).ifPresent(System.out::println); //reduce returns OptionalInt. But sum() returns int
		//System.out.println("OptionalInt : "+optionalIntSum2.getAsInt());

							//Arrays.stream(intArray) 
							Arrays.stream(intArray) 
							.mapToInt(s->Integer.parseInt(s))
							//.mapToInt(Integer::parseInt) //same as previous one
							//.sum(); //you won't be able to use sum on map(Integer::parseInt)
							//.reduce((x,y)->x+y).ifPresent(System.out::println); //reduce returns OptionalInt. But sum() returns int
							.sorted()
							.forEach(System.out::println);

		//OptionalInt optionalInt33 = Arrays.stream(intArray)
		int intSum = Arrays.stream(intArray) 
				//.mapToInt(s->Integer.parseInt(s))
				.mapToInt(Integer::parseInt)
				.sum();
				//reduce returns OptionalInt. But sum() returns int

		System.out.println("int : "+intSum);

		List<String> result = 	stringList.stream()
						.collect(toList());
		List<String> stringListResult = stringList.stream()
							.collect(toCollection(LinkedList::new));
		System.out.println("Printing stringListResult : "+stringListResult);

		Integer[] integerArray = new Integer[]{1,11,21,31,41,51,61,71,81,91,101};
		List<Integer> integerList = Arrays.stream(integerArray).collect(toList());
		System.out.println("Printing integerList : "+integerList);

		Map<String, Integer> mapCollection = Arrays.stream(intArray).collect(toMap(Function.identity(), String::length));
		for(String key : mapCollection.keySet()){
			System.out.println("Key : "+key+"\tValue : "+mapCollection.get(key));
		}

		MyObject[] myObjectArray = new MyObject[]{new MyObject(28, "Puneet", "3019937834"),
							  new MyObject(21, "Patrick", "4479908877"),
							  new MyObject(19, "Pratik", "8097891122"),
							  new MyObject(30, "Roland", "9098991234"),
							  new MyObject(40, "Seth", "4049099898"),
							  new MyObject(50, "Ravindra", "3032021234"),
							  new MyObject(25, "Chris", "7072029876"),
							  new MyObject(34, "Steve", "6064048900"),
							  new MyObject(22, "Matt", "5050009876"),
							  new MyObject(30, "Steve", "2021019494"),
							  new MyObject(48, "David", "5559094040")};
								
		//Find the names that are in the age group 20-40 and have name of length 6
		Arrays.stream(myObjectArray)
		      .filter(s->(s.getAge()>20 && s.getAge()<40) && (s.getName().length() == 6))
		      .forEach(System.out::println);
		
		//Store the result of above query in a map with Name as the key and Object as the value
		Map<String, MyObject> mapOfObjects = 
		       Arrays.stream(myObjectArray)
		      .filter(s->(s.getAge()>20 && s.getAge()<40) && (s.getName().length() == 6))
		      .collect(toMap(MyObject::getName, myObject->myObject));
	
		//Find the average of ages of people whose phone numbers have pattern 404
		double averageAge = Arrays.stream(myObjectArray)
					.parallel()
					.filter(s->(s.getTelNumber().matches("(.*)404(.*)")))
					.mapToDouble(s->s.getAge())
					.average()
					.getAsDouble();
		
		System.out.println("Average age : "+averageAge); 
	}
}
