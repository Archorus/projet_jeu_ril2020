package mental.model;

import mental.bo.Expression;
import mental.bo.Game;
import mental.bo.Operation;
import mental.bo.Utilisateur;
import mental.dal.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

public class JeuBean implements Serializable {
    private Expression uneExpression;



    private String fullExpression;
    private int uneGame;
    private int difficulte;
    private int score;
    private Collection<Game> gameBestScore;

    public void NouveauJeu(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession( true );
        Operation operation = new Operation();
        difficulte = Integer.parseInt(request.getParameter("difficulte"));
        uneExpression = new Expression(1, operation.générerExpression(difficulte));
        fullExpression=uneExpression.getFullData();
        int gameId=newIdGame();
        Utilisateur user=(Utilisateur)session.getAttribute("currentUser");
        DAOFactory.getGameDAO().create(new Game(newIdGame(),0,1,user.getId(),difficulte));
        request.setAttribute("expectedValue", uneExpression.getExpectedValue());

        session.setAttribute("uneGame",gameId);

    }

    public boolean jeuSuivant(HttpServletRequest request) {
        boolean result = true;
        uneGame = Integer.parseInt(request.getParameter("uneGame"));
        if (uneGame != 10) {
            Operation operation = new Operation();
            score = Integer.parseInt(request.getParameter("expectedValue"));
            uneGame = Integer.parseInt(request.getParameter("uneGame"));
            uneExpression = new Expression(1, operation.générerExpression(difficulte));
            request.setAttribute("expectedValue", uneExpression.getExpectedValue());
            request.setAttribute("uneGame", uneGame++);
        } else {
            result = false;
        }
        return result;
    }
    public int newIdGame(){
        int newId=0;
        Collection<Game> lesGames=DAOFactory.getGameDAO().findAll();
        for (Game uneGame:lesGames) {
            newId=uneGame.getId();
        }
        return newId++;
    }
    public void loadBestScore(HttpServletRequest request) {
        gameBestScore = DAOFactory.getGameDAO().findBestScore();
    }

    public Expression getUneExpression() {
        return uneExpression;
    }

    public void setUneExpression(Expression uneExpression) {
        this.uneExpression = uneExpression;
    }

    public int getUneGame() {
        return uneGame;
    }

    public void setUneGame(int uneGame) {
        this.uneGame = uneGame;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Collection<Game> getGameBestScore() {
        return gameBestScore;
    }

    public void setGameBestScore(Collection<Game> gameBestScore) {
        this.gameBestScore = gameBestScore;
    }
    public String getFullExpression() {
        return fullExpression;
    }

    public void setFullExpression(String fullExpression) {
        this.fullExpression = fullExpression;
    }
}
