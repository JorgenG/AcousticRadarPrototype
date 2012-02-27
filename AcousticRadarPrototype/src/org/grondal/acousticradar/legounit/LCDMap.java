/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grondal.acousticradar.legounit;

import java.util.ArrayList;
import org.grondal.acousticradar.maplibrary.MapInterface;
import org.grondal.acousticradar.maplibrary.MapObject;

/**
 *
 * @author JorgenG
 */
public class LCDMap implements MapInterface
{
    
    private ArrayList<MapObject> mapObjects;
    
    public LCDMap()
    {
        mapObjects = new ArrayList<MapObject>();
    }

    public void addMapObject(int distance, int degree) {
        MapObject mapObject = new MapObject(distance, degree);
        mapObjects.add(mapObject);
    }

    public ArrayList<MapObject> getMapObjects() {
        return mapObjects;
    }
    
}
