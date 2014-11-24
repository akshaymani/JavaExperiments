package com.akshay.exceptions;

import java.util.ArrayList;
import java.util.Random;

public class ExceptionExperiment {

	public static void main(String[] args) {
		int i = 0;
		while(i++ < 10) {
			System.out.println("Ieration i: " + i);
			try {
				Random r = new Random();
				int flag = r.nextInt(1000) % 3;
				if (flag == 0) {
					throw new MyException();
				}
				else if (flag == 1){
					ArrayList<String> listOfErrors = new ArrayList<String>();
					listOfErrors.add("Flag == 1");
					Error error = new Error("Else if flag == 1 Condition",listOfErrors);
					throw new MyException(error);
				}
				else {
					System.out.println("returnException() called: " + returnException());
				}
			} catch (MyException e) {
				System.out.println("Inside Catch Clause");
				e.printStackTrace();
				System.out.println("------------------------------------------------------------------------------------------------");
				System.out.println();
			}
		}
	}

	public static int returnException() throws MyException{
		//try {
			Random r = new Random();
			boolean flag = ((r.nextInt(1000) % 2) == 1 ? true : false);
			if (flag) {
				throw new MyException();
			}
			else {
				ArrayList<String> listOfErrors = new ArrayList<String>();
				listOfErrors.add("Flag turned out to be false");
				Error error = new Error("Else Condition",listOfErrors);
				throw new MyException(error);
			}
	}

}
