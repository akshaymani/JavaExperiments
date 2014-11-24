package com.akshay.threadingQuestions;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @SuppressWarnings("unchecked")
	public void run() {
        try {
            queue.put("1");
            System.out.println("Put 1");
            Thread.sleep(1000);
            queue.put("2");
            System.out.println("Put 2");
            Thread.sleep(1000);
            queue.put("3");
            System.out.println("Put 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
