package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class SherlockAndTheBeast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while(T-- > 0) {
			int N = scanner.nextInt();
			StringBuilder s = new StringBuilder();
			for (int i = N; i >= 0; i--) {
				if (i % 3 == 0 && (N - i) % 5 == 0) {
					s.append(createString("5",i));
					s.append(createString("3", N - i));
					break;
				}
			}
			if (null != s.toString() && s.toString().length() != 0)
				System.out.println(s.toString());
			else
				System.out.println("-1");
			
		}

	}

	private static String createString(String str, int num) {
		StringBuilder val = new StringBuilder();
		while (num-- > 0) {
			val.append(str);
		}
		return val.toString();
	}

}
