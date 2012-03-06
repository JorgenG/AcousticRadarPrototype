/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.prototype.pc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author JorgenG
 */
public class MapPanel extends JPanel {
    
    private HighResolutionMap refMap, curMap;
    private static int RADIUS = 255;
    private static int MARGIN = 10;
    private static double PI = 3.1415;
    
    public MapPanel() 
    {
        this.setPreferredSize(new Dimension(2*RADIUS + MARGIN, 2*RADIUS + MARGIN));
    }
    
    public void setReferenceMap(HighResolutionMap refMap)
    {
        this.refMap = refMap;
        this.repaint();
    }
    
    public void setCurrentMap(HighResolutionMap curMap)
    {
        this.curMap = curMap;
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        // Draw radar
        g.setColor(new Color(0, 150, 0));
        g.fillOval(MARGIN, MARGIN, 2*RADIUS, 2*RADIUS);
        g.setColor(Color.black);
        g.drawOval(MARGIN, MARGIN, 2*RADIUS, 2*RADIUS);
        g.fillOval((MARGIN + RADIUS) - 2, (MARGIN + RADIUS) - 2, 5, 5);
        
        
        // Draw reference map
        if(refMap != null)
        {
            g.setColor(Color.red);
            int xPos, yPos, nextX, nextY;
            
            xPos = (int)((double)refMap.getMapObjects().get(0).getDistanceInCm() *
                            Math.cos((double)refMap.getMapObjects().get(0).getDegree() * PI / 180.0));
            yPos = (int)((double)refMap.getMapObjects().get(0).getDistanceInCm() *
                            Math.sin((double)refMap.getMapObjects().get(0).getDegree() * PI / 180.0));
            for(int i = 0; i < refMap.getMapObjects().size(); i++)
            {
                
                g.fillOval((RADIUS + MARGIN) + xPos - 2, (RADIUS + MARGIN) + yPos - 2, 5, 5);
                if(i != refMap.getMapObjects().size() - 1)
                {
                    nextX = (int)((double)refMap.getMapObjects().get(i + 1).getDistanceInCm() *
                            Math.cos((double)refMap.getMapObjects().get(i + 1).getDegree() * PI / 180.0));
                    nextY = (int)((double)refMap.getMapObjects().get(i + 1).getDistanceInCm() *
                            Math.sin((double)refMap.getMapObjects().get(i + 1).getDegree() * PI / 180.0));    
                    
                }
                else
                {
                    nextX = (int)((double)refMap.getMapObjects().get(0).getDistanceInCm() *
                            Math.cos((double)refMap.getMapObjects().get(0).getDegree() * PI / 180.0));
                    nextY = (int)((double)refMap.getMapObjects().get(0).getDistanceInCm() *
                            Math.sin((double)refMap.getMapObjects().get(0).getDegree() * PI / 180.0)); 
                }
                g.drawLine((RADIUS + MARGIN) + xPos, (RADIUS + MARGIN) + yPos, 
                        (RADIUS + MARGIN) + nextX, (RADIUS + MARGIN) + nextY);
                
                xPos = nextX;
                yPos = nextY;
            }
        }
        
        // Draw current map
        if(curMap != null)
        {
            int xPos, yPos, nextX, nextY;
            
            g.setColor(Color.blue);
            xPos = (int)((double)curMap.getMapObjects().get(0).getDistanceInCm() *
                            Math.cos(curMap.getMapObjects().get(0).getDegree() * PI / 180.0));
            yPos = (int)((double)curMap.getMapObjects().get(0).getDistanceInCm() *
                            Math.sin(curMap.getMapObjects().get(0).getDegree() * PI / 180.0));
            for(int i = 0; i < curMap.getMapObjects().size(); i++)
            {                
                g.fillOval((RADIUS + MARGIN) + xPos - 2, (RADIUS + MARGIN) + yPos - 2, 5, 5);
                
                if(i != curMap.getMapObjects().size() - 1)
                {
                    nextX = (int)((double)curMap.getMapObjects().get(i + 1).getDistanceInCm() *
                            Math.cos((double)curMap.getMapObjects().get(i + 1).getDegree() * PI / 180.0));
                    nextY = (int)((double)curMap.getMapObjects().get(i + 1).getDistanceInCm() *
                            Math.sin((double)curMap.getMapObjects().get(i + 1).getDegree() * PI / 180.0)); 
                    
                }
                else
                {
                    nextX = (int)((double)curMap.getMapObjects().get(0).getDistanceInCm() *
                            Math.cos((double)curMap.getMapObjects().get(0).getDegree() * PI / 180.0 ));
                    nextY = (int)((double)curMap.getMapObjects().get(0).getDistanceInCm() *
                            Math.sin((double)curMap.getMapObjects().get(0).getDegree() * PI / 180.0)); 
                }
                
                g.drawLine((RADIUS + MARGIN) + xPos, (RADIUS + MARGIN) + yPos, 
                        (RADIUS + MARGIN) + nextX, (RADIUS + MARGIN) + nextY);
                
                xPos = nextX;
                yPos = nextY;
            }
        }
        
        
    }
    
}
