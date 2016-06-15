package designPatterns_Builder;

public class RobotEngineer {
	
	private RobotBuilder robotBuilder;
	
	public RobotEngineer(RobotBuilder robotBuilder){
		this.robotBuilder = robotBuilder;
	}
	public SpaceRobot getRobot(){
		return (SpaceRobot) robotBuilder.getRobot();
	}
	public void makeRobot(){
		robotBuilder.buildRobotHead();
		robotBuilder.buildRobotTorso();
		robotBuilder.buildRobotArms();
		robotBuilder.buildRobotLegs();
	}
}
