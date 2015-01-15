package org.usfirst.frc.team1339.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static int JOYSTICK_PORT = 0;
	public static int BUTTON_A = 0;
	public static int BUTTON_B = 1;
	public static int BUTTON_X = 2;
	public static int BUTTON_Y = 3;
	
	//1 is left stick x-axis, 2 is left stick y-axis
    //3 is right stick x-axis, 4 is right stick y-axis
	public static int LEFT_X_AXIS = 0;
	public static int LEFT_Y_AXIS = 1;
	public static int RIGHT_X_AXIS = 4;
	public static int RIGHT_Y_AXIS = 5;

	//CAN ID's
	public static int LEFT_FRONT_SRX = 0;
	public static int LEFT_BACK_SRX = 1;
	public static int RIGHT_FRONT_SRX = 2;
	public static int RIGHT_BACK_SRX = 3;
	public static int ELEV_TALON = 4;
	
	//Analog Ports
	public static int POTENTIOMETER_PORT = 0;
}
