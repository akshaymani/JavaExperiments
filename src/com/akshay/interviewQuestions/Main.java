package com.akshay.interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Here is the problem:
 * Write a function that given a list of non negative integers, arranges them such 
 * that they form the largest possible number. 
 * For example, given [50, 2, 1, 9], the largest formed number is 95021.
 */
public class Main {

    private static Integer[] VALUES = { 5, 2, 1, 9, 50, 56 };

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        Arrays.sort(VALUES, new Comparator() {
        	
			@Override
			public int compare(Object lhs, Object rhs) {
				String v1 = lhs.toString();
                String v2 = rhs.toString();
                System.out.println("v1 + v2 :" + (v1 + v2) + " v2 + v1 :" + (v2 + v1));
                return (v1 + v2).compareTo(v2 + v1) * -1;
			}
        });

        String result = "";
        for (Integer integer : VALUES) {
            result += integer.toString();
        }

        System.out.println(result);
    }   
} 
