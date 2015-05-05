/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.zbc.h4.kortspil;

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
   public void startSpil() {};
   /**
    * Denne metode kaldes når spillet skal afsluttes. 
    */
   public void slutSpil() {};
   
   public static void main(String[] args) {} 
   
}
    
