package dk.zbc.h4.kortspil;
import java.util.ArrayList;

/**
 * Created by Niklas on 04-05-2015.
 */
public class Haand {
    private ArrayList<Kort> kort = new ArrayList<Kort>();
    public Kort tagKort(int index) {
        //TODO Skift værdi
        return null;
    }

    public Kort fjernKort(int index) {
        // TODO Skift værdi
        return null;
    }

    public Kort modtagKort(Kort kort) {
        // TODO Skift værdi
        this.kort.add(kort);
        return kort;
    }
}
