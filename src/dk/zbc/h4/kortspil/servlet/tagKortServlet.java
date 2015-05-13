package dk.zbc.h4.kortspil.servlet;
import dk.zbc.h4.kortspil.SorteperMgr;
import dk.zbc.h4.kortspil.Spiller;
import dk.zbc.h4.kortspil.Kort;
import dk.zbc.h4.kortspil.xml.XmlMgr;
import javax.ejb.Init;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zbcdaso14 on 07-05-2015.
 */
public class tagKortServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        //TODO denne metode skal ikke kaldes her
        SorteperMgr.getInstance().startSpil();
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }
    
    // Outputs amount of cards for next player
    private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Get session ID of current player
        // Get current player
        String sessionId = "1";
        Spiller thisSpiller = SorteperMgr.getInstance().getSpiller(sessionId);
        
        String content = "";
        int takenCardIdx = -1;
        
        // Check if parameter was given
        if(req.getParameter("card")!= null) {
            
            // Get card
            takenCardIdx = Integer.parseInt(req.getParameter("card"));
            
            // Get previous player
            int prevPlayerIdx = SorteperMgr.getInstance().getPreviousPlayerIndex(thisSpiller);
            Spiller prevPlayer = SorteperMgr.getInstance().getPlayerByIndex(prevPlayerIdx);
            
            // Check takenCardIdx range (0 - prevPlayer card count)
            if ((takenCardIdx >= 0) && (takenCardIdx <= (prevPlayer.getHaand().size() - 1))) {
                
                // Get card from previous player, transfer card, return card
                Kort prevPlayerCard = prevPlayer.getHaand().get(takenCardIdx);
                prevPlayer.getHaand().remove(prevPlayerCard);
                thisSpiller.getHaand().add(prevPlayerCard);
                content = XmlMgr.getInstance().transformCard(prevPlayerCard);
            }
            else {
                // Return "Out of bounds" error (takenCardIdx)
                content = XmlMgr.getInstance().transformError("Card index out of bounds!\n"
                        + "Min: 0, "
                        + "Max: " + (prevPlayer.getHaand().size() - 1) + ", "
                        + "Value: " + takenCardIdx + ".");
            }
        }
        else {
            // Return "Card unspecified" error (parameter)
            content = XmlMgr.getInstance().transformError("Card unspecified!");
        }
        
        // Set content type & print
        resp.setContentType("text/xml");
        resp.getOutputStream().print(content);
    }
}
