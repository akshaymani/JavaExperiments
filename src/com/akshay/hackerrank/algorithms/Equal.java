package com.akshay.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Equal {	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		while (T-- > 0) {
			int N = Integer.parseInt(scanner.nextLine());

			int[] arr = new int[N];
			String line = scanner.nextLine();
			String[] nums = line.split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(nums[i]);
			}
			//Arrays.sort(arr);
			if (N >= 2) {
				int minVal = arr[0];
				for(int i = 1; i < N; ++i){
					if (arr[i] < minVal){
						minVal = arr[i];
					}
				}

				int minCount = Integer.MAX_VALUE;
				for(int i = 0; i <= 5; ++i){
					int count = 0;
					for(int j = 0; j < N; ++j){
						int V = (arr[j] - (minVal - i));
						count += V/5 + (V %= 5)/2 + (V & 1);
					}
					if (count < minCount){
						minCount = count;
					}
				}

				System.out.println(minCount);
			}
			else {
				System.out.println(0);
			}
		}
	}

}
