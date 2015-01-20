package com.akshay.interviewQuestions;

import java.util.Scanner;

class Solution2 {

	public static void main(String[] args) {
		try {
			Scanner userInput = new Scanner(System.in);
			int num1 = 0;
			int num2 = 0;
			if (userInput.hasNext()) {
				int iterations = userInput.nextInt();
				for (int k = 0; k < iterations; k++) {
					if (userInput.hasNext())
						num1 = userInput.nextInt();
					if (userInput.hasNext())
						num2 = userInput.nextInt();
					if (num1 == 0 || num2 == 0) {
						System.out.println("0");
					}
					else {

						String answer = reverseString(multiplyStrings(String.valueOf(num1),String.valueOf(num2)));
						int flag = 0;
						for (int i = 0; i < answer.length(); i++) {
							//System.out.println(answer.charAt(i));
							if (flag==1) {
								System.out.print(answer.charAt(i));
							}
							else if (flag == 0) {
								String digit = String.valueOf(answer.charAt(i));
								if (Integer.parseInt(digit) > 0) {
									flag = 1;
									System.out.print(answer.charAt(i));
								}
							}
						}
						System.out.println();
					}

				}
			}
		}
		catch(Exception e) {

		}


	}

	private static String multiplyStrings(String val1, String val2) {
		int length = maximum(val1.length(),val2.length());
		if (length == val1.length())
			val2 = appendZerosInSmallerString(length,val2);
		else
			val1 = appendZerosInSmallerString(length,val1);

		//System.out.println("val1 : " + val1 + " val2: " + val2 + " Length max: " + length);
		val1 = reverseString(val1);
		val2 = reverseString(val2);
		//System.out.println("val1 : " + val1 + " val2: " + val2 + " Length max: " + length);
		int currentIndex = 0;
		int isum = 0;
		char[] multiply = new char[100000];
		int carryforward = 0;
		for (int left = 0; left < length; left++) {
			for (int right = left; right < length && left == 0; right++) {
				isum = getCrossMultiplyValue(val1,val2,left,right) + carryforward;
				carryforward = isum/10;
				multiply[currentIndex++] = (char) (isum % 10 + 48);
			}
			if (left > 0) {
				isum = getCrossMultiplyValue(val1,val2,left,length-1) + carryforward;
				carryforward = isum/10;
				multiply[currentIndex++] = (char) (isum % 10 + 48);
			}
		}
		for ( ; carryforward > 0 ;) {
			multiply[currentIndex++] = (char) (carryforward % 10 + 48);
			carryforward/=10;
		}
		for( ; currentIndex < 100000 ; currentIndex++) {
			multiply[currentIndex] = '0';
		}

		return new String(multiply);
	}

	private static String reverseString(String s) {
		int length = s.length();
		char[] val = new char[length];
		for (int i = 0 ; i < length ; i++) {
			val[length-i-1] = s.charAt(i);
		}
		return new String(val);
	}

	private static int getCrossMultiplyValue(String val1, String val2, int left, int right) {
		int isum = 0;
		for ( ; left < right; ) {
			isum += Integer.parseInt(String.valueOf(val1.charAt(left)))*Integer.parseInt(String.valueOf(val2.charAt(right)));
			isum += Integer.parseInt(String.valueOf(val1.charAt(right)))*Integer.parseInt(String.valueOf(val2.charAt(left)));
			left++;
			right--;
		}
		if (left == right) {
			isum += Integer.parseInt(String.valueOf(val1.charAt(left)))*Integer.parseInt(String.valueOf(val2.charAt(left)));
		}
		return isum;
	}

	private static String appendZerosInSmallerString(int length, String val) {
		char[] zeros = new char[length-val.length()];
		for (int i = 0; i < length-val.length(); i++) {
			zeros[i] = '0';
		}
		return (new String(zeros)) + val;
	}

	private static int maximum(int length, int length2) {
		return length > length2 ? length : length2;
	}


}
