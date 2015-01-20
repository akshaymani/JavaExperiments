package com.akshay.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IsFibo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Long> fibonacciNums = getFiboNums();
		Long[] numList = new Long[fibonacciNums.size()];
		numList = fibonacciNums.toArray(new Long[fibonacciNums.size()]);
		int T = scanner.nextInt();

		while(T-- > 0) {
			long num = scanner.nextLong();
			if (num == 0 || Arrays.binarySearch(numList, 2, numList.length, num) < 0){
				System.out.println("IsNotFibo");
			}
			else {
				System.out.println("IsFibo");
			}
		}
	}

	private static ArrayList<Long> getFiboNums() {
		ArrayList<Long> fiboNums = new ArrayList<Long>();
		fiboNums.add((long) 0);
		fiboNums.add((long) 1);
		int index = 1;
		long upperbound = new Long("10000000000");
		while (fiboNums.get(index) < upperbound) {
			long val = fiboNums.get(index-1) + fiboNums.get(index);
			fiboNums.add(val);
			index++;
		}
		return fiboNums;
	}

}
