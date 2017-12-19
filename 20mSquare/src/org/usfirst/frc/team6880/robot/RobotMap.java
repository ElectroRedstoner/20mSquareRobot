package org.usfirst.frc.team6880.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static double wheelBase = 0.703;
	/* (6in diameter)(2.54cm/1in)(1m/100cm) = 6*.0254 meter diameter
	 * pi(6*.0254) = 6*.0254*pi meter circumference
	 * 360 counts/circumference = 6*.0254*pi/360 m/count
	 */
	public static double distPerPulse = 6.0 * Math.PI * 0.0254 / 360.0;
}
