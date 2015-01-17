//ok google now start robot
//siri start robot program
package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
       
        
        leftFront = new CANTalon(RobotMap.LEFT_FRONT_SRX);
        leftBack = new CANTalon(RobotMap.LEFT_BACK_SRX);
        rightFront = new CANTalon(RobotMap.RIGHT_FRONT_SRX);
        rightBack = new CANTalon(RobotMap.RIGHT_BACK_SRX);

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    public void driveStraight(double speed){
    	setLeftRight(speed, speed);
    }
    
    public void turnLeft(){
    	setLeftRight(0, 0.5);
    }
    
    public void turnRight(){
    	setLeftRight(0.5, 0);
    }
    
    public void driveWithJoystick(double leftValue, double rightValue) {
    	arcadeDrive(leftValue, rightValue);
    }
    
    public void arcadeDrive(double throttle, double turn){
    	double left = 0;
    	double right = 0;
    	
    	if(throttle > 0){
    		left = throttle + turn;
    		right = throttle - turn;
    	}
    	else if(throttle < 0){
    		left = throttle - turn;
    		right = throttle + turn;
    	}

    	setLeftRight(left, right);
    }
    
    private void setLeftRight(double leftSpeed, double rightSpeed){
    	leftFront.set(leftSpeed);
    	leftBack.set(leftSpeed * -1);
    	rightFront.set(rightSpeed);
    	rightBack.set(rightSpeed * -1);
    	
    	SmartDashboard.putNumber("Left Speed", leftSpeed);
    	SmartDashboard.putNumber("Right Speed", rightSpeed);
    	
    	SmartDashboard.putNumber("Left Front Temp", leftFront.getTemp());
    	SmartDashboard.putNumber("Left Back Temp", leftBack.getTemp());
    	SmartDashboard.putNumber("Right Front Temp", rightFront.getTemp());
    	SmartDashboard.putNumber("Right Back Temp", rightBack.getTemp());
    }
    
    public double getTalonTemp(int num){
    	double temp = 0;
    	if(num == 0){
    		temp = leftFront.getTemp();
    	}
    	else if(num == 1){
    		temp = leftBack.getTemp();
    	}
    	else if(num == 2){
    		temp = rightFront.getTemp();
    	}
    	else if(num == 3){
    		temp = rightBack.getTemp();
    	}
		return temp;
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
