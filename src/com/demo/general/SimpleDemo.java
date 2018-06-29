package com.demo.general;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleDemo {

	public static void main(String[] args) {
		//filterSort();
		
		//streamCreation();
		
		//averageOrSum();
		
		//mapToExample();
		
		//filterArray();
		
		// arrayToStream();
		
		// reusingStream();
		
		findFirstDemo();

	}

	// A general example of java stream filter , Map and sorted operation
	public static void filterSort() {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream()
		.filter(s -> s.startsWith("c"))
		.map(String::toUpperCase)
		.sorted()
		.forEach(System.out::println);
	}

	
	// Ways of Creating Stream
	public static void streamCreation() {
		
		Arrays.asList("a1", "a2", "a3")
		.stream()
		.findFirst()
		.ifPresent(System.out::println);
		
		
		Stream.of("a1", "a2", "a3")
	    .findFirst()
	    .ifPresent(System.out::println); 
	}
	
	
	
	// Using IntStream for looping integers
	public static void intStream() {
		
		IntStream.range(1, 4)
	    .forEach(System.out::println);
	}
	
	
	// Average or sum
	public static void averageOrSum() {
		
		//Average
		Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1)
	    .average()
	    .ifPresent(System.out::println);
		
		
		// Sum
		int sum = Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1)
	    .sum();
		System.out.println(sum);
		

		
		
	}
	
	// MapToInt and MapToObj example
	public static void mapToExample() {
		
		Arrays.asList("3", "6", "8", "14", "15").stream()
		.mapToInt(Integer::parseInt)
		.forEach(System.out::println);
		
		System.out.println("-----------------------------");
		
		Arrays.asList("Geeks", "for", "gfg",
                "GeeksforGeeks", "GeeksQuiz")
		.stream()
		.mapToInt(String::length)
		.forEach(System.out::println);
		
		System.out.println("-----------------------------");
		
		Stream.of("a1", "a2", "a3")
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt)
	    .max()
	    .ifPresent(System.out::println);
		
		System.out.println("------------------------------");
		
		IntStream.range(1, 4)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		Stream.of(1.0, 2.0, 3.0)
	    .mapToInt(Double::intValue)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);
	}
	
	
	// Convert Array to Stream
	public static void arrayToStream() {
		String [] myArray = {"one","two","three","four","five","six"};
		Arrays.stream(myArray).forEach(System.out::println);
		
		
		int myNewArray[] = { 1, 5, 8 };
		int sum = Arrays.stream(myNewArray).sum();
		System.out.println(sum);
	}
	
	
	// Creating sub Array after filtering array
	public static void filterArray() {
		
		String [] result  = Arrays.asList("Geeks", "for", "gfg",
                "GeeksforGeeks", "GeeksQuiz").stream()
		.filter(s -> s.length() >4)
		.toArray(String[]::new);
		
		for(String val : result) {
			System.out.println(val);
		}
		
	}
	
	// Example to show reusing stream and assign stream
	public static void reusingStream() {
		
		// Assigning stream with only intermediate operation
		Stream<String> stream =
			    Stream.of("d2", "a2", "b1", "b3", "c")
			        .filter(s -> s.startsWith("a"));

			System.out.println(stream.anyMatch(s -> true));    // ok
			// System.out.println(stream.noneMatch(s -> true));    // exception
		
	}
	
	
	public static void findFirstDemo() {
		
		List<String> gadgets =  
				Arrays.asList("SmartPhone","SmartWatch","SmartTV","SmartDoor","iPhone");
		
		// Using orElse
		String item = gadgets.stream() 
				//.peek(s -> System.out.println("processing: " + s))
				.filter(s -> s.length() > 9) 
				//.peek(s -> System.out.println("processing now: " + s))
				.findFirst()
				.orElse(""); 
		
		System.out.println("In Java 8, first item: " + item);
		
		
		
		
		// Using Optionals
		 Optional<String> val = gadgets.stream()
                 .filter(s -> s.length() > 8)
                 .findFirst();
		 
		if (val.isPresent()) {
		System.out.println("First item : " + val.get());
		}

		
		
	}
	

}
