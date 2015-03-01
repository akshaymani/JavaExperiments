package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class Maxsubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] arr = new int[100000];
		while (T-- > 0) {
			int N = scanner.nextInt();

			int maxContinuousSum = 0;
			int max = 0;
			int maxNonContinousSum = 0;
			boolean allNegative = true;
			
			int highestVal = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				arr[i] = scanner.nextInt();
				if (arr[i] > 0) {
					maxNonContinousSum += arr[i];
					allNegative = false;
				}
				
				if (arr[i] > highestVal)
					highestVal = arr[i];
				
				max += arr[i];
				if (max < 0)
					max = 0;
				if (max > maxContinuousSum)
					maxContinuousSum = max;
				//System.out.println(maxContinuousSum + " " + maxNonContinousSum + " " + highestVal);
			}	
			
			if (!allNegative) {
				System.out.println(maxContinuousSum + " " + maxNonContinousSum);
			}
			else {
				System.out.println(highestVal + " " + highestVal);
			}
			
		}

	}

}
