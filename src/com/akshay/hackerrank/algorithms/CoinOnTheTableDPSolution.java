package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class CoinOnTheTableDPSolution {

	public static void main(String[] args) {
		// Starting point is top right
		// At time K we have to reach
		// All cells have info for next operation to be performed
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		char[][] arr = new char[n][m];

		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
	}
	
}
