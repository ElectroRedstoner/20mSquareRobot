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
			if (leftEnc.getDistance() > 20) {
				// If this is the 4th time (or, if I messed up with programming, greater) we should turn, stop robot
				if (numturns++ >= 4) break;

				//                             v---Distance between wheels / 2
				while (leftEnc.getDistance() < 1 * Math.PI / 4) {
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