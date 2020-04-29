package mental.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Expression {
    int id;
    Collection<Operation> data;
    int expectedValue;
    int providedValue;

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
    public Expression(){

    }
    public void FullDataToData(String FullData){
        String[] listeData=FullData.split(" ");
        Collection<Operation> data=new ArrayList<Operation>();
        for (int i=0;i<listeData.length;i=i+3){
            data.add(new Operation(1,Integer.parseInt(listeData[0]),Integer.parseInt(listeData[1]),Enum.valueOf(Operateur.class,listeData[2])));
        }
        this.data=data;
    }
    public void recupérerExpression(int difficulte) {
        Operation operation=new Operation();
        setData(operation.générerExpression(difficulte));
        setExpectedValue(operation.Calcul(getData()));
    }

    public Game évaluer(Game uneGame) {
        if (getExpectedValue() == getProvidedValue()) {

            uneGame.setScore(uneGame.getScore() + 5);
        }

    if (getExpectedValue()*2>getProvidedValue()) {
        uneGame.setScore(uneGame.getScore() - 3);
    }
    if(getExpectedValue()*3>getProvidedValue()) {
        uneGame.setScore(uneGame.getScore() - 6);
    }
    return uneGame;
}
public int évaluer(int expectValue,int provideValue){
        int score=0;
    if (expectValue == provideValue) {

        score=5;
    }

    if (expectValue*2>provideValue) {
        score=-3;
    }
    if(expectValue*3>provideValue) {
        score= - 6;
    }
    return score;
}

}
