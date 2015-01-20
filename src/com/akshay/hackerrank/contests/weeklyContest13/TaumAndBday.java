package com.akshay.hackerrank.contests.weeklyContest13;

import java.util.Scanner;

public class TaumAndBday {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long T = Long.parseLong(scanner.nextLine());
		while (T-- > 0) {
			String[] temp = scanner.nextLine().split(" ");
			long noOfBlack = Long.parseLong(temp[0]);
			long noOfWhite = Long.parseLong(temp[1]);
			temp = scanner.nextLine().split(" ");
			long costOfBlack = Long.parseLong(temp[0]);
			long costOfWhite = Long.parseLong(temp[1]);
			long costOfConversion = Long.parseLong(temp[2]);
			long count = handleBlack(noOfBlack,costOfBlack,costOfWhite,costOfConversion) * noOfBlack;
			count += handleWhite(noOfWhite,costOfBlack,costOfWhite,costOfConversion) * noOfWhite;
			System.out.println(count);
		}
	}
	
	private static long handleWhite(long noOfBlack, long costOfBlack, long costOfWhite,
			long costOfConversion) {
		return ((costOfBlack + costOfConversion) < costOfWhite) ? (costOfBlack + costOfConversion) :  costOfWhite;
	}

	private static long handleBlack(long noOfBlack, long costOfBlack, long costOfWhite,
			long costOfConversion) {
		return ((costOfWhite + costOfConversion) < costOfBlack) ? (costOfWhite + costOfConversion) :  costOfBlack;
	}

}
