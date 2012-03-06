package org.grondal.acousticradar.legounit;

import lejos.nxt.*;
import org.grondal.acousticradar.legounit.communication.CommunicationInterface;

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
    
    private Alarm alarm;
    private int operatingMode; 
    private CommunicationInterface commInterface;
    private Mapper mapper;
    private SoundListener sndListener;
    
    private static NXTController instance;
    
    
    public NXTController()
    {
        operatingMode = 102;
        alarm = new Alarm();
        commInterface = new CommunicationInterface();
        mapper = new Mapper();
        sndListener = new SoundListener(mapper);
    }
    
    public void initNxt()
    {
        mapper.start();
        sndListener.start();
    }
    
    public synchronized void setOperatingMode(int newOperatingMode)
    {
        if(newOperatingMode != operatingMode)
        {
            mapper.stopMapping();
            operatingMode = newOperatingMode;
            mapper.modeChanged();
            if(operatingMode == SOUND_ACTIVATED_MODE)
            {
                sndListener.startSoundListener();
            }
            else
            {
                sndListener.deactivateSoundListener();
            }
        }            
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
    
    public void raiseAlarm()
    {
        if(alarm.isAlive())
        {
            // Do nothing.
        } 
        else
        {
            alarm = new Alarm();
            alarm.start();
        }
        
    }
    
    public void sendMapObjects(LCDMap map, int mapType)
    {
        commInterface.sendMapData(map, mapType);
    }

    
    
    public static void main(String[] args) 
    {
        NXTController controller = NXTController.getInstance();
        
        /*
        System.out.println("Hello World");
        UltrasonicSensor uSensor = new UltrasonicSensor(SensorPort.S4);

        Sound.beepSequenceUp();
        Alarm alarm = new Alarm();
        alarm.start();
        int counter = 0;
        Motor.A.setSpeed(90);
        Motor.A.rotate(180);
        Motor.A.rotate(-180);

        
*/
/*
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

        }*/

/*
        Button.waitForPress(10000);
 * */
 

    }
}
