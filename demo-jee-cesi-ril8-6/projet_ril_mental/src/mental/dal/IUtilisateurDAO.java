package mental.dal;

import mental.bo.Utilisateur;

import java.sql.SQLException;

public interface IUtilisateurDAO extends IDAO< Integer, Utilisateur > {
    Utilisateur authenticate (String login, String password);
    void create(Utilisateur utilisateur) throws SQLException;
}
