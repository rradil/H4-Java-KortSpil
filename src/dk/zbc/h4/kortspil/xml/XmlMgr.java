package dk.zbc.h4.kortspil.xml;

import dk.zbc.h4.kortspil.Deck;
import dk.zbc.h4.kortspil.Haand;
import dk.zbc.h4.kortspil.Kort;

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

    public String transformKort(Deck dk) {
        StringBuffer sb = new StringBuffer();
        /* <kort>
        <kuloer>Tove</kuloer>
        <vaerdi>Jani</vaerdi>
                </kort>*/

        sb.append(getHeader());
        sb.append("<kortListe>");
        for(Kort k : dk) {
            sb.append("<kort>\n" +
                    "        <kuloer>" + k.getKuloer() + "</kuloer>\n" +
                    "        <vaerdi>" + k.getVaerdi() + "</vaerdi>\n" +
                    "                </kort>");
        }
        sb.append("</kortListe>");
        return sb.toString();
    }

    private String getHeader() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    }
}
