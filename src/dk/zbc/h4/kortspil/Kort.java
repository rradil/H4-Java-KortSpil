package dk.zbc.h4.kortspil;

/**
 * Created by Niklas on 04-05-2015.
 */
public class Kort {
    public int getVaerdi() {
        return vaerdi;
    }

    public void setVaerdi(int vaerdi) {
        this.vaerdi = vaerdi;
    }

    public Kuloer getKuloer() {
        return kuloer;
    }

    public void setKuloer(Kuloer kuloer) {
        this.kuloer = kuloer;
    }

    public static enum Kuloer {
        KLOER, HJERTER, SPAR, RUDER, JOKER
    }
    private int vaerdi;
    private Kuloer kuloer;

    public Kort(int vaerdi, Kuloer kuloer)
    {
        this.setKuloer(kuloer);
        this.setVaerdi(vaerdi);
    }


}
