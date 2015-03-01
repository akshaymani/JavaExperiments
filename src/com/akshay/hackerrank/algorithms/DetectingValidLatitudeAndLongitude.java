package com.akshay.hackerrank.algorithms;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectingValidLatitudeAndLongitude {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		while (N-- > 0) {
			String line = scanner.nextLine();
			Pattern pattern = Pattern.compile("[(]([+]|[-])?[0-9.]+, ([+]|[-])?[0-9.]+[)]");
			Matcher matcher = pattern.matcher(line);
			boolean flag = false;
			if (matcher.matches()) {
				int index = matcher.start();
				String[] temp = line.substring(index+1, line.length()-1).split(",");
				boolean flag1 = validate(temp[0],90.0);
				boolean flag2 = flag1 ? validate(temp[1],180.0) : false;
				if (flag1 == true && flag2 == true)
					flag = true;
				//System.out.println(index);
			}
			
			if (flag == true)
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		}
	}

	private static boolean validate(String str, double limit) {
		boolean flag = true;
		
		boolean plus = true;
		if (str.charAt(0) == '+')
			plus = true;
		else if (str.charAt(0) == '-')
			plus = false;
		
		if (str.charAt(0) == '+' || str.charAt(0) == '-')
			str = str.substring(1);
		if (str.charAt(0) == '0' || str.charAt(str.length()-1) == '.')
			return false;
		try {
			double val = Double.parseDouble(str);
			if (plus == false)
				val *= -1;
			if (!((-1)*limit <= val && val <= limit))
				flag = false;
		}
		catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
}
