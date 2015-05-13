package dk.zbc.h4.kortspil.xml;

import dk.zbc.h4.kortspil.Deck;
import dk.zbc.h4.kortspil.Spiller;
import dk.zbc.h4.kortspil.Haand;
import dk.zbc.h4.kortspil.Kort;
import sun.security.provider.ConfigFile;
import java.util.ArrayList;

/**
 * Created by Niklas on 06-05-2015.
 */
public class XmlMgr {
    private static XmlMgr instance = null;
    
    private XmlMgr() {
        
    }
    
    public static XmlMgr getInstance() {
        if(instance == null) {
            instance = new XmlMgr();
        }
        return instance;
    }
    
    public String transformNumber(int number) {
        StringBuffer sb = new StringBuffer();
        sb.append(getHeader());
        sb.append("<number>" + number + "</number>");
        return sb.toString();
    }
    
    /**
     * @deprecated Use transformCard instead
     */
    public String transformKort(Deck dk) {
        StringBuffer sb = new StringBuffer();
        sb.append(getHeader());
        sb.append("<kortListe>");
        for(Kort k : dk) {
            sb.append(transformSingleCard(k));
        }
        sb.append("</kortListe>");
        return sb.toString();
    }
    
    public String transformCard(Deck dk) {
        StringBuffer sb = new StringBuffer();
        sb.append(getHeader());
        sb.append("<kortListe>");
        for(Kort k : dk) {
            sb.append(transformSingleCard(k));
        }
        sb.append("</kortListe>");
        return sb.toString();
    }
    
    public String transformCard(Kort card) {
        StringBuffer sb = new StringBuffer();
        sb.append(getHeader());
        sb.append(transformCard(card));
        return sb.toString();
    }
    
    public String transformError(String errorMessage) {
        StringBuffer sb = new StringBuffer();
        sb.append(getHeader());
        sb.append("<error>");
        sb.append(errorMessage);
        sb.append("</error>");
        return sb.toString();
    }
    
    public String transformNuvaerendeSpiller(Spiller spiller) {
        StringBuffer sb = new StringBuffer();
        sb.append(getHeader());
        sb.append("<spiller>");
        sb.append("<person>");
        sb.append("<navn>" + spiller.getNavn() + "</navn>");
        sb.append("<uid>" + spiller.getUserID() + "</uid>");
        sb.append("</person>");
        sb.append("</spiller>");
        
        return sb.toString();
    }
    
    private String getHeader() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    }
    
    private String transformSingleCard(Kort card) {
        return "<kort>\n" +
                "        <kuloer>" + card.getKuloer() + "</kuloer>\n" +
                "        <vaerdi>" + card.getVaerdi() + "</vaerdi>\n" +
                "                </kort>";
    }
}
