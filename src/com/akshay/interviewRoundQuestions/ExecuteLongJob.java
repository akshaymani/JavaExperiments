package com.akshay.interviewRoundQuestions;

public class ExecuteLongJob {

	private static boolean interruptTask = false;
	
	private static class MyTask extends Thread {
		public void run() {
			while (!interruptTask) {
				
			}
			System.out.println("out of the while loop");
		}
	}
	
	public static void main(String[] args) throws Exception{
		Thread task = new MyTask();
		task.start();
		System.out.println("asdad");
		Thread.sleep(5000L);
		interruptTask = true;
		if (interruptTask)
		System.out.println("interruptTask is true");
		System.out.println(Thread.activeCount());
		task.join();
	}
	
}
