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
        
        // Shuffle
        long seed = System.nanoTime();
        Collections.shuffle(dk, new Random(seed));
        //System.err.println(dk.size());
        
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
    
    // TODO Rewrite
    public Spiller nuvaerendeSpiller() {
        return spillerListe.get(0);
    }
    
    public Spiller naesteSpiller() {
        return spillerListe.get(1);
    }
    public ArrayList<Spiller> flytSpillere() {
        return null;
    }
    
    /** Get playerList index number of previous player with cards
     * @param currentPlayer
     * @return Returns index number of previous player. Returns null if parameter is null.
     */
    public int getPreviousPlayerIndex(Spiller currentPlayer) {
        // Check if player isn't null
        if (currentPlayer != null) {
            int idx = spillerListe.indexOf(currentPlayer);
            int prevIdx = idx;
            boolean previousPlayerValid = false;
            
            while (previousPlayerValid == false)
            {
                // Get index of previous player
                if (idx == 0)
                    prevIdx = spillerListe.size() - 1;
                else
                    prevIdx = idx - 1;
                
                Spiller previousPlayer = spillerListe.get(prevIdx);
                
                // Check if player got cards
                if (previousPlayer.getHaand().size() != 0)
                    previousPlayerValid = true;
                else
                    idx--;
            }
            
            return prevIdx;
        }
        // Return error value -1 (No currentPlayer found)
        return -1;
    }
    
    /** Get playerList index number of next player with cards
     * @param currentPlayer
     * @return Returns index number of next player. Returns null if parameter is null.
     */
    public int getNextPlayerIndex(Spiller currentPlayer) {
        // Check if player isn't null
        if (currentPlayer != null) {
            int idx = spillerListe.indexOf(currentPlayer);
            int nextIdx = idx;
            boolean nextPlayerValid = false;
            
            while (nextPlayerValid == false)
            {
                // Get index of next player
                if (idx == spillerListe.size() -1)
                    nextIdx = 0;
                else
                    nextIdx = idx + 1;
                
                Spiller nextPlayer = spillerListe.get(nextIdx);
                
                // Check if player got cards
                if (nextPlayer.getHaand().size() != 0)
                    nextPlayerValid = true;
                else
                    idx++;
            }
            
            return nextIdx;
        }
        
        // Return error value -1 (No currentPlayer found)
        return -1;
    }
    
    /** Get player by playerList index number
     * @param index Index number of player
     * @return Returns player. Returns null if parameter is outside the bounds of the playerlist.
     */
    public Spiller getPlayerByIndex(int index) {
        // Check if index is between 0 and playerList count
        if ((index >= 0) && (index <= (spillerListe.size() - 1))) {
            // Get player by index
            Spiller player = spillerListe.get(index);       
            return player;
        }
        
        // Return null if index is outside playerList bounds.
        return null;
    }
    
    public static void main(String[] args) {
        SorteperMgr.getInstance().startSpil();
    }
}

