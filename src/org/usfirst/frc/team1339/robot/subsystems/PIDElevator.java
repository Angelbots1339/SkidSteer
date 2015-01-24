package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.DriveWinch;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDElevator extends PIDSubsystem {
	
	public Joystick joystick1 = new Joystick(RobotMap.JOY_1_PORT);
	private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
	private CANTalon elevMotor;
	
	
	
	public DigitalInput button;
	
    // Initialize your subsystem here
    public PIDElevator() {
    	super("PIDElevator", Ki, Kp, Kd);
    	enable();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	elevMotor = new CANTalon(RobotMap.ELEV_TALON);
    	
    	
    	
        button = new DigitalInput(0); 
    }
     
    
    public void elevatorSet(double setpoint){
    	setSetpoint(setpoint);
    }
    
    //public  double getPot(){
    //	return pot.get();
    //}
    //SmartDashboard.putNumber("PotResistance" pot.getvoltage);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWinch());
    }
    
    
    public void winchDrive(double speed){
    		elevMotor.set(speed);	
		
    }
    
    public boolean getButton(){
    	return button.get();
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0;//pot.pidGet();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
