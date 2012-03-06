/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.legounit.communication;

import java.io.DataOutputStream;
import java.io.IOException;
import org.grondal.acousticradar.legounit.LCDMap;

/**
 *
 * @author JorgenG
 */
public class CommunicationInterface 
{
    
    public static final int CMD_CHANGETOCONTMODE = 100;
    public static final int CMD_CHANGETOSOUNDMODE = 101;
    public static final int CMD_CHANGETOIDLEMODE = 102;
    public static final int CMD_MAPOBJECTS = 103;
    
    private CommunicationListener commListener;
    
    public CommunicationInterface()
    {
        commListener = new CommunicationListener(this);
        commListener.start();
    }
    
    public synchronized void switchToIdleMode()
    {
        sendModeChange(CMD_CHANGETOIDLEMODE);
    }
    
    public synchronized void switchToContinuousMode()
    {
        sendModeChange(CMD_CHANGETOCONTMODE);
    }
    
    public synchronized void switchToSoundActivatedMode()
    {
        sendModeChange(CMD_CHANGETOSOUNDMODE);
    }
    
    /**
     * Description of data flow is as follows:
     * 
     * |CMD|NR OF MAPOBJECTS|MAPOBJ0 DEGREE|MAPOBJ0 DISTANCE|MAPOBJ1 DEGREE|MAPOBJ1 DISTANCE|MAPOBJN DEGREE|MAPOBJN DISTANCE|
     * @param map 
     */
    public synchronized void sendMapData(LCDMap map, int mapType)
    {
        try {
            int mapObjects = map.getMapObjects().size();
            DataOutputStream dataOut = commListener.getDataOut();
            
            if(dataOut == null)
                return;
            
            dataOut.writeInt(CMD_MAPOBJECTS);
            dataOut.writeInt(mapObjects);
            dataOut.writeInt(mapType);
            
            for(int i = 0; i < mapObjects; i++)
            {
                dataOut.writeInt(map.getMapObjects().get(i).getDegree());
                dataOut.writeInt(map.getMapObjects().get(i).getDistanceInCm());
            }         
            dataOut.flush();
            
        } catch (IOException ex) {
            
        }
    }
    
    private void sendModeChange(int newMode)
    {
        try {
            commListener.getDataOut().writeInt(newMode);
            commListener.getDataOut().flush();
        } catch (IOException ex) {
            
        }
    }
}
