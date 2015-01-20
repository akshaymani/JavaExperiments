package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class UtopianTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int height = 0;
		int cycles = 0;
		while(T-- > 0) {
			height = 1;
			cycles = scanner.nextInt();
			for (int i = 1; i <= cycles; i++) {
				if (i % 2 == 1) 
					height = height * 2;
				else
					height += 1;
			}
			
			System.out.println(height);
		}

	}

}
