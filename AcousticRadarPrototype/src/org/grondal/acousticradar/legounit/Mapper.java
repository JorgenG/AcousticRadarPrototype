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
    
    private IntruderDetector intruderDetector;
    
    
    public Mapper() 
    {
        motor = Motor.A;
        motor.setSpeed(60);
        currentPosition = 0;
        uSensor = new UltrasonicSensor(SensorPort.S4);
        isInterrupted = false;
        rotationTick = 10;
        intruderDetector = new IntruderDetector();
    }
    
    @Override
    public void run()
    {
        createReferenceMap();
        NXTController.getInstance().sendMapObjects(referenceMap, 120);
        while(true)
        {
            try 
            {
                synchronized(this)
                {
                    startMapping();
                    this.wait();
                      
                }                
            } 
            catch (InterruptedException ex) 
            {
                
            } 
            isInterrupted = false;
        }
    }
    
    public void startMapping () throws InterruptedException
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
            this.wait();
            scanOnce();
        }
             
        
    }  
    
    public synchronized void modeChanged()
    {
        this.notify();
    }
    
    public void scanOnce()
    {
        currentMap = new LCDMap();
        while(currentPosition < 360 && !isInterrupted)
        {
            try 
            {
                Thread.sleep(50);
            }
            catch(Exception e){ }
            int distance = uSensor.getDistance();
                currentMap.addMapObject(distance, currentPosition);
            
            currentPosition += rotationTick;
            motor.rotate(rotationTick);
        }
        if(!isInterrupted) {
            intruderDetector.checkForIntruders(currentMap);
            ScreenRenderer.drawMapObjects(currentMap);
            NXTController.getInstance().sendMapObjects(currentMap, 121);
        }
            
       
        
        
        motor.setSpeed(180);
        motor.rotate(-currentPosition);
        motor.setSpeed(60);
        currentPosition = 0;
               
    }
    
    public void createReferenceMap()
    {
        referenceMap = new LCDMap();
        while(currentPosition < 360 && !isInterrupted)
        {
            try 
            {
                Thread.sleep(50);
            }
            catch(Exception e){ }
            int distance = uSensor.getDistance();
            referenceMap.addMapObject(distance, currentPosition);
            
            currentPosition += rotationTick;
            motor.rotate(rotationTick);
        }
        
        if(!isInterrupted)
        {
            intruderDetector.setReferenceMap(referenceMap);
            ScreenRenderer.drawMapObjects(referenceMap);
        } 
        motor.setSpeed(180);
        motor.rotate(-currentPosition);
        motor.setSpeed(60);
        currentPosition = 0;
        
                   
    }
    
    public synchronized void soundDetected()
    {
        this.notify();
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
