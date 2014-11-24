package com.akshay.interviewRoundQuestions;

public class GarbageCollector {
	
	private DerivedTest test = new DerivedTest();
	
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.run();
		System.out.println("Main Output");
		GarbageCollector m = new GarbageCollector();
		
		System.gc();
		
	}
	
	private class BaseTest {
		public BaseTest() {
			// TODO Auto-generated constructor stub
		}
		protected void finalize() {
			System.out.println("Destroying Base");
		}
	}
	
	private class DerivedTest extends BaseTest {
		public DerivedTest() {
			// TODO Auto-generated constructor stub
		}
		protected void finalize() {
			System.out.println("Destroying Derived");
		}
	}

}
