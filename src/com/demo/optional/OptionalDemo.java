package com.demo.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

	
	public static void main(String[] args) {
		createOptional();
		isPresentOptional();
		ifPresentOtional();
		getOptional();
		ofNullable();
		orElse();
		orElseGet();
		orElseThrow();
		filterOptional();
		mapOptional();
	}
	
	
	public static void createOptional() {
		
		// Creating Empty Optional
		Optional<String> empty = Optional.empty();
		System.out.println("createOptional : "+empty.isPresent());  // false
		System.out.println("createOptional : "+empty.toString());  // Optional.empty
		//System.out.println("createOptional : "+empty.get());  // java.util.NoSuchElementException: No value present
		
		
		
		// Creating Optional with Non-Null Values
		String name = "baeldung";
	    Optional<String> opt = Optional.of(name);
	    System.out.println("createOptional 2 : "+opt.isPresent()); // true
	    System.out.println("createOptional 2 : "+opt.get()); // baeldung
	    System.out.println("createOptional 2 : "+opt.toString()); // Optional[baeldung]
	    
	    
	    
	    // Creating optional with Null value - Bad way
	    String item = null;
	    //Optional<String> result = Optional.of(item); // Null Pointer Exception
	    
	    
	    
	    // Creating optional with Null value - Good way
	    String empName = null;
	    Optional<String> empOpt = Optional.ofNullable(empName);
	    System.out.println("createOptional 3 : "+empOpt.isPresent()); // false
	    System.out.println("createOptional 3 : "+empOpt.toString()); // Optional.empty
	    //System.out.println("createOptional 3 : "+empOpt.get());  // java.util.NoSuchElementException: No value present
	}
	

	
	
	public static void isPresentOptional() {
	   
		// Check non null value
		Optional<String> opt = Optional.of("Baeldung");
	    System.out.println("is Present : "+opt.isPresent());  // true
	 
	    // Check Null value
	    opt = Optional.ofNullable(null);
	    System.out.println("is Present : "+opt.isPresent());   // false
	}
	
	
	
	public static void ifPresentOtional() {
		
		// Perform action if value is present
	    Optional<String> opt = Optional.of("baeldung");
	    
	    opt.ifPresent(s -> System.out.println("if Present : "+s.length()));  // 8
	}
	
	
	
	public static void getOptional() {
		Optional<String> opt = Optional.of("baeldung");
		 System.out.println("Get Value : "+opt.get());
	}
	
	
	
	public static void ofNullable() {
	    // Creating optional with Null value - Good way
	    String empName = null;
	    Optional<String> empOpt = Optional.ofNullable(empName);
	    System.out.println("ofNullable : "+empOpt.isPresent()); // false
	    System.out.println("ofNullable : "+empOpt.toString()); // Optional.empty
	    //System.out.println("ofNullable : "+empOpt.get());  // java.util.NoSuchElementException: No value present
	
	
	    String opt = "Nitin";
	    Optional<String> result = Optional.ofNullable(opt);
	    System.out.println("ofNullable 2: "+result.isPresent()); // true
	    System.out.println("ofNullable 2: "+result.toString()); // Optional[Nitin]
	    System.out.println("ofNullable 2 : "+result.get()); // Nitin
	}
	
	
	// ****************** Default Value With orElse  ******************************
	/*
	 * This method returns the value if present, otherwise returns the 
	 * otherValue provided in the argument. When we are not sure whether 
	 * Optional will contain value, it’s always good idea to use this method 
	 * rather than simple get().
	 * */
	public static void orElse() {
		 String nullName = null;
		 String name = Optional.ofNullable(nullName).orElse("john");
		 System.out.println("orElse : "+name); // john
		 
		 
		 String empName = "Nitin";
		 String result = Optional.ofNullable(empName).orElse("john");
		 System.out.println("orElse 2 : "+result); // Nitin
	}
	
	
	
	public static void orElseGet() {
		
	    String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
	    System.out.println("orElseGet  : "+name); // john
	    
	    
	    String nullName2 = "Nitin";
	    String name2 = Optional.ofNullable(nullName2).orElseGet(() -> "john");
	    System.out.println("orElseGet 2 : "+name2); // Nitin
	}
	
	
	
	public static void orElseThrow() {
	    String nullName = null;
	    //String name = Optional.ofNullable(nullName).orElseThrow(
	      //IllegalArgumentException::new); // java.lang.IllegalArgumentException
	    
	    
	    String empName = "Nitin";
	    String res = Optional.ofNullable(empName).orElseThrow(
	      IllegalArgumentException::new);
	    
	    System.out.println("orElseThrow : "+res); 
	}
	
	
	
	public static void filterOptional() {
		
	    Integer year = 2016;
	    Optional<Integer> yearOptional = Optional.of(year);
	    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
	    System.out.println("filterOptional : "+is2016);  // true
	    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
	    System.out.println("filterOptional : "+is2017);   // false
	}
	
	
	
	// **************** Transforming Value with map() ***************************
	public static void mapOptional() {
		
		
	    List<String> companyNames = Arrays.asList(
	    	      "paypal", "oracle", "", "microsoft", "", "apple");
	    Optional<List<String>> listOptional = Optional.of(companyNames); 
	    int size = listOptional
	    	      .map(List::size)
	    	      .orElse(0);
	    	  
	    System.out.println("mapOptional : "+size); // 6
	    	    
	    	    
	    
	    String name = "baeldung";
	    Optional<String> nameOptional = Optional.of(name);
	 
	    int len = nameOptional
	     .map(String::length)
	     .orElse(0);
	    	   
	    System.out.println("mapOptional : "+len); // 8
	    
	    
	    
	    
	   String password = " password ";
	   Optional<String> passOpt = Optional.of(password);
	   
	   boolean correctPassword = passOpt.filter(
	    pass -> pass.equals("password")).isPresent();
	    
	   System.out.println("mapOptional 2: "+correctPassword);
	    
	    correctPassword = passOpt
	    .map(String::trim)
	    .filter(pass -> pass.equals("password"))
	    .isPresent();
	    
	    System.out.println("mapOptional 2: "+correctPassword);
		
	}
	

}
