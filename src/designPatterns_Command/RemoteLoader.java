package designPatterns_Command;

public class RemoteLoader {

	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();

		Light light = new Light("Living Room");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		Stereo stereo = new Stereo("Living Room");

		LightOnCommand lightOn = new LightOnCommand(light);
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);

		LightOffCommand lightOff = new LightOffCommand(light);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		CeilingFanOffCommand ceilingOff = new CeilingFanOffCommand(ceilingFan);

		Command[] partyOn = { lightOn, stereoOnWithCD, ceilingFanMedium };
		Command[] partyOff = { lightOff, stereoOff, ceilingOff };

		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);

		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);
		System.out.println("--- Pushing Macro Undo---");
		remoteControl.undoButtonWasPushed();
	}
}
