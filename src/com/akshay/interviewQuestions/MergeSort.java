package com.akshay.interviewQuestions;

public class MergeSort {

	public static void main(String[] args) {
		int[] num = new int[] {45,23,11,89,77,98,4,28,65,43};
		System.out.println("Input Array");
		printArray(num);
		mergeSort(num);
		System.out.println("Sorted Array");
		printArray(num);
	}

	private static void printArray(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	private static void mergeSort(int[] num) {
		int length = num.length;
		if (length == 0 || length == 1) return;
		int[] helper = new int[length];
		//printArray(helper);
		mergeSort(num,helper,0,length-1);
	}

	private static void mergeSort(int[] num,int[] helper,int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(num,helper,low, middle);
			mergeSort(num,helper,middle + 1, high);
			merge(low,middle,high,num,helper);
		}
		return;
	}

	private static void merge(int low, int middle, int high,int[] num, int[] helper) {
		//printArray(num);
		//printArray(helper);
		for (int i = low; i <= high; i++) {
			helper[i] = num[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				num[k] = helper[i];
				i++;
			}
			else {
				num[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle) {
			num[k] = helper[i];
			i++;
			k++;
		}
		
		while (j <= high) {
			num[k] = helper[j];
			k++;
			j++;
		}
	}
	
}
