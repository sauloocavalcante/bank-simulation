import java.util.ArrayList;

public class AccountManager {

    private final ArrayList<Client> clients;
    private final ArrayList<Account> accounts;
    private final ArrayList<SavingsAccount> savingsAccounts;

    public AccountManager() {
        this.clients = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.savingsAccounts = new ArrayList<>();
    }


    public boolean clientExists(String cpf) {
        for (Client client : clients) {
            if (client.getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
    }


    public boolean accountNumberExists(String number) {
        if (accountExists(number) || savingsAccountExists(number)) {
            return true;
        }
        return false;
    }


    public boolean accountExists(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equalsIgnoreCase(number)) {
                return true;
            }
        }
        return false;
    }


    public boolean savingsAccountExists(String number) {
        for (SavingsAccount savingsAccount : savingsAccounts) {
            if (savingsAccount.getNumber().equalsIgnoreCase(number)) {
                return true;
            }
        }
        return false;
    }


    public Client getClientByCpf(String cpf) {
        for (Client client : clients) {
            if (client.getCpf().equalsIgnoreCase(cpf)) {
                return client;
            }
        }
        return null;
    }


    public Account getAnyAccountByNumber(String number) {
        Account account = getAccountByNumber(number);
        if (account == null) {
            account = getSavingsAccountByNumber(number);
        }
        return account;
    }


    public Account getAccountByNumber(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equalsIgnoreCase(number)) {
                return account;
            }
        }

        return null;
    }


    public SavingsAccount getSavingsAccountByNumber(String number) {
        for (SavingsAccount savingsAccount : savingsAccounts) {
            if (savingsAccount.getNumber().equalsIgnoreCase(number)) {
                return savingsAccount;
            }
        }
        return null;
    }


    public void createClient(String name, String cpf) {
        if (!clientExists(cpf)) {
            Client client = new Client(name, cpf);
            clients.add(client);
            System.out.println("Client created successfully!");
        } else {
            System.out.println("The client already exists.");
        }
    }


    public void createAccount(String number, Client client) {
        if (!clientExists(client.getCpf())) {
            System.out.println("The client doesn't exists.");
        }
        else if (accountNumberExists(number)) {
            System.out.println("The account already exists.");
        } else {
            Account account = new Account(number, client);
            accounts.add(account);
            System.out.println("Account created successfully!");
        }
    }


    public void createSavingsAccount(String number, Client client) {
        if (!clientExists(client.getCpf())) {
            System.out.println("Client doesn't exist.");
        } else if (accountNumberExists(number)) {
            System.out.println("The account number already exists.");
        } else {
            SavingsAccount savings = new SavingsAccount(number, client);
            savingsAccounts.add(savings);
            System.out.println("Savings account created successfully!");
        }
    }


    public void deposit(String number, double value) {
        Account account = getAnyAccountByNumber(number);
        if (account != null) {
            account.deposit(value);
            System.out.println("Deposit successfully!");
        } else {
            System.out.println("Account doesn't exist.");
        }
    }


    public void transfer(String originAccountNumber, String recipientAccountNumber, double value) {
        Account originAccount = getAnyAccountByNumber(originAccountNumber);
        Account recipientAccount = getAnyAccountByNumber(recipientAccountNumber);

        if (originAccount == null) {
            System.out.println("Origin account doesn't exists.");
        } else if (recipientAccount == null) {
            System.out.println("Recipient account doesn't exist.");
        } else if (originAccount.getBalance() < value) {
            System.out.println("Insufficient balance.");
        } else {
            originAccount.withdraw(value);
            recipientAccount.deposit(value);
            System.out.println("Transfer successfully!");
        }
    }


    public String balanceConsultAccount(String number) {
        if (accountExists(number)) {
            Account account = this.getAccountByNumber(number);
            double balance = account.getBalance();
            return String.format("Account's balance: R$%.2f",balance);
        } else if (savingsAccountExists(number)) {
            SavingsAccount savingsAccount = this.getSavingsAccountByNumber(number);
            double balance = savingsAccount.getBalance();
            return String.format("Account's balance: R$%.2f",balance);
        } else {
            return "Account not found.";
        }
    }


    public void interestIncome(String number) {
        SavingsAccount account = getSavingsAccountByNumber(number);
        if (account != null) {
            double balance = account.getBalance();
            double fees = account.getFees();
            account.deposit(balance * fees);
            System.out.println("Interest income successfully realized.");
        } else {
            System.out.println("Account doesn't exist.");
        }
    }


    public void line() {
        System.out.println("-".repeat(30));
    }
}