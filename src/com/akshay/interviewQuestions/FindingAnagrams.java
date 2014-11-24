package com.akshay.interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class FindingAnagrams {

	public static void main(String[] args) {
		HashMap<String,ArrayList<String>> groupAnagrams = new HashMap<String,ArrayList<String>>();
		String[] vals = {"cat", "dog", "tac", "god", "act"};
		for (int i = 0; i < vals.length; i++) {
			String hashVal = sortLetters(vals[i]);
			System.out.println(hashVal);
			addAnagramToMap(groupAnagrams,hashVal,vals[i]);
		}
		
		printAnagramMap(groupAnagrams);
	}

	private static void printAnagramMap(
			HashMap<String, ArrayList<String>> groupAnagrams) {
		Set<String> keyHashVals = groupAnagrams.keySet();
		for (String s: keyHashVals) {
			ArrayList<String> anagrams = groupAnagrams.get(s);
			System.out.print("HashValue: " + s + " -> ");
			for (int i = 0; i < anagrams.size(); i++) {
				System.out.print(anagrams.get(i)+ " ");
			}
			System.out.println();
		}
	}

	private static void addAnagramToMap(
			HashMap<String, ArrayList<String>> groupAnagrams, String hashVal,
			String string) {
		Set<String> keyHashVals = groupAnagrams.keySet();
		boolean match = false;
		for (String s: keyHashVals) {
			if (s.equals(hashVal)) {
				ArrayList<String> anagrams = groupAnagrams.get(hashVal);
				anagrams.add(string);
				groupAnagrams.put(hashVal, anagrams);
				match = true;
				break;
			}
		}
		if (match == false) {
			ArrayList<String> anagrams = new ArrayList<String>();
			anagrams.add(string);
			groupAnagrams.put(hashVal, anagrams);
		}
	}

	private static String sortLetters(String string) {
		char[] letters = string.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
}
