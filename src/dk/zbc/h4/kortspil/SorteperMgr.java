/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.zbc.h4.kortspil;

import java.util.ArrayList;

/**
 *
 * @author runra
 */
public class SorteperMgr extends KortspilMgr {



    public void startSpil() {

        Deck dk = new Deck();
        for (int i = 0; i <= 13; i++) {
            for(int kuloer = 0; kuloer <= 4; kuloer++) {

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
    };
    public void slutSpil() {};
    
}
