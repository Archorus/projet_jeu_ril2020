package mental.bo;

public class Expression {
    int id;
    String data;
    int expectedValue;
    int providedValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public Expression(int id, String data, int expectedValue, int providedValue) {
        this.id = id;
        this.data = data;
        this.expectedValue = expectedValue;
        this.providedValue = providedValue;
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

}
