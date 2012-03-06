package org.grondal.acousticradar.maplibrary;

import java.util.ArrayList;

/**
 * MapInterface defines the behaviour a map in our context shall
 * consist of.
 * 
 * @author JorgenG
 */
public interface MapInterface {
    
    public void addMapObject(int distance, int degree);
    public ArrayList<MapObject> getMapObjects();
    
}
