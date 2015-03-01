package com.akshay.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IDEIdentifyingComments {
	
	public static void main(String[] args) throws IOException {
		InputStreamReader inputReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputReader);
		StringBuilder str = new StringBuilder();
		//int N = 5;
		String temp = "";
		while (true) {
			temp = br.readLine();
			if (temp == null) break;
			str.append(temp).append('\n');
		}
		
		String input = str.toString();
		//System.out.println(input);
		int length = input.length();
		boolean flag = false;
		boolean singleLineComment = false;
		int multiLineComment = 0;
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < length;) {
			
			if (singleLineComment == true && input.charAt(i) == '\n') {
				singleLineComment = false;
				output.append(Character.toString('\n'));
				i++;
			}
			
			else if (input.charAt(i) == '/' && i+1 < length && input.charAt(i+1) == '/') {
				singleLineComment = true;
				output.append(Character.toString(input.charAt(i)));
				output.append(Character.toString(input.charAt(i+1)));
				i+=2;
			}
			
			else if (input.charAt(i) == '/' && i+1 < length && input.charAt(i+1) == '*') {
				output.append(Character.toString(input.charAt(i)));
				output.append(Character.toString(input.charAt(i+1)));
				multiLineComment = 1;
				flag = true;
				i+=2;
			}
			
			else if (input.charAt(i) == '/' && i+1 < length && input.charAt(i+1) == '*' && 
					i+2 < length && input.charAt(i+2) == '*') {
				output.append(Character.toString(input.charAt(i)));
				output.append(Character.toString(input.charAt(i+1)));
				output.append(Character.toString(input.charAt(i+2)));
				multiLineComment = 2;
				flag = true;
				i+=3;
			}
			
			else if (multiLineComment == 1 && input.charAt(i) == '*' && 
					i+1 < length && input.charAt(i+1) == '/') {
				multiLineComment = 0;
				output.append(Character.toString(input.charAt(i)));
				output.append(Character.toString(input.charAt(i+1)));
				flag = false;
				i+=2;
			}
			
			else if (multiLineComment == 2 && input.charAt(i) == '*' 
					&& i+1 < length && input.charAt(i+1) == '*'
					&&  i+2 < length && input.charAt(i+2) == '/') {
				multiLineComment = 0;
				output.append(Character.toString(input.charAt(i)));
				output.append(Character.toString(input.charAt(i+1)));
				output.append(Character.toString(input.charAt(i+2)));
				flag = false;
				i+=3;
			}
			
			else if (multiLineComment == 2 && input.charAt(i) == '*' 
					&& i+1 < length && input.charAt(i+1) == '/') {
				multiLineComment = 0;
				output.append(Character.toString(input.charAt(i)));
				output.append(Character.toString(input.charAt(i+1)));
				flag = false;
				i+=2;
			}
			
			else if (flag == true || singleLineComment == true) {
				output.append(Character.toString(input.charAt(i)));
				i++;
			}
			
			else if (flag == false && input.charAt(i) == '\n') {
				output.append(Character.toString('\n'));
				i++;
			}
			else {
				i++;
			}
			
		}
		
		String answer = output.toString();
		StringBuilder removeNewLine = new StringBuilder();  
		for (int i = 0; i < answer.length();) {
			if (i == 0 && answer.charAt(i) == '\n')
				i++;
			else if (answer.charAt(i) == '\n') {
				while(i < answer.length() && answer.charAt(i) == '\n') {
					i++;
				}
				removeNewLine.append(Character.toString('\n'));
			}
			else {
				removeNewLine.append(Character.toString(answer.charAt(i++)));
			}
		}
		
		System.out.print(removeNewLine.toString());
	}

}
