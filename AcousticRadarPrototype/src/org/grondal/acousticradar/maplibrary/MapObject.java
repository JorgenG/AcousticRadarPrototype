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
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == this) return true;
        if(!(obj instanceof MapObject)) return false;
        
        
        MapObject thatObj = (MapObject) obj;
        if(thatObj.getDistanceInCm() > 170 && this.getDistanceInCm() > 170)
            return true;
        
        if(thatObj.getDegree() == this.getDegree())
        {
            if(Math.abs(thatObj.getDistanceInCm() - this.getDistanceInCm()) < 8)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
        
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
