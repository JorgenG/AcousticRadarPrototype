package org.grondal.acousticradar.legounit.communication;

import java.io.*;
import lejos.nxt.LCD;
import lejos.nxt.comm.*;
import org.grondal.acousticradar.legounit.NXTController;
import org.grondal.acousticradar.legounit.ScreenRenderer;

/**
 * 
 * @author JorgenG
 */
public class CommunicationListener extends Thread {
    
    private BTConnection btc;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private CommunicationInterface commInterface;
    
    public CommunicationListener(CommunicationInterface commInterface)
    {
        this.commInterface = commInterface;
    }
    
    public void run()
    {
        LCD.drawString("Waiting..", 0, 0);
        btc = Bluetooth.waitForConnection();
        NXTController.getInstance().initNxt();
        
        LCD.drawString("Connected..", 0, 0);
        ScreenRenderer.drawBackground();
        dataIn = btc.openDataInputStream();
        dataOut = btc.openDataOutputStream();
        
        while(true)
        {         
            int cmd = -1; 
            
            try {
                
                cmd = dataIn.readInt();
                LCD.clear();
                LCD.drawString("Read cmd: " + cmd, 0, 0);
            } catch (IOException ex) {

            }
            NXTController.getInstance().setOperatingMode(cmd);         
        }
        
    }
    
    public DataOutputStream getDataOut()
    {
            return dataOut;
    }
    
}
