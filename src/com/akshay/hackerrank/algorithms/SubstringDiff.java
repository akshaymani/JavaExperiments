package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class SubstringDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int L = 0;
		String s1 = "";
		String s2 = "";
		String substr1 = "";
		int max = 0;
		while (T-- > 0) {
			L = scanner.nextInt();
			s1 = scanner.next();
			s2 = scanner.next();
			int L1 = s1.length();
			int L2 = s2.length();
			max = Integer.MIN_VALUE;
			for (int i = 0; i <= L1 - L; i++) {
				for (int j = L1; j >= L+i; j--) {
					substr1 = s1.substring(i, j);
					System.out.println(substr1);
					// find a substring of length j in s2 which has max 
					// of L characters different and break once found
					for (int k = 0; k <= L2 - j; j++) {
						
					}
				}
			}
		}

	}

}
