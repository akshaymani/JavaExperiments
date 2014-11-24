package com.akshay.arrayQuestions;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Given a number whose digits are unique, find the next larger number that can be formed with those digits.
 */

// 1) Largest Possible No that can be formed is if all digits are in decreasing order from left to right
// 2) Finding the first decreasing sequence from the right side and trying to rearrange the digits

public class MakeLargerNumber {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			String no = String.valueOf(num);
			int length = no.length();
			int index = returnAscendingToDescendingShiftLocation(no,length);
			if (index != -1) { // here i am swapping the elements that adjacent at point of change 
				// but instead i have to swap with the next greater element in rest of array
				// example 1834952 will give output as per my solution 1839425 while correct answer is 1835249
				if (length == 2) 
					System.out.println(no.substring(0, index) + String.valueOf(no.charAt(index+1)) + String.valueOf(no.charAt(index)));
				else
					System.out.println(no.substring(0, index) + String.valueOf(no.charAt(index+1)) + String.valueOf(no.charAt(index)) + sortCharacters(no.substring(index+2, length)));
			}
			else {
				System.out.println("Length of String is zero or one or This is the maximum no that can be formed with these digits");
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static String sortCharacters(String string) {
		char[] digits = string.toCharArray();
		Arrays.sort(digits);
		return String.valueOf(digits);
	}

	private static int returnintegerDigitAtIndex(String no,int index) {
		return Integer.parseInt(String.valueOf(no.charAt(index)));
	}

	// 4567823432
	private static int returnAscendingToDescendingShiftLocation(String no,
			int length) {
		if (length == 0 || length == 1) return -1;
		int val1 = returnintegerDigitAtIndex(no, length-1);
		int val2 = 0;
		for (int i = length-2; i >=0; i--) {
			val2 = returnintegerDigitAtIndex(no, i);
			if (val2 < val1)
				return i;
			val1 = val2;
		}
		return -1;
	}

}
