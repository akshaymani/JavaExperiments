package com.akshay.hackerrank.algorithms;

import java.util.Scanner;

public class FindDigits {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		String num = null;
		int val = 0;
		int slen = 0;
		int valIndex = 0;
		int count = 0;
		while(T-- > 0) {
			count = 0;
			num = scanner.next();
			slen = num.length();
			val = Integer.parseInt(num);
			for(int i = 0; i < slen; i++) {
				valIndex = Integer.parseInt(String.valueOf(num.charAt(i)));
				if (valIndex != 0 && val % valIndex == 0) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
}
