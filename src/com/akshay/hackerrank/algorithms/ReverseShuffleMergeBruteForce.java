package com.akshay.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReverseShuffleMergeBruteForce {
	
	public static class ReverseShuffle {
		String reverse;
		String shuffle;
		
		public ReverseShuffle(IndexList indexes, String merged, int mergedLength) {
			StringBuilder rev = new StringBuilder();
			StringBuilder shuffle = new StringBuilder();
			for (int i = 0; i < mergedLength; i++) {
				if (indexes.getIndexList().contains(i))
					rev.append(Character.toString(merged.charAt(i)));
				else
					shuffle.append(Character.toString(merged.charAt(i)));
			}
			this.reverse = rev.toString();
			this.shuffle = shuffle.toString();
		}
		
		public static String getReversedString(String str) {
			StringBuilder reverse = new StringBuilder();
			for (int i = str.length() - 1; i >= 0; i--) {
				reverse.append(Character.toString(str.charAt(i)));
			}
			return reverse.toString();
		}
		
		public static boolean isShuffle(String reverse, String shuffle) {
			char[] rev = reverse.toCharArray();
			char[] shuf = shuffle.toCharArray();
			Arrays.sort(rev);
			Arrays.sort(shuf);
			for (int i = 0; i < rev.length; i++) {
				if (rev[i] != shuf[i]) {
					return false;
				}
			}
			return true;
		}
	}

	public static class IndexList {
		ArrayList<Integer> indexes;
		
		public IndexList() {
			this.indexes = new ArrayList<Integer>();
		}
		
		public IndexList(ArrayList<Integer> indexes) {
			this.indexes = new ArrayList<Integer>();
			for (int i = 0; i < indexes.size(); i++) {
				this.indexes.add(indexes.get(i));
			}
		}
		
		public int size() {
			return this.indexes.size();
		}
		
		public void add(int index) {
			if (null == this.indexes) {
				this.indexes = new ArrayList<Integer>();
			}
			this.indexes.add(index);
		}
		
		public ArrayList<Integer> getIndexList() {
			return this.indexes;
		}
		
		public void printIndexes() {
			if (null != this.indexes) {
				for (int i = 0; i < this.size(); i++)
					System.out.print(this.indexes.get(i) + " ");
				System.out.println();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String merged = scanner.nextLine();
		int mergedLen = merged.length();
		int originalLen = mergedLen/2;
		IndexList indexes = new IndexList();
		ArrayList<String> allPossibleAnswers = new ArrayList<String>();
		generateCombinations(merged,0,0,originalLen,indexes,allPossibleAnswers);
		
		Collections.sort(allPossibleAnswers);
		System.out.println(allPossibleAnswers.get(0));
		/*for (int i = 0; i < allPossibleAnswers.size(); i++)
			System.out.println(allPossibleAnswers.get(i));*/
	}

	private static void generateCombinations(String merged, int start,
			int filled, int originalLen, IndexList indexes,
			ArrayList<String> allPossibleAnswers) {
		if (filled == originalLen) {
			ReverseShuffle tempV = new ReverseShuffle(indexes, merged, merged.length());
			if (ReverseShuffle.isShuffle(tempV.reverse, tempV.shuffle)) {
				allPossibleAnswers.add(ReverseShuffle.getReversedString(tempV.reverse));
			}
			return;
		}
		
		for (int i = start; i < merged.length() - originalLen + filled + 1; i++) {
			IndexList tempIndexes = new IndexList(indexes.getIndexList());
			tempIndexes.add(i);
			generateCombinations(merged, i + 1, filled + 1, originalLen, tempIndexes, allPossibleAnswers);
		}
		
		return;
	}

}
