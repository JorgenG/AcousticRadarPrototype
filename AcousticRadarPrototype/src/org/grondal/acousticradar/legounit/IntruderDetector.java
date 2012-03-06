/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.legounit;

/**
 *
 * @author JorgenG
 */
public class IntruderDetector {
    
    public LCDMap referenceMap;
    
    public IntruderDetector()
    {
        
    }
    
    public void setReferenceMap(LCDMap referenceMap)
    {
        this.referenceMap = referenceMap;
    }
    
    public void checkForIntruders(LCDMap measuredMap)
    {
        if(referenceMap.getMapObjects().equals(measuredMap.getMapObjects()))
        {
            // Nothing detected
        }
        else
        {            
            NXTController.getInstance().raiseAlarm();
        }
    }
    
}
