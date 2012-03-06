package org.grondal.acousticradar.legounit;


import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.util.Timer;

/**
 * SoundListener is responsible for detecting sound and take appropriate
 * action. This thread is only active when the Lego Unit is in 
 * a low battery state or sound-activated mode. 
 * 
 * When a sound is detected it will notify the Mapper and the Mapper
 * will rotate one round whilst mapping the environments. 
 * 
 * @author JorgenG
 */
public class SoundListener extends Thread {
    
    private SoundSensor sndSensor;
    private Timer timer;
    private Mapper mapper;
    private int threshold;
    private boolean deactivated;
    
    public SoundListener(Mapper mapper)
    {
        this.mapper = mapper;
        sndSensor = new SoundSensor(SensorPort.S3);
        deactivated = true;
        threshold = 40;
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            if(!deactivated &&
                    sndSensor.readValue() > threshold && 
                    NXTController.getInstance().getOperatingMode() == NXTController.SOUND_ACTIVATED_MODE)
            {
                
                mapper.modeChanged();
            }
            try {
                synchronized(this) {
                    Thread.sleep(100);
                    if(deactivated)
                    {
                        this.wait();
                    }
                }
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
    public synchronized void deactivateSoundListener()
    {
        deactivated = true;
    }
    
    public synchronized void startSoundListener()
    {
        deactivated = false;
        this.notify();
    }
    
}
