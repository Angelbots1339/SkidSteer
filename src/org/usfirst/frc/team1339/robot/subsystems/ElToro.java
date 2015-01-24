package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.Chill;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElToro extends Subsystem {
	
    CANTalon leftWheel, rightWheel;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DigitalInput suck_switch;
    public ElToro(){
    	
    	leftWheel = new CANTalon(RobotMap.LEFT_WHEEL);
    	rightWheel = new CANTalon(RobotMap.RIGHT_WHEEL);
    suck_switch = new DigitalInput(1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Chill());
    }
    
    public void suck(double speed){
    	leftWheel.set(speed);
    	rightWheel.set((speed)*-1);
    }
    
    public void spin(double speed){
    	leftWheel.set(speed);
    	rightWheel.set(speed);
    }
    
    public void spit(double speed){
    	leftWheel.set((speed)*-1);
    	rightWheel.set(speed);
    }
    
    public void chill(){
    	leftWheel.set(0);
    	rightWheel.set(0);
    }
}

