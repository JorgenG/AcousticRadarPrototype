package org.grondal.acousticradar.legounit;

import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.*;

/**
 * NXTController is the entry point for the application and will set
 * up the application and be notified when communication is received.
 * 
 * @author JorgenG
 */
public class NXTController {

	public static void main(String[] args) {
		System.out.println("Hello World");
                PilotProps pp = new PilotProps();
                
                RegulatedMotor leftMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_LEFTMOTOR, "B"));
                RegulatedMotor rightMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_RIGHTMOTOR, "A"));
                
                DifferentialPilot motorController = new DifferentialPilot(5.5, 11.6, leftMotor, rightMotor);
                UltrasonicSensor uSensor = new UltrasonicSensor(SensorPort.S4);
                
                Sound.beepSequenceUp();
                
                motorController.setRotateSpeed(20);
                int counter = 0;
                
                while(counter < 360)
                {                   
                    System.out.println("Distance: " + uSensor.getDistance());
                    motorController.rotate(5);
                    counter+= 5;
                }
                Button.waitForPress(10000);
                
	}
}
