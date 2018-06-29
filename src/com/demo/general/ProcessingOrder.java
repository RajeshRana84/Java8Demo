package com.demo.general;

import java.util.stream.Stream;

public class ProcessingOrder {

	
	public static void main(String[] args) {
		process();
		processAdvantage();
	}
	
	
	// Demonstration of Lazinnes and Processing Order
	public static void process() {
		
		// Nothing Happens as no terminal Operation
		// An important characteristic of intermediate operations is laziness
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    });
		
		
		// With Terminal Operation
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		// The processing order is vertical and not horizontal
		// i.e. each element goes through complete cycle before next element is processed
		//********Output*******
		// filter: d2
		// forEach: d2
		// filter: a2
		// forEach: a2
		// filter: b1
		// forEach: b1
		// filter: b3
		// forEach: b3
		// filter: c
		// forEach: c
		
		
		
	}
	
	
	
	public static void processAdvantage() {
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("A");
	    });
		
		
	}
}
