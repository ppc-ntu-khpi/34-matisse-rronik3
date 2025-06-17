public class Account {
    private String type;
    private double balance;
    private double overdraftOrInterestRate;

    public Account(String type, double balance, double overdraftOrInterestRate) {
        this.type = type;
        this.balance = balance;
        this.overdraftOrInterestRate = overdraftOrInterestRate;
    }

    @Override
    public String toString() {
        return type + ": $" + balance + ", " +
               (type.equalsIgnoreCase("Checking") ? "overdraft: $" : "interest rate: ") +
               overdraftOrInterestRate + "%";
    }
}
