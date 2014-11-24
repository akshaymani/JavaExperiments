package com.akshay.threadingQuestions;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/*
 * Queue Interface, LinkedList, PriorityQueue, LinkedBlockingQueue, BlockingQueue Interface, ArrayBlockingQueue,
 * PriorityBlockingQueue, Synchronous Queue, DelayQueue, Deque [Double Ended Queue]
 * 
 * Concurrent Map Interface, Concurrent HashMap, Concurrent NaviagableMap Interface, Linked HashMap
 * 
 * Thread Pools, Runnable, Future Task
 * 
 * Stack etc [Use Deque interface and it's implementation in preference to this class for a more complete
 * and consistent set of stack LIFO operations]
 * 
 * Concurrent Sets etc
 */
// Executor interface does not guarantee asynchronous operations...check javaDocs for more details

// http://en.wikipedia.org/wiki/Java_collections_framework

// http://tutorials.jenkov.com/java-concurrency/thread-safety.html

public class Threading {

	public static void main(String[] args) {
		//synchronized (this) { cannot be used in a static context
		/*synchronized (Threading.class) {
			
		}*/
		ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(10);
		System.out.println("Core Pool Size: " + eventPool.getCorePoolSize());
		int i = 0;
		while (eventPool.getActiveCount() < eventPool.getCorePoolSize() && i < 100) {
			eventPool.execute(new MyThread("Num_" + String.valueOf(i)));
			System.out.println("Active Thread Count: " + eventPool.getActiveCount());
			System.out.println("Hello");
			i++;
		}
		System.out.println("Exited");
	}
	
	private static class MyThread implements Runnable {
		private String name;
		
		public MyThread(String name) {
			this.name = name;
		}
		
		public void run() {
			System.out.println("Thread Name: " + name);
			try {
				Thread.currentThread().wait(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
