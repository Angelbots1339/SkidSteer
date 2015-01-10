/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team1339.robot.RobotMap;

/**
 *
 * @author Chad
 */


public class DriveWithJoystick extends CommandBase {
    private double leftAxis;
    private double rightAxis;
    private Joystick stick;

    
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(PIDChassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
	protected void execute() {
        stick = oi.getJoystick();
        leftAxis = stick.getRawAxis(RobotMap.LEFT_Y_AXIS);
        rightAxis = stick.getRawAxis(RobotMap.RIGHT_Y_AXIS);
        
        //Exponential Gain
        leftAxis = (leftAxis)*(leftAxis)*(leftAxis);
        rightAxis = (rightAxis)*(rightAxis)*(rightAxis);
        
        PIDChassis.driveWithJoystick(leftAxis, rightAxis);
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
