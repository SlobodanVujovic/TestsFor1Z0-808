package designPatterns_Builder;

public class testRobotBuilder {
	public static void main(String[] args){
		RobotBuilder spaceRobotSpec = new SpaceRobotBuilder();
		RobotEngineer robotEngineer = new RobotEngineer(spaceRobotSpec);
		robotEngineer.makeRobot();
		SpaceRobot spaceRobot = robotEngineer.getRobot();
		System.out.println("Space robot caracteristics");
		System.out.println("Head: " + spaceRobot.getRobotHead());
		System.out.println("Torso: " + spaceRobot.getRobotTorso());
		System.out.println("Arms: " + spaceRobot.getRobotArms());
		System.out.println("Legs: " + spaceRobot.getRobotLegs());
	}
}
