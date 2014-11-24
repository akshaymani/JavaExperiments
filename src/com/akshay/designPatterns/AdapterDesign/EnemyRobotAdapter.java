package com.akshay.designPatterns.AdapterDesign;

public class EnemyRobotAdapter implements EnemyAttacker {

	EnemyRobotInterface theRobot;
	
	public EnemyRobotAdapter(EnemyRobotInterface newRobot) {
		theRobot = newRobot;
	}
	
	@Override
	public void fireWeapon() {
		theRobot.smashWithHands();
	}

	@Override
	public void driveForward() {
		theRobot.walkForward();
	}

	@Override
	public void assignDriver(String driverName) {
		theRobot.reactToHuman(driverName);
	}

}
