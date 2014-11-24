package com.akshay.interviewRoundQuestions;

// Lazy Loading is the concept of creating objects at the point when they are accessed for the first time
// Therefore, in the constructor of the class we will not create it and instead create it in the getter method 
// of that member variable - object

public class GoldmanSachsInterview {

	static String s = "ABC";
	
	public static void main(String[] args) {
		System.out.println(s);
		s = "DEF";
		s = new String("GH");
		
		System.out.println(s);
		
		String m = "KJ";
		String p = "KJ";
		
		m = "ll";
		
		System.out.println(m);
		
		System.out.println(p);
		
		System.out.println("Values 1: " + addNumbers(new Integer(19), new Integer(20)));
		System.out.println("Values 2: " + addNumbers(new Float(10.2),new Float(11.0)));
		System.out.println("Values 3: " + addNumbers(10, 11.5));
	}
	
	public static int addNumbers(int a, int b) {
		return a+b;
	}
	
	public static int addNumbers(float a, float b) {
		return (int) (a*b);
	}
	
	public static float addNumbers(double a, double b) {
		return 0;		
	}
	
}
