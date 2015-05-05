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
public abstract class KortspilMgr {
    public abstract void startSpil();
    public abstract void slutSpil();
    public ArrayList<Kort> blandKort(ArrayList<Kort> deck) {return null;} 
}
