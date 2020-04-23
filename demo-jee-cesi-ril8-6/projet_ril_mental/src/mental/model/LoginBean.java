package mental.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.io.Serializable;
import java.sql.SQLException;

public class LoginBean implements Serializable {

    private static final String LOGIN_SUCCESS = "ssylla";
    private static final String PWD_SUCCESS = "test123";

    private static final String FORM_FIELD_LOGIN = "username";
    private static final String FORM_FIELD_PWD = "password";
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
        if(login!=null && password!=null) {
            try {
                User user = DAOFactory.getUserDAO().authenticate(login, password);
                if (null == user) {
                    message = "Mauvais id, merci de recommencer!!!";
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute(CURRENT_USER_SESSION_KEY, user);
                    message = "Bienvenue à toi " + LOGIN_SUCCESS;
                    result = true;
                }
            } catch (SQLException e) {
                message = "Attention, une erreur est survenue lors de l'accès à la base!!! ";
            }
        }
        if(createLogin!=null && createPassword!=null) {
            try{
                boolean newUser=DAOFactory.getUserDAO().createUtilisateur(createLogin,createPassword);
                if(false==newUser){
                    message="Des informations ont été oublié";
                }else {
                    User user=DAOFactory.getUserDAO().authenticate(createLogin,createPassword);
                    if(null==user) {
                        message="Mauvais id, merci de recommencer!!!";
                    }else {
                        HttpSession session=request.getSession(true);
                        session.setAttribute(CURRENT_USER_SESSION_KEY,user);
                        message="Bienvenue à toi "+ LOGIN_SUCCESS;
                        result=true;
                    }
                }
                }catch(SQLException e) {
                message="Attention, une erreur est surv"
            }
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