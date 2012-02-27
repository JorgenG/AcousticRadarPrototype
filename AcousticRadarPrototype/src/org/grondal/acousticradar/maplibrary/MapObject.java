package org.grondal.acousticradar.maplibrary;

/**
 *
 * MapObject represents one object that is detected. It consists of 
 * a degree, which is the rotation the lego unit had when measuring, and 
 * the distance measured.
 * 
 * @author JorgenG
 */
public class MapObject {
    
    private int distanceInCm;
    private int degree;
    
    public MapObject(int distanceInCm, int degree)
    {
        this.distanceInCm = distanceInCm;
        this.degree = degree;
    }
    
    public int getDistanceInCm()
    {
        return distanceInCm;
    }
    
    public int getDegree()
    {
        return degree;
    }    
}
