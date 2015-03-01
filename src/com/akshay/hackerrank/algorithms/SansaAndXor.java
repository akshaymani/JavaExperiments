package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class SansaAndXor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T-- > 0) {
			int N = scanner.nextInt();
			int ans = 0;
			for (int i = 0; i < N; i++) {
				int num = scanner.nextInt();
				long times = (long) (i+1) * (N - i);
				if (times % 2 == 1) {
					ans ^= num;
				}
			}
			System.out.println(ans);
		}

	}

}
