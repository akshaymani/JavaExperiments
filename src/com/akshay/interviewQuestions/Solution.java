package com.akshay.interviewQuestions;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();*/
		//System.out.println(n);
		//System.out.println(getIntegerComplement(n));
		/*int[] arr = {18,11,21,28,31,38,40,55,60,62};
		System.out.println(isSumPossible(arr,66));*/
	}
	
	private static int numberOfPaths(int [][]a,int m,int n) {
		HashMap<Integer,ArrayList<Integer>> visited = new HashMap<Integer,ArrayList<Integer>>();
		return numofPaths(a,m,n,0,0,visited);
	}
	
	private static int numofPaths(int[][] a, int m, int n, int i, int j, HashMap<Integer, ArrayList<Integer>> visited) {
		if (i == m && j == n) 
			return 1;
		ArrayList<Integer> visitedColumns = visited.get(i);
		if (visitedColumns.contains(j))
			return 0;
		else {
			visitedColumns.add(j);
			visited.put(i, visitedColumns);
		}
		if (a[i][j] == 0)
			return 0;
        else
            return numofPaths(a,m,n,i+1,j, visited) + numofPaths(a, m, n, i, j+1, visited) + 1;
	}

	private static int isSumPossible(int[] a, int N) { 
		for (int i = 0 ; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i != j) {
					if (a[i] + a[j] == N)
						return 1;
				}
			}
		}
		return 0;
    }
	
	
	/*private static int getIntegerComplement(int n) {
		int temp = n;
		String binary = "";
		for (; temp>0; temp/=2) {
			int val = temp%2;
			if (val == 0)
				binary = binary + '1';
			else
				binary = binary + '0';
		}
		//System.out.println(binary);
		
		int len = binary.length();
		int num = 0;
		int t = 1;
		for (int i = 0; i < len; i++) {
			num = num + Integer.parseInt(String.valueOf(binary.charAt(i))) * t;
			t = t*2;
		}
		
		return num;
	}*/
	
}
