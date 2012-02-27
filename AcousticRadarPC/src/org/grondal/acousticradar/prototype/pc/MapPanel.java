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
    
    public MapPanel() 
    {
        this.setPreferredSize(new Dimension(220, 220));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillOval(10, 10, 200, 200);
        g.setColor(Color.black);
        g.drawOval(10, 10, 200, 200);
        
        
    }
    
}
