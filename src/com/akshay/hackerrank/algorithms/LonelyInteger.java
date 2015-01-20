package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class LonelyInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] arr = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = scanner.nextInt();
		}
		int key = arr[0];
		for (int i = 1; i < T; i++) {
			key = key ^ arr[i];
		}
		System.out.println(key);
	}

}
