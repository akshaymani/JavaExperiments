package com.akshay.interviewQuestions;

import java.util.ArrayList;

public class FindCommonElementsInThreeSortedArrays {

	public static void main(String[] args) {
		
		int[] arr1 = {1, 5, 10, 20, 40, 80};
		int[] arr2 = {6, 7, 20, 80, 100};
		int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
		
		ArrayList<Integer> common = new ArrayList<Integer>();
		
		findCommon(arr1,arr2,arr3,common);
		
	}

	/*
	 * Let the current element traversed in ar1[] be x, in ar2[] be y and in ar3[] be z. We can have following cases inside the loop.
	1) If x, y and z are same, we can simply print any of them as common element and move ahead in all three arrays.
	2) Else If x < y, we can move ahead in ar1[] as x cannot be a common element
	3) Else If y < z, we can move ahead in ar2[] as y cannot be a common element
	4) Else (We reach here when x > y and y > z), we can simply move ahead in ar3[] as z cannot be a common element
	 */
	private static void findCommon(int[] arr1, int[] arr2, int[] arr3,
			ArrayList<Integer> common) {
		int i = 0, j = 0, k = 0;
		
		while (i < arr1.length && j < arr2.length && k < arr3.length) {
			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				common.add(arr1[i]);
				System.out.println(arr1[i]);
				i++; j++; k++;
			}
			else if(arr1[i] < arr2[j]) {
				i++;
			}
			else if(arr2[j] < arr3[k]) {
				j++;
			}
			else {
				k++;
			}
		}
		
	}
	
}
