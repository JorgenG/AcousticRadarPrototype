/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.legounit;

import javax.microedition.lcdui.Graphics;

/**
 *
 * @author JorgenG
 */
public class ScreenRenderer {
    
    static Graphics gObj = new Graphics();
    
    static int XCENTER = 50;
    static int YCENTER = 32;
    
    public ScreenRenderer()
    {
        
    }
    
    public static void drawBackground()
    {
        gObj.clear();
        gObj.drawArc(50 - 30, 32 - 30, 60, 60, 0, 360);
        gObj.drawRect(XCENTER, YCENTER, 1, 1);
    }
    
    
    public static void drawMapObjects(LCDMap map)
    {
        drawBackground();
        for(int i = 0; i < map.getMapObjects().size(); i++)
        {
            int xPos = (int)(((double)map.getMapObjects().get(i).getDistanceInCm() *
                            Math.cos((double)map.getMapObjects().get(i).getDegree() * 3.1415 / 180.0))*(double)(30.0/255.0));
            int yPos = (int)(((double)map.getMapObjects().get(i).getDistanceInCm() *
                            Math.sin((double)map.getMapObjects().get(i).getDegree() * 3.1415 / 180.0))*(double)(30.0/255.0));
            gObj.drawArc(XCENTER + xPos, YCENTER + yPos, 3, 3, 0, 360);
        }
    }
    
}
