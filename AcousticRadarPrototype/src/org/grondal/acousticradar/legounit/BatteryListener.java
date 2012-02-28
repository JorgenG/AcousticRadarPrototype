package org.grondal.acousticradar.legounit;

import lejos.nxt.Battery;

/**
 * BatteryListener is responsible for monitoring the batterylevel
 * and take appropriate action when the battery is low.
 * 
 * @author JorgenG
 */
public class BatteryListener extends Thread {
    
    private int batteryThreshold;
    private boolean isInterrupted;
    
    public BatteryListener()
    {
        isInterrupted = false;
        batteryThreshold = 200;
    }
    
    public void run()
    {        
        while(!isInterrupted)
        {
            if(Battery.getVoltageMilliVolt() < batteryThreshold)
            {
                NXTController.getInstance().setOperatingMode(NXTController.SOUND_ACTIVATED_MODE);
            }
            try
            {
                Thread.sleep(30000);
            }
            catch (Exception e) {}
        }
    }
    
}
