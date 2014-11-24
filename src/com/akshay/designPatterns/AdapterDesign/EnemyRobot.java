package com.akshay.designPatterns.AdapterDesign;

import java.util.Random;

// This is called the Adaptee
public class EnemyRobot implements EnemyRobotInterface {

	Random generator = new Random();

	// All the methods below don't work as per the EnemyAttacker Interface
	// So, lets create a adapter class - EnemyRobotAdapter
	
	/* (non-Javadoc)
	 * @see com.akshay.designPatterns.AdapterDesign.EnemyRobotInterface#smashWithHands()
	 */
	@Override
	public void smashWithHands() {
		int attackDamage = generator.nextInt(10) + 1;
		System.out.println("Enemy Robot Causes: " + attackDamage + " Damage With Its Hands");
	}
	
	/* (non-Javadoc)
	 * @see com.akshay.designPatterns.AdapterDesign.EnemyRobotInterface#walkForward()
	 */
	@Override
	public void walkForward() {
		int movement = generator.nextInt(5) + 1;
		System.out.println("Enemy Robot Walks Forward " + movement + " Spaces");
	}
	
	/* (non-Javadoc)
	 * @see com.akshay.designPatterns.AdapterDesign.EnemyRobotInterface#reactToHuman(java.lang.String)
	 */
	@Override
	public void reactToHuman(String driverName) {
		System.out.println("Enemy Robot Tramps on " + driverName);
	}
	
	public static void interfaceExperiment() {
		System.out.println("Inside interfaceExperiment method");
	}
	
}
