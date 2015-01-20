package com.akshay.hackerrank.algorithms;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MakeItAnagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str1 = scanner.next();
		String str2 = scanner.next();
		HashMap<Character,Integer> countofCharsOne = getHashMap(str1);
		HashMap<Character,Integer> countofCharsTwo = getHashMap(str2);
		System.out.println(compareHashMap(countofCharsOne,countofCharsTwo));		
		
	}

	private static int compareHashMap(
			HashMap<Character, Integer> countofCharsOne,
			HashMap<Character, Integer> countofCharsTwo) {
		int diff = 0;
		Set<Character> keys = countofCharsOne.keySet();
		for (char c: keys) {
			if (null != countofCharsTwo.get(c)) {
				diff += absoluteVal(countofCharsOne.get(c) - countofCharsTwo.get(c));
			}
			else {
				diff += countofCharsOne.get(c);
			}
		}
		
		Set<Character> keysTwo = countofCharsTwo.keySet();
		for (char c: keysTwo) {
			if (null == countofCharsOne.get(c)) {
				diff += countofCharsTwo.get(c);
			}
		}
		return diff;
	}

	private static int absoluteVal(Integer a) {
		return (a > 0) ? a : -a;
	}

	private static HashMap<Character, Integer> getHashMap(String str) {
		HashMap<Character,Integer> countofChars = new HashMap<Character,Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (countofChars.containsKey(str.charAt(i))) {
				countofChars.put(str.charAt(i), countofChars.get(str.charAt(i)) + 1);
			}
			else {
				countofChars.put(str.charAt(i), 1);
			}
		}
		return countofChars;
	}
	
}
