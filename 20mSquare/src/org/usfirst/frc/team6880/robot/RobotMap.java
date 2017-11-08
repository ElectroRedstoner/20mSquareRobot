package org.usfirst.frc.team6880.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// (pi*((3in radius)*(1cm/2.54in)*(1m/100cm))^2)/360
	public static double distPerPulse = Math.PI * Math.pow(3.0/254.0, 2) / 360.0;
}
