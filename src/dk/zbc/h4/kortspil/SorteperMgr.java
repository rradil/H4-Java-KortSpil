<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.zbc.h4.kortspil;

import java.util.ArrayList;
=======
package dk.zbc.h4.kortspil;
import java.util.Collections;
import java.util.Random;
>>>>>>> pr/4

/**
 *
 * @author runra
 */
public class SorteperMgr extends KortspilMgr {
<<<<<<< HEAD




    public void startSpil() {

        Deck dk = new Deck();
        for (int i = 0; i <= 13; i++) {
            for(int kuloer = 0; kuloer <= 4; kuloer++) {

=======
    
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
                
>>>>>>> pr/4
                if(kuloer == 1) {
                    dk.tilfoejKort(new Kort(i, Kort.Kuloer.HJERTER));
                }else if(kuloer == 2) {
                    dk.tilfoejKort(new Kort(i, Kort.Kuloer.KLOER));
                }else if(kuloer == 3) {
                    dk.tilfoejKort(new Kort(i, Kort.Kuloer.RUDER));
                }else if(kuloer == 4) {
                    dk.tilfoejKort(new Kort(i, Kort.Kuloer.SPAR));
                }
<<<<<<< HEAD
            }

        }
        dk.tilfoejKort(new Kort(15, Kort.Kuloer.JOKER));
    };
    public void slutSpil() {};

    
   private static SorteperMgr instance = null;
   protected SorteperMgr() {
      
   }
   public static SorteperMgr getInstance() {
      if(instance == null) {
         instance = new SorteperMgr();
      }
      return instance;
      
   }
   public void startSpil() {};
   /**
    * Denne metode kaldes når spillet skal afsluttes. 
    */
   public void slutSpil() {};
   
   public static void main(String[] args) {} 
   
}
    
=======
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

>>>>>>> pr/4
