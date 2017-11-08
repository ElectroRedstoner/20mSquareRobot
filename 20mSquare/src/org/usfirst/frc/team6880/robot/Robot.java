package org.usfirst.frc.team6880.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.interfaces.Gyro;
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
	Gyro gyro;

	@Override
	public void robotInit() {
		driveSys = new RobotDrive(0, 1, 2, 3);
		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		leftEnc.setDistancePerPulse(RobotMap.distPerPulse);
		rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		rightEnc.setDistancePerPulse(RobotMap.distPerPulse);
		gyro = new AnalogGyro(1);
	}

	@Override
	public void autonomous() {
		while (true) {
			driveSys.arcadeDrive(1.0, 0.0);
			// If we have traveled 20, let's turn
			if (leftEnc.getDistance() < 20) {
				break;
			}
		}
	}
}