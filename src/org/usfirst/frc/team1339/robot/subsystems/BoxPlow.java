package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.BothIn;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoxPlow extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Solenoid leftOut, leftIn, rightOut, rightIn;
	
	public BoxPlow(){
		leftOut = new Solenoid(RobotMap.LEFT_OUT_SOLENOID);
		leftIn = new Solenoid(RobotMap.LEFI_IN_SOLENOID);
		rightOut = new Solenoid(RobotMap.RIGHT_OUT_SOLENOID);
		rightIn = new Solenoid(RobotMap.RIGHT_IN_SOLENOID);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new BothIn());
    }
    
    public void bothIn(){
    	setLeftIn();
    	setRightIn();
    }
    
    public void extendLeft(){
    	setRightIn();
    	setLeftOut();
    }
    
    public void extendRight(){
    	setLeftIn();
    	setRightOut();
    }
    
    private void setLeftOut(){
    	leftIn.set(false);
        leftOut.set(true);
        Timer.delay(.5);
        leftOut.set(false);
        System.out.println("Setting left out...");
    }
    
    private void setLeftIn(){
    	leftOut.set(false);
        leftIn.set(true);
        Timer.delay(.5);
        leftIn.set(false);
        System.out.println("Setting left in...");
    }
    
    private void setRightOut(){
    	rightIn.set(false);
        rightOut.set(true);
        Timer.delay(.5);
        rightOut.set(false);
        System.out.println("Setting right out...");
    }
    
    private void setRightIn(){
    	rightOut.set(false);
        rightIn.set(true);
        Timer.delay(.5);
        rightIn.set(false);
        System.out.println("Setting right in...");
    }
}

