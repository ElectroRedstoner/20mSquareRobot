package org.usfirst.frc.team6880.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	RobotDrive driveSys;
	Encoder leftEnc;
	Encoder rightEnc;

	@Override
	public void robotInit() {
		driveSys = new RobotDrive(0, 1, 2, 3);
		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		leftEnc.setDistancePerPulse(RobotMap.distPerPulse); //(pi*(3 inch radius)*(1cm/2.54in)*(1m/100cm)^2)
		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		rightEnc.setDistancePerPulse(RobotMap.distPerPulse);
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		
	}
}