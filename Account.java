public class Account {

    private String number;
    private double balance;
    private Client client;

    public Account(String number, Client client) {
        this.number = number;
        this.client = client;
        this.balance = 0;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return this.balance;
    }

    public Client getClient() {
        return client;
    }

    public void deposit(double value) {
        this.balance = this.balance + value;
        System.out.print("deposit successfully!");
    }

    public void withdraw(double value) {
        if (getBalance() < value) {
            System.out.println("Insufficient balance!");

        } else {
            System.out.println("Withdraw successfully!");
        }
    }

    @Override
    public String toString() {
        return String.format("Number: %s, Balance: %s, Client: %s", getNumber(), getBalance(), getClient());
    }
}

