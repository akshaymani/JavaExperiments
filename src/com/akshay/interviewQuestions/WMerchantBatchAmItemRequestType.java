package com.akshay.interviewQuestions;

public enum WMerchantBatchAmItemRequestType {

	WMERCHANT_BATCH_AM_ITEM_REQUEST_TYPE_CREATE_ACCOUNT ('C'),
	WMERCHANT_BATCH_AM_ITEM_REQUEST_TYPE_MANAGE_ACCOUNT ('M');
	
	private char wmerchatnBatchAmItemRequestType;
	
	private WMerchantBatchAmItemRequestType(char requestType) {
		this.wmerchatnBatchAmItemRequestType = requestType;
	}

	public char getWmerchatnBatchAmItemRequestType() {
		return wmerchatnBatchAmItemRequestType;
	}
	
	public static void main(String[] args) {
		System.out.println(WMerchantBatchAmItemRequestType.WMERCHANT_BATCH_AM_ITEM_REQUEST_TYPE_CREATE_ACCOUNT.getWmerchatnBatchAmItemRequestType());
	}
	
}

