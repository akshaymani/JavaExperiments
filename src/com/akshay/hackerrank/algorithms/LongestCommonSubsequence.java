package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] arr1 = new int[N];
		int[] arr2 = new int[M];
		for (int i = 0; i < N; i++) {
			arr1[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < M; i++) {
			arr2[i] = scanner.nextInt();
		}
		
		int[][] lcsArray = lcs(arr1,arr2,N,M);
		
		int[] lcs = evaluateLCS(lcsArray,N,M,arr1,arr2);
		for (int i = 0; i < lcsArray[N][M] - 1; i++) {
			System.out.print(lcs[i] + " ");
		}
		System.out.println(lcs[lcsArray[N][M] - 1]);
	}

	private static int[] evaluateLCS(int[][] lcsArray, int N, int M, int[] arr1, int[] arr2) {
		int[] lcs = new int[lcsArray[N][M]];
		int i = N; int j = M;
		// Start from the right-most-bottom-most corner and
		// one by one store characters in lcs[]
		int index = lcsArray[N][M] - 1;
		while (i > 0 && j > 0) {
			// If current character in X[] and Y are same, then
		    // current character is part of LCS
			if (arr1[i-1] == arr2[j-1]) {
				lcs[index--] = arr1[i-1];
				i--; j--;
			}
			// If not same, then find the larger of two and
		    // go in the direction of larger value
		    else if (lcsArray[i-1][j] > lcsArray[i][j-1])
		    	i--;
		    else
		    	j--;
		}
		
		return lcs;
	}

	private static int[][] lcs(int[] arr1, int[] arr2, int N, int M) {
		int[][] lcsArray = new int[N+1][M+1];
		
		 for (int i = 0; i <= N; i++)
		   {
		     for (int j = 0; j <= M; j++)
		     {
		       if (i == 0 || j == 0)
		    	   lcsArray[i][j] = 0;
		       else if (arr1[i-1] == arr2[j-1])
		    	   lcsArray[i][j] = lcsArray[i-1][j-1] + 1;
		       else
		    	   lcsArray[i][j] = max(lcsArray[i-1][j], lcsArray[i][j-1]);
		     }
		   }
		
		return lcsArray;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
