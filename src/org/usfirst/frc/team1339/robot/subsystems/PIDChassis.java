package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDChassis extends PIDSubsystem {
	
	private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    CANTalon leftFront, leftBack, rightFront, rightBack;

    // Initialize your subsystem here
    public PIDChassis() {
        super("PIDChassis", Kp, Ki, Kd);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        
        leftFront = new CANTalon(RobotMap.leftFrontSRX);
        leftBack = new CANTalon(RobotMap.leftBackSRX);
        rightFront = new CANTalon(RobotMap.rightFrontSRX);
        rightBack = new CANTalon(RobotMap.rightBackSRX);

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    public void driveWithJoystick(double leftValue, double rightValue) {
    	setLeftRight(leftValue, rightValue);
    }
    
    private void setLeftRight(double leftSpeed, double rightSpeed){
    	leftFront.set(leftSpeed);
    	leftBack.set(leftSpeed);
    	rightFront.set(rightSpeed);
    	rightBack.set(rightSpeed);
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
