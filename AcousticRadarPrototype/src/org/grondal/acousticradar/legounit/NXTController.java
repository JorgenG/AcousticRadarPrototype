package org.grondal.acousticradar.legounit;

import lejos.nxt.*;

/**
 * NXTController is the entry point for the application and will set
 * up the application and be notified when communication is received.
 * 
 * @author JorgenG
 */
public class NXTController {
    
    public static final int CONTINUOUS_MODE = 100;
    public static final int SOUND_ACTIVATED_MODE = 101;
    public static final int IDLE_MODE = 102;
    
    private int operatingMode; 
    
    private static NXTController instance;
    
    
    public NXTController()
    {
        operatingMode = 102;
    }
    
    public void setOperatingMode(int newOperatingMode)
    {
        operatingMode = newOperatingMode;
    }
    
    public int getOperatingMode()             
    {
        return operatingMode;
    }
    
    public static synchronized NXTController getInstance()
    {
        if(instance == null)
        {
            instance = new NXTController();
        }
        return instance;
    }
    

    
    
    public static void main(String[] args) 
    {
        System.out.println("Hello World");
        UltrasonicSensor uSensor = new UltrasonicSensor(SensorPort.S4);

        Sound.beepSequenceUp();

        int counter = 0;
        Motor.A.setSpeed(90);

        Alarm alarm = new Alarm();


        for(int i = 0; i < 36; i++) 
        {
            Motor.A.rotate(10);
            try 
            {
                int distance = uSensor.getDistance();
                Thread.sleep(200);
                if(distance < 255)
                    alarm.start();
                System.out.println(System.currentTimeMillis() + " M: " + distance);
            } 
            catch (Exception e)
            {

            }

        }

        for(int i = 0; i < 36; i++) 
        {
            Motor.A.rotate(-10);
            try 
            {
                int distance = uSensor.getDistance();
                Thread.sleep(200);
                System.out.println(System.currentTimeMillis() + " M: " + distance);
            } 
            catch (Exception e)
            {

            }

        }


        counter = 0;
        Button.waitForPress(10000);

    }
}
