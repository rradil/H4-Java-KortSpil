package dk.zbc.h4.kortspil;
import sun.security.provider.ConfigFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 *
 * @author runra
 */
public class SorteperMgr extends KortspilMgr {
    
    private static SorteperMgr instance = null;
    private ArrayList<Spiller> spillerListe = null;
    
    private SorteperMgr() {
        spillerListe = new ArrayList<Spiller>();
    }

    public static SorteperMgr getInstance() {
        if(instance == null) {
            instance = new SorteperMgr();
        }
        return instance;
    }

    
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
        long seed = System.nanoTime();
        Collections.shuffle(dk, new Random(seed));
        System.err.println(dk.size());

        int intCounter = 0;

        for (int i = 0; i< dk.size(); i++){
            //Uddeler kort..
            for(Spiller s : spillerListe){
                //System.err.println(dk.size());
                if(intCounter < dk.size()) {
                    Kort k = dk.get(intCounter);
                    s.getHaand().tilfoejKort(k);
                    //dk.remove(i);
                    intCounter++;
                }
            }
            //dk.remove(i);
        }
        dk.clear();


            }

    public void slutSpil() {};

    public Spiller getSpiller(String sessionId) {
        Spiller returSpiller = null;
        for(Spiller s : spillerListe)
        {
            if(s.getUserID().equals(sessionId)) {
                returSpiller = s;
                break;
            }
        }
        return returSpiller;
    }

    public Spiller nuvaerendeSpiller() {
        return spillerListe.get(0);
    }

    public Spiller naesteSpiller() {
        return spillerListe.get(1);
    }
    public ArrayList<Spiller> flytSpillere() {
        return null;
    }

    public static void main(String[] args) {
        SorteperMgr.getInstance().startSpil();
    }
}

