package com.akshay.designPatterns.AdapterDesign;

public interface EnemyRobotInterface {

	public abstract void smashWithHands();

	public abstract void walkForward();

	public abstract void reactToHuman(String driverName);

}