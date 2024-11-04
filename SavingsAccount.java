public class SavingsAccount extends Account {

    private double fees;

    public SavingsAccount(String number, Client client) {
        super(number, client);
        this.fees = 0.05;
    }


    public double getFees() {
        return fees;
    }


    @Override
    public String toString() {
        return String.format("Number: %s, Balance: %s, Client: %s, Fees: %.2f", getNumber(), getBalance(), getClient(), this.fees);
    }
}