package com.akshay.designPatterns.SingletonDesign;

import java.util.LinkedList;

public class ScrabbleTest {

	public static void main(String[] args) {

		Singleton newInstance = Singleton.getInstance();

		System.out.println("Instance ID: " + System.identityHashCode(newInstance));

		System.out.println(newInstance.getLetterList());

		LinkedList<String> playerOneTiles = newInstance.getTiles(7);

		System.out.println("Player 1: " + playerOneTiles);

		Singleton instanceTwo = Singleton.getInstance();

		System.out.println("Instance ID: " + System.identityHashCode(instanceTwo));

		System.out.println(instanceTwo.getLetterList());

		LinkedList<String> playerTwoTiles = instanceTwo.getTiles(7);

		System.out.println("Player 1: " + playerTwoTiles);
	}

}
