package com.akshay.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MissingNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String one = scanner.nextLine();
		HashMap<Integer,Integer> mapOne = fillMap(n,one);
		int m = Integer.parseInt(scanner.nextLine());
		String two = scanner.nextLine();
		HashMap<Integer,Integer> mapTwo = fillMap(m,two);	
		
		Set<Integer> keysOne = mapOne.keySet();
		for (int a: keysOne) {
			if (mapTwo.containsKey(a)) {
					mapTwo.put(a, mapTwo.get(a)-mapOne.get(a));
			}
		}
		
		Map<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(mapTwo);
		Set<Integer> keysTwo = sortedMap.keySet();
		for (int a: keysTwo) {
			if (sortedMap.get(a) > 0) {
				System.out.print(a + " ");
			}
		}
		System.out.println();
	}

	private static HashMap<Integer, Integer> fillMap(int n, String line) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		String[] arr = line.split(" ");
		//System.out.println(line);
		//System.out.println(arr.length);
		int val = 0;
		for (int i = 0; i < n; i++) {
			val = Integer.parseInt(arr[i]);
			//System.out.print(val + " ");
			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			}
			else {
				map.put(val, 1);
			}
		}
		return map;
	}
		
}
