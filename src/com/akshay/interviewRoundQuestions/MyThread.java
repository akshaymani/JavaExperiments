package com.akshay.interviewRoundQuestions;

public class MyThread extends Thread {

	public void run() {
		try {
			Thread.sleep(1000L);
		}
		catch (Exception e) {
			
		}
		System.out.println("Thread Output");
	}
	
}
