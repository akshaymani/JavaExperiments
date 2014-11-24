package com.akshay.exceptions;

import java.util.ArrayList;

public class MyException extends Exception {

	/**
	 * Dont know what this serialVersionID does ?
	 */
	private static final long serialVersionUID = 1L;
	private Error error;
	
	public MyException() {
		ArrayList<String> errorDetails = new ArrayList<String>();
		errorDetails.add("Default Error Details");
		this.error = new Error("Default id",errorDetails);
	}
	
	public MyException(Error error) {
		this.error = new Error(error.getErrorId(),(ArrayList<String>) error.getErrorDetails());
	}
	
	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		System.out.println("Inside getMessage() of MyException class");
		return super.getMessage();
	}

	@Override
	public String getLocalizedMessage() {
		System.out.println("Inside getLocalizedMessage() of MyException class");
		return super.getLocalizedMessage();
	}

	@Override
	public String toString() {
		System.out.println("Inside toString() of MyException class");
		return super.toString();
	}

	@Override
	public void printStackTrace() {
		System.out.println("Inside PrintStackTrace of MyException class: " + error.toString());
		super.printStackTrace();
	}

}
