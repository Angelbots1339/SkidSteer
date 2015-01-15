package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDElevator extends PIDSubsystem {
	
	private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
	
	CANTalon elevMotor;
	static AnalogPotentiometer pot;

    // Initialize your subsystem here
    public PIDElevator() {
    	super("PIDElevator", Ki, Kp, Kd);
    	enable();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	elevMotor = new CANTalon(RobotMap.ELEV_TALON);
    	pot = new AnalogPotentiometer(RobotMap.POTENTIOMETER_PORT, 1, 4);
    }
    
    public void elevatorSet(double setpoint){
    	setSetpoint(setpoint);
    }
    
    public static double getPot(){
    	return pot.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return pot.pidGet();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
