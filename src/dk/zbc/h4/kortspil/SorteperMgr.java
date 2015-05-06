package dk.zbc.h4.kortspil;
import java.util.ArrayList;
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

    private ArrayList<Spiller> spillerListe = new ArrayList<Spiller>();
    
    public void startSpil() {

        spillerListe.add(new Spiller("Niklas", "1"));
        spillerListe.add(new Spiller("Daniel", "2"));
        spillerListe.add(new Spiller("Patrick", "3"));
        spillerListe.add(new Spiller("Louise", "4"));



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

        while (dk.size() > 0) {
            //Uddeler kort..
            for(Spiller s : spillerListe){
                Kort k = dk.get(0);
                dk.remove(0);
                s.getHaand().tilfoejKort(k);
            }
        }

                long seed = System.nanoTime();
                Collections.shuffle(dk, new Random(seed));


            }

    public void slutSpil() {};

    public static void main(String[] args) {
        SorteperMgr.getInstance().startSpil();
    }
}

