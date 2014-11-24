package com.akshay.designPatterns.MVCDesign;

public class CalculatorModel {

	private int calculationVal;
	
	public void addTwoNumbers(int firstNumber, int secondNumber) {
		calculationVal = firstNumber + secondNumber;
	}
	
	public int getCalculationValue() {
		return this.calculationVal;
	}
	
}
