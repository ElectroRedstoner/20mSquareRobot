package org.usfirst.frc.team6880.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static double distPerPulse = Math.PI * Math.pow(3.0/254.0, 2) / 360.0;
}
