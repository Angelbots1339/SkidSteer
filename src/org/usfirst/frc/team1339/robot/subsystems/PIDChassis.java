//ok google now start robot
//siri start robot program
package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
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
    public Encoder enc = new Encoder (2, 3, false, CounterBase.EncodingType.k4X);
    private AnalogInput ai;
    private AnalogPotentiometer pot;
    CANTalon leftFront, leftTop, leftBack, rightFront, rightTop, rightBack;
   
    // Initialize your subsystem here
    public PIDChassis() {
        super("PIDChassis", Kp, Ki, Kd);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
       
        
        leftFront = new CANTalon(RobotMap.LEFT_FRONT_SRX);
        leftTop = new CANTalon(RobotMap.LEFT_TOP_SRX);
        leftBack = new CANTalon(RobotMap.LEFT_BACK_SRX);
        rightFront = new CANTalon(RobotMap.RIGHT_FRONT_SRX);
        rightTop = new CANTalon(RobotMap.RIGHT_TOP_SRX);
        rightBack = new CANTalon(RobotMap.RIGHT_BACK_SRX);

        
        int count = enc.get();
        double raw = enc.getRaw();
        double distance = enc.getDistance();
        double period = enc.getPeriod();
        double rate = enc.getRate();
        //enc.setMaxPeriod(.1);
        //enc.setMinRate(20);
        enc.setDistancePerPulse(10);
        
        ai = new AnalogInput(RobotMap.POTENTIOMETER_PORT);
        pot = new AnalogPotentiometer(ai,280);
        //enc.setReverseDirection(true);   
        //enc.getDistance();
        //enc.getRaw();
        
        
        /*
      
        
        
        */
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
    	leftTop.set(leftSpeed);
    	leftBack.set(leftSpeed);
    	rightFront.set(rightSpeed);
    	rightTop.set(rightSpeed);
    	rightBack.set(rightSpeed);
    	
    	SmartDashboard.putNumber("Left Speed", leftSpeed);
    	SmartDashboard.putNumber("Right Speed", rightSpeed);
    	
    	SmartDashboard.putNumber("Left Front Temp", leftFront.getTemp());
    	SmartDashboard.putNumber("Left Top Temp", leftTop.getTemp());
    	SmartDashboard.putNumber("Left Back Temp", leftBack.getTemp());
    	SmartDashboard.putNumber("Right Front Temp", rightFront.getTemp());
    	SmartDashboard.putNumber("Right Top Temp", rightTop.getTemp());
    	SmartDashboard.putNumber("Right Back Temp", rightBack.getTemp());
    	SmartDashboard.putNumber("Encoder Distance", enc.getDistance() );
    	SmartDashboard.putNumber("PotTest", pot.get());
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



   

   