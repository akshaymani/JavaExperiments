package com.akshay.designPatterns.AdapterDesign;

public class TestEnemyAttackers {

	public static void main(String[] args) {

		EnemyTank rx7Tank = new EnemyTank();

		EnemyRobotInterface fredTheRobot = new EnemyRobot();

		EnemyAttacker robotAdapter = new EnemyRobotAdapter(fredTheRobot);

		System.out.println("The Robot");

		fredTheRobot.reactToHuman("Paul");
		fredTheRobot.walkForward();
		fredTheRobot.smashWithHands();
		System.out.println("fredTheRobot toString(): " + fredTheRobot.toString());

		System.out.println("The Tank");

		new Thread();
		rx7Tank.assignDriver("Frank");
		rx7Tank.driveForward();
		rx7Tank.fireWeapon();
		
		System.out.println("The Robot with Adapter");
		
		robotAdapter.assignDriver("Mark");
		robotAdapter.driveForward();
		robotAdapter.fireWeapon();

	}

}
