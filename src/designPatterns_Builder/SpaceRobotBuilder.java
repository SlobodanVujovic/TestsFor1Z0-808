package designPatterns_Builder;

public class SpaceRobotBuilder implements RobotBuilder{
	
	private SpaceRobot sRobot;
	
	public SpaceRobotBuilder() {
		sRobot = new SpaceRobot();
	}
	@Override
	public void buildRobotHead() {
		sRobot.setRobotHead("Carbon head");
	}
	@Override
	public void buildRobotTorso() {
		sRobot.setRobotTorso("Carbon torso");
	}
	@Override
	public void buildRobotArms() {
		sRobot.setRobotArms("Carbon arms");
	}
	@Override
	public void buildRobotLegs() {
		sRobot.setRobotLegs("Carbon legs");
	}
	@Override
	public SpaceRobot getRobot() {
		return sRobot;
	}
}
