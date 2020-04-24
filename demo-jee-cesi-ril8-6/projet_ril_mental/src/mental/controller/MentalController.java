package mental.controller;

import mental.bo.Expression;
import mental.model.JeuBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet( name = "mentalController", urlPatterns = {"/jeu","/score"}, loadOnStartup = 1 )
public class MentalController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger( MentalController.class.getName() );
    @Override
    public void init() throws ServletException {

    }

    @Override
    public void destroy() {
        LOGGER.log( Level.INFO, "Destruction de notre servlet LoginController" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JeuBean jeuBean= (JeuBean) req.getAttribute("jeuBean");

        if ( jeuBean == null ) {
            jeuBean = new JeuBean();
            req.setAttribute("jeuBean",jeuBean);
        }
        String path=req.getServletPath();
        System.out.println(path+"coucou");
        switch(path) {
            case "/jeu":
                System.out.println("hey");
                if(req.getParameter("from").equals("accueil")){
                req.setAttribute("difficulte",req.getParameter("difficulte"));
                jeuBean.NouveauJeu(req);
                req.getServletContext().getRequestDispatcher( "/WEB-INF/view/jeux.jsp" ).forward( req, resp );
                }else{
                    System.out.println("lol");
                    req.setAttribute("difficulte",req.getParameter("difficulte"));
                    req.setAttribute("uneGame",req.getParameter("uneGame"));
                    if(jeuBean.jeuSuivant(req)){
                        req.getServletContext().getRequestDispatcher( "/WEB-INF/view/jeux.jsp" ).forward( req, resp );
                    }else{
                        resp.sendRedirect(req.getContextPath()+"/score");
                    }
                }
                break;
            case "/score":
                resp.sendRedirect(req.getContextPath()+"/score");
                break;
            default:
                req.getServletContext().getRequestDispatcher( "/WEB-INF/view/accueil.jsp" ).forward( req, resp );
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("from")+"????");
        if(!req.getParameter("from").equals("accueil")) {
            Expression expression = new Expression();
            req.setAttribute("score", expression.évaluer(Integer.parseInt(req.getParameter("expectedValue")), Integer.parseInt(req.getParameter("providedValue"))));
            req.setAttribute("difficulte", req.getParameter("difficulte"));
            req.setAttribute("uneGame", req.getParameter("uneGame"));
            doGet(req, resp);
        }else{
            req.setAttribute("difficulte", req.getParameter("difficulte"));
            req.setAttribute("uneGame", req.getParameter("uneGame"));
            doGet(req,resp);
        }

    }
}
