package mental.dal;

import mental.bo.Utilisateur;

import java.sql.SQLException;

public interface IUtilisateurDAO extends IDAO< Integer, Utilisateur > {
    Utilisateur authenticate (Utilisateur utilisateur);
    void create(Utilisateur utilisateur) throws SQLException;
}
