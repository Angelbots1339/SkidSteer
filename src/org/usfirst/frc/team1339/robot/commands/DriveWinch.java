package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team1339.robot.RobotMap;
/**
 *
 */
public class DriveWinch extends CommandBase {
	private double leftTrigger;
    private double rightTrigger;
    private double control;
    private Joystick stick;
    public Joystick joystick1 = new Joystick(1);
    public DriveWinch() {
        // Use requires() here to declare subsystem dependencies
    	requires(PIDElevator);
    }	

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
        
        rightTrigger = (joystick1.getRawAxis(1))*-1;
        System.out.println(rightTrigger);
        control = rightTrigger-leftTrigger;
        System.out.println(control);
    	
    	
    	PIDElevator.winchDrive(rightTrigger);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
