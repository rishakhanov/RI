package bank;

public class Account {
    double value;
    String requisites;

    public Account() {
    }

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public boolean transfer(Account dst, double amount) {
        boolean result = false;
        if (this.value >= amount) {
            dst.value += amount;
            this.value -= amount;
            result = true;
        }
        return result;
    }
}
