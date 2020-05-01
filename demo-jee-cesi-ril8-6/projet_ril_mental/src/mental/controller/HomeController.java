package mental.controller;

import mental.bo.Expression;
import mental.model.JeuBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "homeController", urlPatterns = {"/accueil"}, loadOnStartup = 1)
public class HomeController extends HttpServlet {
    private static final String ACCUEIL_JSP = "/WEB-INF/view/accueil.jsp";
    private static final String JEU_JSP="/WEB-INF/view/jeux.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JeuBean jeuBean = (JeuBean) req.getAttribute("jeuBean");
        if ( jeuBean == null ) {
            jeuBean = new JeuBean();
            req.setAttribute("jeuBean",jeuBean);
        }
        jeuBean.loadBestScore(req);

        req.getServletContext().getRequestDispatcher( ACCUEIL_JSP ).forward( req, resp );

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Expression expression = new Expression();
                req.setAttribute("score", req.getParameter("score")+expression.évaluer((int) req.getAttribute("expectedValue"), (int) req.getAttribute("providedValue")));
                req.setAttribute("difficulte", req.getParameter("difficulte"));
                req.setAttribute("uneGame", req.getParameter("uneGame"));
        req.getServletContext().getRequestDispatcher( JEU_JSP ).forward( req, resp );

    }
}
