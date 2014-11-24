package com.akshay.designPatterns.SingletonDesign;

import java.util.LinkedList;

public class ScrabbleTestThreads {

	public static void main(String[] args) {
		Runnable getTiles = new GetTheTiles();
		Runnable getTilesAgain = new GetTheTiles();
		
		new Thread(getTiles).start();
		new Thread(getTilesAgain).start();
	}
	
	private static class GetTheTiles implements Runnable {

		@Override
		public void run() { 
			Singleton newInstance = Singleton.getInstance();
			System.out.println("Instance ID: " + System.identityHashCode(newInstance));
			System.out.println(newInstance.getLetterList());
			LinkedList<String> playerOneTiles = newInstance.getTiles(7);
			System.out.println("Player: " + playerOneTiles);
			System.out.println("Got The Tiles");
		}
		
	}
}
