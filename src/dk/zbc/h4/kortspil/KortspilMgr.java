package dk.zbc.h4.kortspil;
import java.util.ArrayList;

/**
 *
 * @author runra
 */
public abstract class KortspilMgr {

	protected int activePlayerIndex = -1;
    public abstract void startSpil();
    public abstract void slutSpil();
    public ArrayList<Kort> blandKort(ArrayList<Kort> deck) {return null;} 

    public void tilfojSpiller(Spiller spiller) {
        spillerListe.add(spiller);
    }
    public boolean spilStartet() {
        if(activePlayerIndex != -1) {
            return true;
        }else{
            return false;
        }
    }
}
