package mental.model;

import mental.bo.Expression;
import mental.bo.Game;
import mental.bo.Operation;
import mental.dal.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;

public class JeuBean implements Serializable {
    private Expression uneExpression;



    private String fullExpression;
    private int uneGame;
    private int difficulte;
    private int score;
    private Collection<Game> gameBestScore;

    public void NouveauJeu(HttpServletRequest request) {
        Operation operation = new Operation();
        difficulte = Integer.parseInt(request.getParameter("difficulte"));
        uneExpression = new Expression(1, operation.générerExpression(difficulte));
        fullExpression=uneExpression.getFullData();
        request.setAttribute("expectedValue", uneExpression.getExpectedValue());
        request.setAttribute("score", 0);
        request.setAttribute("uneGame", 0);

    }

    public boolean jeuSuivant(HttpServletRequest request) {
        System.out.println("vieuxjeu");
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
