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

        // Recieve targeted card from current player
        // Get current player
        // Get targeted card from previous player
        // Add card to current player
        // Remove card from previous player
        
        // TODO Get session ID of current player
        // TODO Handle "takenCard unspecified" properly (XML error?)
        // TODO Handle invalid "takenCardIdx"
        // TODO Return card
        // TODO Refactor transformKort XML method
        
        // Get current player
        String sessionId = "1";
        Spiller thisSpiller = SorteperMgr.getInstance().getSpiller(sessionId);
       
        // Get card
        int takenCardIdx = 0;
        if(req.getParameter("card")!= null)
            takenCardIdx = Integer.parseInt(req.getParameter("card"));
        else
            System.err.println("tagKortServlet: Card unspecified!");
        
        // Get card from previous player
        int prevPlayerIdx = SorteperMgr.getInstance().getPreviousPlayerIndex(thisSpiller);
        Spiller prevPlayer = SorteperMgr.getInstance().getPlayerByIndex(prevPlayerIdx);
        Kort prevPlayerCard = prevPlayer.getHaand().get(takenCardIdx);
        
        // Transfer card
        prevPlayer.getHaand().remove(prevPlayerCard);
        thisSpiller.getHaand().add(prevPlayerCard);
        
        // Return card to client
        //String content = XmlMgr.getInstance().transformKort(prevPlayerCard);
        resp.setContentType("text/xml");
        //resp.getOutputStream().print(content);
    }
}
