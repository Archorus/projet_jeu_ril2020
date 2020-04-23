package mental.bo;

import javax.xml.transform.Result;
import java.util.Random;

public class Operation {
    int id;
    int val1;
    int val2;
    Operateur operator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public Operateur getOperator() {
        return operator;
    }

    public void setOperator(Operateur operator) {
        this.operator = operator;
    }

    public Operation(int id, int val1, int val2, Operateur operator) {
        this.id = id;
        this.val1 = val1;
        this.val2 = val2;
        this.operator = operator;
    }
    public Operation(){

    }
    public Operation[] générerExpression(int difficulté) {

        int listeNombres = 0;
        switch (difficulté) {
            case 1:
                listeNombres = 1;
                break;
            case 2:
                listeNombres = 2;
                break;
            case 3:
                listeNombres = 4;
                break;
        }
        int unaire = (int) Math.random() * 2;
        //0= pas de unaire, 1=inv, 2=rac
        Operation[] Expressions = new Operation[listeNombres];
        String uneExpression = "";

        for (int i = 0; i < listeNombres; i++) {
            switch (i) {
                case 0:
                    Expressions[0].setVal1((int) (Math.random() * 9));
                    break;
                case 1:
                    Expressions[0].setOperator(générerBinaire());
                    break;
                case 2:
                    Expressions[0].setVal2((int) (Math.random() * 9));
                    break;
                case 3:
                    Expressions[1].setVal1((int) (Math.random() * 9));
                case 4:
                    Expressions[1].setOperator(générerBinaire());
                    break;
                case 5:
                    Expressions[1].setVal2((int) (Math.random() * 9));
                    break;
                case 6:
                    Expressions[2].setOperator(générerUnaire());
            }
        }

        return Expressions;
    }
    public Operateur générerBinaire(){

        int binaireAleatoire = (int)(Math.random()*3);
        Operateur binaire= Operateur.PLUS;
        switch(binaireAleatoire) {
            case 0:
                binaire =Operateur.PLUS;
                break;
            case 1:
                binaire =Operateur.MOINS;
            case 2:
                binaire =Operateur.MULTIPLIER;
                break;
            case 3:
                binaire=Operateur.DIVISER;
                break;
        }
        return binaire;
    }
    public Operateur générerUnaire(){
        Operateur unaire=Operateur.INV;
        int unaireAleatoire=(int)(Math.random()*2);
        switch(unaireAleatoire) {
            case 0:
                unaire=Operateur.INV;
                break;
            case 1:
                unaire=Operateur.RAC;
                break;

        }
        return unaire;
    }
    public static int Calcul(Operation[] Expression) {
        int Resultat = 0;

        for (Operation uneExpression:Expression) {
            switch(uneExpression.getOperator()) {
                case PLUS:
                    Resultat = Resultat + (uneExpression.getVal1() + uneExpression.getVal2());
                    break;
                case MOINS:
                    Resultat = Resultat + (uneExpression.getVal1() - uneExpression.getVal2());
                    break;
                case MULTIPLIER:
                    Resultat = Resultat + (uneExpression.getVal1() + uneExpression.getVal2());
                    break;
                case DIVISER:
                    Resultat = Resultat + (uneExpression.getVal1() + uneExpression.getVal2());
                    break;
                case INV:
                    Resultat= Resultat/Resultat;
                    break;
                case RAC:
                    Resultat=Resultat*Resultat;
                    break;
            }
        }
        return Resultat;
    }
}
