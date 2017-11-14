package org.usfirst.frc.team6880.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends SampleRobot {
	RobotDrive driveSys;
	Encoder leftEnc;
	Encoder rightEnc;

	@Override
	public void robotInit() {
		driveSys = new RobotDrive(0, 1, 2, 3);
		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		leftEnc.setDistancePerPulse(RobotMap.distPerPulse);
		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		rightEnc.setDistancePerPulse(RobotMap.distPerPulse);
	}

	@Override
	public void autonomous() {
		int numturns = 0;
		while (true) {
			// Make sure we drive straight
			driveSys.drive(1.0, rightEnc.get() - leftEnc.get());
			
			// If we have traveled 20m, let's turn
			if (leftEnc.getDistance() >= 20) {
				// If this is the 4th (or greater, if I messed up) time we should turn, stop robot
				if (numturns++ >= 1 /*4 Using 1 for now so that the robot doesn't turn*/) break;

				while (leftEnc.getDistance() < RobotMap.wheelBase * Math.PI / 4) {
					driveSys.tankDrive(-1.0, 1.0);
					Timer.delay(0.05);
				}
				
				leftEnc.reset();
				rightEnc.reset();
			}
			Timer.delay(0.05);
		}
	}
}