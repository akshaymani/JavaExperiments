package com.akshay.designPatterns.AdapterDesign;

// This is what the client will be working with

public interface EnemyAttacker {

	public void fireWeapon();
	public void driveForward();
	public void assignDriver(String driverName);
	
}
