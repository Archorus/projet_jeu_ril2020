package mental.model;

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
}
