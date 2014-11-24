package com.akshay.interviewQuestions;

import java.util.Scanner;

/*
 * http://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */

public class LongestCommonSubsequence {

	public static int lcsLenth; 
	
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			String one = scan.next();
			String two = scan.next();
			int length = recursiveFindLongestCommonSubsequenceLength(one,two);
			lcsLenth = length;
			System.out.println("Longest Common Subsequence Length using Recursion : " + String.valueOf(length));
			String lcs = recursiveFindLongestCommonSubsequence(one,two);
			System.out.println("Longest Common Subsequence using Recursion: " + lcs.substring(0,lcsLenth));
			int lengthTabulated = tabulatedFindLongestCommonSubsequenceLength(one,two);
			System.out.println("Longest Common Subsequence Length using Tabulated Approach : " + String.valueOf(lengthTabulated));
		}
		catch (Exception e) {
			System.out.println("Exception caught at Line 16 or 18");
		}
	}

	private static int tabulatedFindLongestCommonSubsequenceLength(String one,
			String two) {
		int m = one.length();
		int n = two.length();
		int[][] L = new int[m+1][n+1];
		for (int i = 0; i <= m ; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				}
				else if (one.charAt(i-1) == two.charAt(j-1)) {
					L[i][j] = L[i-1][j-1] + 1;
				}
				else {
					L[i][j] = max(L[i][j-1], L[i-1][j]);
				}
			}
			//printArray(L);
		}
		printArray(L);
		return L[m][n];
	}

	private static void printArray(int[][] l) {
		for (int i = 0; i < l.length; i++) {
			for (int j = 0 ; j < l[i].length; j++) {
				System.out.print(l[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------");
		System.out.println();
	}

	private static String recursiveFindLongestCommonSubsequence(String one,
			String two) {
		return recursiveFindLongestCommonSubsequence(one, two, one.length(), two.length(), "");
	}

	private static String recursiveFindLongestCommonSubsequence(String one,
			String two, int m, int n, String postfix) {
		if (m == 0 || n == 0) 
			return "";
		if (one.charAt(m-1) == two.charAt(n-1)) {
			String tempPostfix = postfix + String.valueOf(one.charAt(m-1));
			String tempVal = recursiveFindLongestCommonSubsequence(one, two, m-1, n-1, tempPostfix);
			return tempVal + tempPostfix;
		}
		else {
			String tempOne = recursiveFindLongestCommonSubsequence(one, two, m-1, n, postfix);
			String tempTwo = recursiveFindLongestCommonSubsequence(one, two, m, n-1, postfix);
			return tempOne.length() > tempTwo.length() ? tempOne : tempTwo;
		}
	}

	/*
	 * Examples:
		1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:
		L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)

		2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as:
		L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
	 */
	private static int recursiveFindLongestCommonSubsequenceLength(String one,
			String two) {
		return recursiveFindLongestCommonSubsequenceLength(one, two, one.length(), two.length());
	}

	private static int recursiveFindLongestCommonSubsequenceLength(String one,
			String two, int m, int n) {
		if (m == 0 || n ==0)
			return 0;
		if (one.charAt(m-1) == two.charAt(n-1)) {
			return 1 + recursiveFindLongestCommonSubsequenceLength(one, two, m-1, n-1);
		}
		else {
			return max(recursiveFindLongestCommonSubsequenceLength(one, two, m-1, n),recursiveFindLongestCommonSubsequenceLength(one, two, m, n-1));
		}
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
