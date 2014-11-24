package com.akshay.interviewRoundQuestions;

public class Test {

	static int value = 1;
	public int getValue() {
		try {
			value = value+1;
			return value;
		}
		catch (Exception e) {
			return 0;
		}
		finally {
			value = value+1;
		}
	}
	
	public static void main(String[] args) {
		Test t1 = new Test();
		System.out.println(t1.getValue());
		System.out.println(t1.value);
		
		int x = 012;
		System.out.println(x);
		if (x==10.0) System.out.println("test");
		
	}
}
