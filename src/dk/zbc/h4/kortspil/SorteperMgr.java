package dk.zbc.h4.kortspil;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author runra
 */
public class SorteperMgr extends KortspilMgr {
    
    private static SorteperMgr instance = null;
    
    protected SorteperMgr() {
        
    }
    
    public static SorteperMgr getInstance() {
        if(instance == null) {
            instance = new SorteperMgr();
        }
        return instance;
    }
    
    public void startSpil() {
        
        Deck dk = new Deck();
        for (int i = 1; i <= 13; i++) {
            for(int kuloer = 1; kuloer <= 4; kuloer++) {
                
                if(kuloer == 1) {
                    dk.tilfoejKort(new Kort(i, Kort.Kuloer.HJERTER));
                }else if(kuloer == 2) {
                    dk.tilfoejKort(new Kort(i, Kort.Kuloer.KLOER));
                }else if(kuloer == 3) {
                    dk.tilfoejKort(new Kort(i, Kort.Kuloer.RUDER));
                }else if(kuloer == 4) {
                    dk.tilfoejKort(new Kort(i, Kort.Kuloer.SPAR));
                }
            }    
        }
        dk.tilfoejKort(new Kort(15, Kort.Kuloer.JOKER));
        
        // Print, shuffle, print
        for (Kort k : dk)
        {
            System.out.println(k.toString());
        }
        
        System.out.println();
        long seed = System.nanoTime();
        Collections.shuffle(dk, new Random(seed));
        
        for (Kort k : dk)
        {
            System.out.println(k.toString());
        }
    }
    
    public void slutSpil() {}
    
    public static void main(String[] args) {
        SorteperMgr.getInstance().startSpil();
    }
}

