package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1339.robot.RobotMap;
/**
 *
 */
public class DriveWinch extends CommandBase {
	private double leftTrigger;
    private double rightTrigger;
    private Joystick stick;

    public DriveWinch() {
        // Use requires() here to declare subsystem dependencies
    	requires(PIDElevator);
    }	

    // Called just before this Command runs the first time
    protected void initialize() {
    	stick = oi.getJoystick();
        leftTrigger = stick.getRawAxis(RobotMap.LEFT_TRIGGER);
        rightTrigger = stick.getRawAxis(RobotMap.RIGHT_TRIGGER);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDElevator.winchDrive(1);
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
