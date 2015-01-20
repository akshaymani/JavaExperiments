package com.akshay.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BiggerIsGreater {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		String word = null;
		boolean flag = false;
		while (N-- > 0) {
			word = scanner.nextLine();
			int len = word.length();
			if (len >= 2) {
				flag = false;
				int lVal = (int) word.charAt(len - 1);
				for (int i = len - 2; i >= 0 ; i--) {
					int nVal = (int) word.charAt(i);
					if (nVal < lVal) {
						int fIndex = findIndexofNextBiggerChar(word,i,len);
						Character[] arr = new Character[len - i - 1];
						int index = 0;
						arr[index++] = (char) nVal;
						for (int j = i + 1; j < len; j++) {
							if (j != fIndex) {
								arr[index++] = word.charAt(j); 
							}
						}
						Arrays.sort(arr);
						String nWord = word.substring(0,i) + word.charAt(fIndex) + makeString(arr);
						System.out.println(nWord);
						flag = true;
						break;
					}
					else {
						lVal = nVal;
					}
				}
				if (flag == false) {
					System.out.println("no answer");
				}
			}
			else {
				System.out.println("no answer");
			}
		}
	}

	private static int findIndexofNextBiggerChar(String word, int i, int len) {
		int val = (int) word.charAt(i);
		int mVal = Integer.MAX_VALUE;
		int nIndex = i + 1;
		for (int m = i + 1; m < len; m++) {
			int x = (int) word.charAt(m);
			if (x > val && x < mVal) {
				mVal = x;
				nIndex = m;
			}
		}
		return nIndex;
	}

	private static String makeString(Character[] arr) {
		char[] nArr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nArr[i] = arr[i];
		}
		return new String(nArr);
	}

}
