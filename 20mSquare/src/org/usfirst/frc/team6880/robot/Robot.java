package org.usfirst.frc.team6880.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
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
	VictorSP left1;
	VictorSP left2;
	VictorSP right1;
	VictorSP right2;
	Encoder leftEnc;
	Encoder rightEnc;
	Gyro gyro;

	@Override
	public void robotInit() {
		left1 = new VictorSP(0);
		left2 = new VictorSP(1);
		right1 = new VictorSP(2);
		right2 = new VictorSP(3);
		
		driveSys = new RobotDrive(left1, left2, right1, right2);
		leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		leftEnc.setDistancePerPulse(RobotMap.distPerPulse);
		rightEnc = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		rightEnc.setDistancePerPulse(RobotMap.distPerPulse);
		gyro = new AnalogGyro(1);
	}

	@Override
	public void autonomous() {
		int numturns = 1;
		leftEnc.reset();
		rightEnc.reset();
		while (isAutonomous() && isEnabled()) {
			driveSys.tankDrive(0.3, 0.3);
//			System.out.println(leftEnc.getRaw() + "," + rightEnc.getRaw());
			// If we have traveled 20m, let's turn
			if ((rightEnc.getDistance() + leftEnc.getDistance()) / 2.0 >= 1.0) {
				// If this is the 4th (or greater, if I messed up) time we should turn, stop robot
				if (--numturns <= 0) break;

				while (leftEnc.getDistance() < RobotMap.wheelBase * Math.PI / 4) {
					driveSys.tankDrive(-1.0, 1.0);
					Timer.delay(0.05);
				}
				
				leftEnc.reset();
				rightEnc.reset();
				gyro.reset();
			}
			Timer.delay(0.05);
		}
		// Now that we're done, stop
		driveSys.tankDrive(0, 0);
	}
}