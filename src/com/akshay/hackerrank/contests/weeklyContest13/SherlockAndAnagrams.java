package com.akshay.hackerrank.contests.weeklyContest13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SherlockAndAnagrams {

	private static class Pair {
		private int X;
		private int Y;
		
		public Pair(int x, int y) {
			setX(x);
			setY(y);
		}

		public int getX() {
			return X;
		}

		public void setX(int x) {
			X = x;
		}

		public int getY() {
			return Y;
		}

		public void setY(int y) {
			Y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		String word = "";
		int slen = 0;
		int count = 0;
		String sub = "";
		while (T-- > 0) {
			word = scanner.nextLine();
			slen = word.length();
			count = 0;
			
			HashMap<String,ArrayList<Pair>> mapOfAnagrams = new HashMap<String,ArrayList<Pair>>(); 
			for (int i = 0; i < slen; i++) {
				for (int j = 1; j <= slen - i; j++) {
					sub = sortedString(word.substring(i,i+j));
					if (mapOfAnagrams.containsKey(sub)) {
						ArrayList<Pair> listOfPairs = mapOfAnagrams.get(sub);
						listOfPairs.add(new Pair(i, i + j - 1));
					}
					else {
						ArrayList<Pair> listOfPairs = new ArrayList<Pair>();
						listOfPairs.add(new Pair(i, i + j -1));
						mapOfAnagrams.put(sub, listOfPairs);
					}
				}
			}
			
			Set<String> keys = mapOfAnagrams.keySet();
			
			for (String key: keys) {
				int n = mapOfAnagrams.get(key).size();
				count += n*(n-1)/2;
			}
			
			System.out.println(count);
		}
	}
	
	public static String sortedString(String original) {
		char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
	}

}
