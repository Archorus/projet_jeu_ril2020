package mental.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Expression {
    int id;
    Collection<Operation> data;
    int expectedValue;
    int providedValue;
    int gameId;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Expression(int id, Collection<Operation> data, int expectedValue, int providedValue, int gameId) {
        this.id = id;
        this.data = data;
        this.expectedValue = expectedValue;
        this.providedValue = providedValue;
        this.gameId = gameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Operation> getData() {
        return data;
    }
    public String getFullData(){
        Collection<Operation> laData=getData();
        String fullData="";
        for (Operation uneData:laData) {
            fullData=fullData+uneData.getVal1()+" ";
            fullData=fullData+uneData.getOperator()+" ";
            fullData=fullData+uneData.getVal2()+" ";
        }
        return fullData;
    }

    public void setData(Collection<Operation> data) {
        this.data = data;
    }

    public int getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(int expectedValue) {
        this.expectedValue = expectedValue;
    }

    public int getProvidedValue() {
        return providedValue;
    }

    public void setProvidedValue(int providedValue) {
        this.providedValue = providedValue;
    }

    public Expression(int id, Collection<Operation> data) {
        this.id = id;
        this.data = data;
        this.expectedValue = Operation.Calcul(data);
    }
    public Expression(int id,String fulldata,int expectedValue,int providedValue){
        this.id=id;
        FullDataToData(fulldata);
        this.expectedValue=expectedValue;
        this.providedValue=providedValue;
    }
    public Expression(int id,String fulldata,int expectedValue,int providedValue,int gameId){
        this.id=id;
        FullDataToData(fulldata);
        this.expectedValue=expectedValue;
        this.providedValue=providedValue;
        this.gameId=gameId;
    }
    public Expression(){

    }
    public void FullDataToData(String FullData){
        String[] listeData=FullData.split(" ");
        Collection<Operation> data=new ArrayList<Operation>();
        Operateur operator=Operateur.PLUS;
        for (int i=0;i<listeData.length;i=i+3){
            switch(listeData[1]){
                case "MULTIPLIER":
                    operator=Operateur.MULTIPLIER;
                    break;
                case "PLUS":
                    operator=Operateur.PLUS;
                    break;
                case "MOINS":
                    operator=Operateur.MOINS;
                    break;
                case "DIVISER":
                    operator=Operateur.DIVISER;
                    break;
                case "INV":
                    operator=Operateur.INV;
                    break;
                case "RAC":
                    operator=Operateur.RAC;
                    break;
            }
            data.add(new Operation(1,Integer.parseInt(listeData[0]),Integer.parseInt(listeData[2]),operator));
        }
        this.data=data;
    }
    public void recupérerExpression(int difficulte) {
        Operation operation=new Operation();
        setData(operation.générerExpression(difficulte));
        setExpectedValue(operation.Calcul(getData()));
    }

public int évaluer(int expectValue,int provideValue){
        int score=0;
    if (expectValue == provideValue) {

        score=5;
    }else {
        if(expectValue>provideValue*2){
            score=-3;
        }
        if(expectValue*2<provideValue){
            score=-4;
        }
    }

    return score;
}

}
