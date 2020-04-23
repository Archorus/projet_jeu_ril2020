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
    public String générerExpression(int difficulté) {

        int listeNombres = 0;
        switch (difficulté) {
            case 1:
                listeNombres = 1;
                break;
            case 2:
                listeNombres = 3;
                break;
            case 3:
                listeNombres = 6;
                break;
        }
        int unaire = (int) Math.random() * 2;
        //0= pas de unaire, 1=inv, 2=rac
        String[] Expression = new String[listeNombres];
        String uneExpression = "";

        for (int i = 0; i < listeNombres; i++) {
            switch (i) {
                case 0:
                    Expression[0] = String.valueOf(((int) (Math.random() * 9)));
                    Expression[0]=Expression[0]+" ";
                    break;
                case 1:
                    Expression[1] = générerBinaire();
                    Expression[1]=Expression[1]+" ";
                    break;
                case 2:
                    Expression[2] = String.valueOf(((int) (Math.random() * 9)));
                    Expression[2]=Expression[2]+" ";
                    break;
                case 3:
                    Expression[3] = String.valueOf(((int) (Math.random() * 9)));
                    Expression[3]=Expression[3]+" ";
                case 4:
                    Expression[4] = générerBinaire();
                    Expression[4]=Expression[4]+" ";
                    break;
                case 5:
                    Expression[5] = String.valueOf(((int) (Math.random() * 9)));
                    Expression[5]=Expression[5]+" ";
                    break;
                case 6:
                    Expression[6] = générerUnaire();
            }
            Expression[i] = String.valueOf(((int) (Math.random() * 9)));
        }

        return Expression.toString();
    }
    public String générerBinaire(){

        int binaireAleatoire = (int)(Math.random()*3);
        String binaire="";
        switch(binaireAleatoire) {
            case 0:
                binaire ="+";
                break;
            case 1:
                binaire ="-";
            case 2:
                binaire ="*";
                break;
            case 3:
                binaire="/";
                break;
        }
        return binaire;
    }
    public String générerUnaire(){
        String unaire="";
        int unaireAleatoire=(int)(Math.random()*2);
        switch(unaireAleatoire) {
            case 0:
                unaire="inv";
                break;
            case 1:
                unaire="rac";

        }
        return unaire;
    }
    public int Calcul(String Expression) {
        int Resultat = 0;
        String[] uneExpression=Expression.split(" ");
        switch(uneExpression[1]) {
            case "+":
                Resultat = Resultat +(Integer.parseInt(uneExpression[0])+Integer.parseInt(uneExpression[2]));
                break;
            case "-":
                Resultat = Resultat +(Integer.parseInt(uneExpression[0])-Integer.parseInt(uneExpression[2]));
                break;
            case "*":
                Resultat = Resultat +(Integer.parseInt(uneExpression[0])*Integer.parseInt(uneExpression[2]));
                break;
            case "/":
                Resultat = Resultat +(Integer.parseInt(uneExpression[0])+Integer.parseInt(uneExpression[2]));
                break;
        }
        return Resultat;
    }
}
