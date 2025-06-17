public class Customer {
    private String name;
    private Account[] accounts;

    public Customer(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        sb.append("--------------------\n");
        sb.append("Accounts:\n");
        for (int i = 0; i < accounts.length; i++) {
            sb.append("#").append(i).append(" - ").append(accounts[i]).append("\n");
        }
        return sb.toString();
    }
}
