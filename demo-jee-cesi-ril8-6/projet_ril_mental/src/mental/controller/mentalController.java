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


@WebServlet( name = "mentalController", urlPatterns = {"/accueil","/jeu","/score"}, loadOnStartup = 1 )
public class mentalController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger( mentalController.class.getName() );
    @Override
    public void init() throws ServletException {

    }

    @Override
    public void destroy() {
        LOGGER.log( Level.INFO, "Destruction de notre servlet LoginController" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JeuBean jeuBean=(JeuBean)req.getAttribute("jeuBean");

        System.out.println("coucou");
        jeuBean=new JeuBean();
        String path=req.getServletPath();
        switch(path) {
            case "jeu":
                System.out.println("hey");
                if(req.getAttribute("from")=="accueil"){
                req.setAttribute("difficulte",req.getParameter("difficulte"));
                System.out.println("dansjeu");
                jeuBean.NouveauJeu(req);
                    resp.sendRedirect(req.getContextPath()+ "/jeu");
                }else{
                    System.out.println("lol");
                    req.setAttribute("difficulte",req.getParameter("difficulte"));
                    req.setAttribute("uneGame",req.getParameter("uneGame"));
                    if(jeuBean.jeuSuivant(req)){
                        resp.sendRedirect(req.getContextPath()+ "/jeu");
                    }else{
                        resp.sendRedirect(req.getContextPath()+"/score");
                    }
                }
                break;
            case "score":
                resp.sendRedirect(req.getContextPath()+"/score");
                break;
            default:
                System.out.println("yo");
                req.getServletContext().getRequestDispatcher( "/WEB-INF/view/accueil.jsp" ).forward( req, resp );
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getServletPath();
        System.out.println("2");
        switch(path){
            case "jeu":
                Expression expression=new Expression();
                req.setAttribute("score",expression.évaluer((int)req.getAttribute("expectedValue"),(int)req.getAttribute("providedValue")));
                req.setAttribute("difficulte",req.getParameter("difficulte"));
                req.setAttribute("uneGame",req.getParameter("uneGame"));
                doGet(req,resp);
            break;
        }
    }
}
