package com.akshay.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Error {

	private String errorId;
	private List<String> errorDetails;
	
	public Error(String id, ArrayList<String> errorDetails) {
		setErrorId(id);
		setErrorDetails(errorDetails);
	}
	
	public List<String> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<String> errorDetails) {
		this.errorDetails = errorDetails;
	}
	public String getErrorId() {
		return errorId;
	}
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	@Override
	public String toString() {
		return "Error [errorId=" + errorId + ", errorDetails=" + errorDetails
				+ "]";
	}
	
}
