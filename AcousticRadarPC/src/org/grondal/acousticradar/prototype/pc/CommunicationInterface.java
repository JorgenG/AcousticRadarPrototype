/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.prototype.pc;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JorgenG
 */
public class CommunicationInterface {
    
    public static final int CMD_CHANGETOCONTMODE = 100;
    public static final int CMD_CHANGETOSOUNDMODE = 101;
    public static final int CMD_CHANGETOIDLEMODE = 102;
    public static final int CMD_MAPOBJECTS = 103;
    
    public CommunicationListener commListener;
    
    public CommunicationInterface()
    {
        commListener = new CommunicationListener();
        commListener.start();
    }
    
    public void switchToIdleMode()
    {
        try {
            commListener.getDataOut().writeInt(CMD_CHANGETOIDLEMODE);
            commListener.getDataOut().flush();
            System.out.println("Wrote changetoidle");
        } catch (IOException ex) {
            
        }
    }
    
    public void switchToContinuousMode()
    {
        try {
            commListener.getDataOut().writeInt(CMD_CHANGETOCONTMODE);
            commListener.getDataOut().flush();
            System.out.println("Wrote changetocontmode");
        } catch (IOException ex) {
            
        }
    }
    
    public void switchToSoundActivatedMode()
    {
        try {
            commListener.getDataOut().writeInt(CMD_CHANGETOSOUNDMODE);
            commListener.getDataOut().flush();
            System.out.println("Wrote changetosoundmode");
        } catch (IOException ex) {
            
        }
    }
}
