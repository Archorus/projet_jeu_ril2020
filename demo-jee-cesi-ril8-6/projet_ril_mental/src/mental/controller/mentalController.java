package mental.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet( name = "mentalController", urlPatterns = {"/accueil","/jeu","/score"}, loadOnStartup = 1 )
public class mentalController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger( mentalController.class.getName() );
    @Override
    public void init() throws ServletException {

    }

    @Override
    public void destroy() {
        LOGGER.log( Level.INFO, "Destruction de notre servlet LoginController" )
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getServletPath();
        switch(path) {
            case "accueil":
                resp.sendRedirect( req.getContextPath() + "/accueil" );
                break;
            case "jeu":
                resp.sendRedirect(req.getContextPath()+ "/jeu");
                break;
            case "score":
                resp.sendRedirect(req.getContextPath()+"/score");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
