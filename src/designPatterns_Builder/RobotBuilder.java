package designPatterns_Builder;

public interface RobotBuilder {
	public void buildRobotHead();
	public void buildRobotTorso();
	public void buildRobotArms();
	public void buildRobotLegs();
	public Object getRobot();
}
