package dk.zbc.h4.kortspil;
import java.util.ArrayList;

/**
 *
 * @author runra
 */
public abstract class KortspilMgr {
    
    public abstract void startSpil();
    public abstract void slutSpil();
    public ArrayList<Kort> blandKort(ArrayList<Kort> deck) {return null;} 
}
