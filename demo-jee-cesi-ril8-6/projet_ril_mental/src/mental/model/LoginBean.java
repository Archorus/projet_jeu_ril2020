package mental.model;

import mental.bo.Utilisateur;
import mental.dal.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.io.Serializable;
import java.sql.SQLException;

public class LoginBean implements Serializable {

    private static final String LOGIN_SUCCESS = "ssylla";
    private static final String PWD_SUCCESS = "test123";

    private static final String FORM_FIELD_LOGIN = "login-username";
    private static final String FORM_FIELD_PWD = "login-password";
    private static final String CURRENT_USER_SESSION_KEY = "currentUser";
    private static final String FORM_FIELD_CREATE_LOGIN="create-username";
    private static final String FORM_FIELD_CREATE_PWD="create-password";

    private String login;
    private String password;
    private String createLogin;
    private String createPassword;

    private String message;

    public LoginBean() {}

    public boolean authenticate( HttpServletRequest request ) {
        login = request.getParameter( FORM_FIELD_LOGIN );
        password = request.getParameter( FORM_FIELD_PWD );
        createLogin = request.getParameter( FORM_FIELD_CREATE_LOGIN);
        createPassword=request.getParameter(FORM_FIELD_CREATE_PWD);
        boolean result = false;
        if(login!="" && password!="") {
            System.out.println("1");
                Utilisateur loginUtilisateur=new Utilisateur();
                loginUtilisateur.setName(login);
                loginUtilisateur.setPassword(password);
                Utilisateur user= DAOFactory.getUtilisateurDAO().authenticate(login,password);
                if (null == user) {
                    message = "Mauvais id, merci de recommencer!!!";
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute(CURRENT_USER_SESSION_KEY, user);
                    message = "Bienvenue à toi " + LOGIN_SUCCESS;
                    result = true;
                }
        }
        if(createLogin!=null && createPassword!=null) {
            try{
                Utilisateur createUtilisateur=new Utilisateur();
                createUtilisateur.setName(createLogin);
                createUtilisateur.setPassword(createPassword);
                DAOFactory.getUtilisateurDAO().create(createUtilisateur);

                /*    Utilisateur user= DAOFactory.getUtilisateurDAO().authenticate(createUtilisateur);
                    if(null==user) {
                        message="Mauvais id, merci de recommencer!!!";
                    }else {
                        HttpSession session = request.getSession(true);
                        session.setAttribute(CURRENT_USER_SESSION_KEY, user);
                        message = "Bienvenue à toi " + LOGIN_SUCCESS;
                        result = true;
                    }*/
                }catch(SQLException e) {
                message="Attention, une erreur est survenue";
            }
            }
        return result;
        }


    public boolean isAuthenticated( HttpServletRequest request ) {
        HttpSession session = request.getSession( true );
        return null != session.getAttribute( CURRENT_USER_SESSION_KEY );
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
}