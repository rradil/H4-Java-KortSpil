package dk.zbc.h4.kortspil;

/**
 * Created by Niklas on 04-05-2015.
 */
public class Spiller {
    
    private String navn;
    private Haand hand;
    
    public Spiller(String navn) {
        this.navn = navn;
        this.hand = new Haand();
    }

    public String getNavn() {
        return navn;
    }

    //Findstik
}
