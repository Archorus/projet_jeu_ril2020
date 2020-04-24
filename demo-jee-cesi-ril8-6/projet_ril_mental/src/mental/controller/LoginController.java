package mental.controller;

import mental.model.LoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet( name = "loginController", urlPatterns = {"/login"}, loadOnStartup = 1 )
public class LoginController extends HttpServlet {

    public static final String LOGIN_URL_PATTERN = "/login";
    private static final String LOGIN_JSP = "/WEB-INF/view/connexion.jsp";
    private static final String HOME_URL_PATTERN = "/accueil";
    private static final Logger LOGGER = Logger.getLogger( LoginController.class.getName() );


    @Override
    public void init() throws ServletException {
    }

    @Override
    public void destroy() {
        LOGGER.log( Level.INFO, "Destruction de notre servlet LoginController" );
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        LoginBean model = new LoginBean();
        if ( model.isAuthenticated( request ) ) {
            response.sendRedirect( request.getContextPath() + HOME_URL_PATTERN );
        } else {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher( LOGIN_JSP );
            dispatcher.forward( request, response );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        LoginBean model = new LoginBean();
        request.setAttribute( "loginBean", model );
        if ( model.authenticate( request ) ) {
            response.sendRedirect( request.getContextPath() + HOME_URL_PATTERN );
        } else {
            doGet( request, response );
        }
    }
}
