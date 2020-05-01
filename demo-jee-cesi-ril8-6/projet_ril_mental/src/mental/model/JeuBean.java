package mental.model;

import mental.bo.Expression;
import mental.bo.Game;
import mental.bo.Operation;
import mental.bo.Utilisateur;
import mental.dal.DAOFactory;

import javax.servlet.http.HttpServlet;
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
    private int nbExpression;
    private int score;
    private Collection<Game> gameBestScore;

    public void NouveauJeu(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession( true );
        Operation operation = new Operation();
        difficulte = Integer.parseInt(request.getParameter("difficulte"));
        uneExpression = new Expression(newIdExpression(), operation.générerExpression(difficulte));
        fullExpression=uneExpression.getFullData();
        int gameId=newIdGame();
        uneExpression.setGameId(gameId);
        Utilisateur user=(Utilisateur)session.getAttribute("currentUser");
        DAOFactory.getGameDAO().create(new Game(newIdGame(),0,1,user.getId(),difficulte));
        DAOFactory.getExpressionDAO().create(uneExpression);
        nbExpression=1;
        request.setAttribute("expectedValue", uneExpression.getExpectedValue());
        request.setAttribute("nbExpression",nbExpression);
        request.setAttribute("uneGame",gameId);
    }

    public boolean jeuSuivant(HttpServletRequest request) throws SQLException {
        boolean result = true;
        HttpSession session = request.getSession( true );
        uneGame = Integer.parseInt(request.getParameter("uneGame"));
        nbExpression=Integer.parseInt(request.getParameter("nbExpression"));
        difficulte=Integer.parseInt(request.getParameter("difficulte"));
        if (nbExpression != 10) {
            Operation operation = new Operation();
            score = Integer.parseInt(request.getParameter("score"));
            uneExpression = new Expression(newIdExpression(), operation.générerExpression(difficulte));
            uneExpression.setGameId(uneGame);
            fullExpression=uneExpression.getFullData();
            DAOFactory.getExpressionDAO().create(uneExpression);
            request.setAttribute("expectedValue", uneExpression.getExpectedValue());
            request.setAttribute("nbExpression", nbExpression++);
        } else {
            result = false;
        }
        return result;
    }
    public void afficherScore(HttpServletRequest request) throws SQLException{
        Game laGame=DAOFactory.getGameDAO().findById(Integer.parseInt(request.getParameter("uneGame")));
        score=laGame.getScore();
    }
    public int updateScore(int score,int id) throws SQLException {
        return DAOFactory.getGameDAO().updateScore(score,id);
    }
    public int getNbExpression() {
        return nbExpression;
    }

    public void setNbExpression(int nbExpression) {
        this.nbExpression = nbExpression;
    }
    public int newIdGame(){
        int newId=0;
        Collection<Game> lesGames=DAOFactory.getGameDAO().findAll();
        for (Game uneGame:lesGames) {
            newId=uneGame.getId();
        }
        return newId++;
    }
    public int newIdExpression(){
        int newId=0;
        Collection<Expression> lesExpressions=DAOFactory.getExpressionDAO().findAll();
        for(Expression uneExpression:lesExpressions){
            newId=uneExpression.getId();
        }
        return  newId++;
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
