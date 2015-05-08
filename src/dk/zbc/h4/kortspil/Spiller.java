package dk.zbc.h4.kortspil;

/**
 * Created by Niklas on 04-05-2015.
 */
public class Spiller {
    
    private String navn;
    private Haand hand;
    private String userID;
    private boolean dinTur;
    
    public Spiller(String navn, String userID) {
        this.navn = navn;
        this.hand = new Haand();
        this.userID = userID;
        this.dinTur = false;
    }

    public String getNavn() {
        return navn;
    }



    public String getUserID() {
        return userID;
    }
    //TODO
    //finduserID

    public Haand getHaand() { return hand; }

    public boolean isDinTur() {
        return dinTur;
    }

    public void setDinTur(boolean dinTur) {
        this.dinTur = dinTur;
    }
}
