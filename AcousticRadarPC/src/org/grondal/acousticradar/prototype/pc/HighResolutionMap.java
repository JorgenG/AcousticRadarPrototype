/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.prototype.pc;

import java.util.ArrayList;
import org.grondal.acousticradar.maplibrary.MapInterface;
import org.grondal.acousticradar.maplibrary.MapObject;

/**
 *
 * @author JorgenG
 */
public class HighResolutionMap implements MapInterface 
{
    private ArrayList<MapObject> mapObjects;

    public HighResolutionMap()
    {
        mapObjects = new ArrayList<MapObject>();
    }
    
    @Override
    public void addMapObject(int distance, int degree) 
    {
        mapObjects.add(new MapObject(distance, degree));
    }

    @Override
    public ArrayList<MapObject> getMapObjects() 
    {
        return mapObjects;
    }
    
}
