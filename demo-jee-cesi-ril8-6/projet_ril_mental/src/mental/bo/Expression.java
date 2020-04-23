package mental.bo;

public class Expression {
    int id;
    Operation[] data;
    int expectedValue;
    int providedValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Operation[] getData() {
        return data;
    }
    public String getFullData(){
        Operation[] laData=getData();
        String fullData=laData.toString();
        return fullData;
    }

    public void setData(Operation[] data) {
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

    public Expression(int id, Operation[] data) {
        this.id = id;
        this.data = data;
        this.expectedValue = Operation.Calcul(data);
    }
    public Expression(){

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
