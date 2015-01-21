package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class BothIn extends CommandBase {

    public BothIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(BoxPlow);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	BoxPlow.bothIn();
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
