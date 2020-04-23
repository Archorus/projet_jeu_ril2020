package mental.model;

import mental.bo.Expression;
import mental.bo.Game;
import mental.bo.Operation;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class JeuBean implements Serializable {
    private Expression uneExpression;
    private int uneGame;
    private int difficulté;
    private int score;

    public void NouveauJeu(HttpServletRequest request){
        System.out.println("nouveauJouer");
        Operation operation=new Operation();
        difficulté= Integer.parseInt(request.getParameter("difficulte"));

        uneExpression=new Expression(1,operation.générerExpression(difficulté));
        request.setAttribute("expectedValue",uneExpression.getExpectedValue());
        request.setAttribute("score",0);
        request.setAttribute("uneGame",0);

    }
    public boolean jeuSuivant(HttpServletRequest request){
        System.out.println("vieuxjeu");
        boolean result=true;
        uneGame= Integer.parseInt(request.getParameter("uneGame"));
        if(uneGame!=10) {
            Operation operation=new Operation();
            score=Integer.parseInt(request.getParameter("expectedValue"));
            uneGame=Integer.parseInt(request.getParameter("uneGame"));
            uneExpression=new Expression(1,operation.générerExpression(difficulté));
            request.setAttribute("expectedValue",uneExpression.getExpectedValue());
            request.setAttribute("uneGame", uneGame++);
        }else{
            result=false;
        }
        return result;
    }
}
