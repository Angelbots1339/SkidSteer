
package org.usfirst.frc.team1339.robot;



import org.usfirst.frc.team1339.robot.commands.CommandBase;
import org.usfirst.frc.team1339.robot.commands.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("robotInit()\n");
		oi = new OI();
		CommandBase.init();
		SmartDashboard.putData("Drive Forward", new DriveForward(0.3, 3));
		SmartDashboard.putData("Drive Backward", new DriveBackward(0.3, 3));
		SmartDashboard.putData("Suck", new Suck());
		// initialize commands and the OI (created by Netbeans)
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
    }	
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	System.out.println("teleopInit()\n");
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        //SmartDashboard.putNumber("Front Left Talon Temp", CommandBase.PIDChassis.getTalonTemp(0));
		//SmartDashboard.putNumber("Back Left Talon Temp", CommandBase.PIDChassis.getTalonTemp(1));
		//SmartDashboard.putNumber("Front Right Talon Temp", CommandBase.PIDChassis.getTalonTemp(2));
		//SmartDashboard.putNumber("Back Right Talon Temp", CommandBase.PIDChassis.getTalonTemp(3));
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	// Keep the line below, it's required to start the Java Scheduler
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
