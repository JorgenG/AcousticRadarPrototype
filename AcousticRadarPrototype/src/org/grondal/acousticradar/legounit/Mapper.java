package org.grondal.acousticradar.legounit;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * Mapper is responsible mapping the environments and add a 
 * map object to the map when one is detected.
 * 
 * The maximum range of the ultrasonic sensor is about 160 cm.
 * When nothing is in range the method will return 255.
 * 
 * It is required that one map is measured before looking for intruders.
 * 
 * @author JorgenG
 */
public class Mapper extends Thread 
{
    private NXTRegulatedMotor motor;
    private int currentPosition;
    private UltrasonicSensor uSensor;
    private boolean isInterrupted;
    private int rotationTick;
    private LCDMap currentMap;
    private LCDMap referenceMap;
    
    
    public Mapper(LCDMap lcdMap) 
    {
        motor = Motor.A;
        motor.setSpeed(60);
        currentPosition = 0;
        uSensor = new UltrasonicSensor(SensorPort.S4);
        isInterrupted = false;
        rotationTick = 10;
        this.currentMap = lcdMap;
    }
    
    public void run()
    {
        while(true)
        {
            
        }
    }
    
    public LCDMap getCurrentMap()
    {
        return currentMap;
    }
    
    public void startMapping() 
    {
        
        if(NXTController.CONTINUOUS_MODE == NXTController.getInstance().getOperatingMode())
        {
            while(!isInterrupted)
            {
                scanOnce();
            }
        } 
        else if(NXTController.SOUND_ACTIVATED_MODE == NXTController.getInstance().getOperatingMode())
        {
            for(int i = 0; i < 3 && !isInterrupted; i++)
            {
                scanOnce();
            }
        }
        else 
        {
            try {
                this.wait();
            } catch (InterruptedException ex) {

            }
        }
        
    }  
    
    public void scanOnce()
    {
        while(currentPosition < 360 && !isInterrupted)
        {
            try 
            {
                Thread.sleep(50);
            }
            catch(Exception e){ }
            int distance = uSensor.getDistance();
            if(distance != 255)
            {
                currentMap.addMapObject(distance, currentPosition);
            }            
            currentPosition += rotationTick;
            motor.rotate(rotationTick);
        }
        
        while(currentPosition > 0 && !isInterrupted)
        {
            try 
            {
                Thread.sleep(50);
            }
            catch(Exception e){ }
            int distance = uSensor.getDistance();
            if(distance != 255)
            {
                currentMap.addMapObject(distance, currentPosition);
            }            
            currentPosition -= rotationTick;
            motor.rotate(-rotationTick);
        }
    }
    
    public void createReferenceMap()
    {
        while(currentPosition < 360 && !isInterrupted)
        {
            try 
            {
                Thread.sleep(50);
            }
            catch(Exception e){ }
            int distance = uSensor.getDistance();
            if(distance != 255)
            {
                referenceMap.addMapObject(distance, currentPosition);
            }            
            currentPosition += rotationTick;
            motor.rotate(rotationTick);
        }
        motor.setSpeed(180);
        motor.rotate(-360);
        motor.setSpeed(60);
        currentPosition = 0;
    }
    
    public void soundDetected()
    {
        
    }
    
    public void stopMapping()
    {
        isInterrupted = true;
    }
    
    /**
     * Measures the current distance in orientation.
     */
    private int measureDistance() 
    {
        return uSensor.getDistance();
    }
    
}
