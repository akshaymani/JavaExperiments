package com.akshay.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class MrKMarsh {

	private static char MARSH = 'x';
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		HashMap<Integer,TreeSet<Integer>> marshLand = new HashMap<Integer,TreeSet<Integer>>();
		String line = scanner.nextLine();
		for (int i = 0; i < n; i++) {
			line = scanner.nextLine();
			for (int j = 0; j < m; j++) {
				if (line.charAt(j) == MARSH) {
					TreeSet<Integer> marshColumns = marshLand.get(i);
					if (marshColumns == null) {
						marshColumns = new TreeSet<Integer>(); 
					}
					marshColumns.add(j);
					marshLand.put(i, marshColumns);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) { // Upper Pointer for Row
			for (int j = i+1; j < n; j++) { // Down Pointer for Row
				for (int k = 0; k < m; k++) { // Left Pointer for Column
					for (int l = k+1; l < m ; l++) { // Right Pointer for Column
						if ((2*(j-i)) + (2*(l-k)) > max && isFencePossible(i,j,k,l,marshLand)) {
							max = (2*(j-i)) + (2*(l-k));
						}
					}
				}
			}
		}
		
		if (max == Integer.MIN_VALUE) {
			System.out.println("impossible");
		}
		else {
			System.out.println(max);
		}
		
	}

	private static boolean isFencePossible(int up, int down, int left, int right,
			HashMap<Integer, TreeSet<Integer>> marshLand) {
		for (int i = up; i <= down; i++) {
			if (marshLand.get(i) != null && (marshLand.get(i).contains(left) || marshLand.get(i).contains(right))) 
				return false;
		}
		TreeSet<Integer> upColumn = marshLand.get(up);
		if (upColumn != null) {
			for (int i = left; i <= right; i++) {
				if (upColumn.contains(i)) {
					return false;
				}
			}
		}
		
		TreeSet<Integer> downColumn = marshLand.get(down);
		if (downColumn != null) {
			for (int i = left; i <= right; i++) {
				if (downColumn.contains(i)) {
					return false;
				}
			}
		}
		return true;
	}
	
}
