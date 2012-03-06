/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.prototype.pc;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import lejos.pc.comm.*;
/**
 *
 * @author JorgenG
 */
public class CommunicationListener extends Thread
{
    private NXTCommBluecove nxtComm;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    
    public CommunicationListener()
    {
        
    }
    
    @Override
    public void run()
    {
        NXTInfo nxtInfo = new NXTInfo(NXTCommFactory.BLUETOOTH, "NXT6", "00:16:53:00:6e:fe");
        try
        {
            nxtComm = (NXTCommBluecove) NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
            nxtComm.open(nxtInfo);
            
            
            dataIn = new DataInputStream(nxtComm.getInputStream());
            dataOut = new DataOutputStream(nxtComm.getOutputStream());
            
            MainWindow.getInstance().setStatusBarText("Connected ... Idle");
            
        } catch (NXTCommException e)
        {
            // Something went wrong!
        }
        
        while(true)
        {
            try {
                              
                int cmd = dataIn.readInt();
                
                if(cmd != CommunicationInterface.CMD_MAPOBJECTS)
                {
                    MainWindow.getInstance().modeSelect(cmd);
                }
                else
                {
                    int mapobjects = dataIn.readInt();
                    int maptype = dataIn.readInt(); // 120 = referenceMap, 121 = currentMap
                    HighResolutionMap receivedMap = new HighResolutionMap();
                    
                    for(int i = 0; i < mapobjects; i++)
                    {
                        int degrees = dataIn.readInt();
                        int distance = dataIn.readInt();
                        
                        receivedMap.addMapObject(distance, degrees);     
                    }
                    if(maptype == 120)
                    {
                        MainWindow.getInstance().getMapPanel().setReferenceMap(receivedMap);
                    }
                    else if(maptype == 121)
                    {
                        MainWindow.getInstance().getMapPanel().setCurrentMap(receivedMap);
                    }
                }
                
            } catch (IOException ex) {
                Logger.getLogger(CommunicationListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public DataOutputStream getDataOut()
    {
        return dataOut;
    }
    
}
