package com.akshay.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		int[] iNums = new int[1000007];
		while (T-- > 0) {
			int N = scanner.nextInt();
			Arrays.fill(iNums, 0);
			for (int i = 0; i < N; i++) {
				iNums[scanner.nextInt()] += 1;
			}
			long sum = 0;
			for (int i = 0; i <= 1000000; i++) {
				if (iNums[i] > 1)
					sum += ((long) iNums[i])*((long) iNums[i] - 1);
			}
			System.out.println(sum);
		}
	}
}
