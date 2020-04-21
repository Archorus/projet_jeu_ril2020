package mental.model;

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
}
