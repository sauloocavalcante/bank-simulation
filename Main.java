import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();

        while (true) {
            System.out.println("[1] CREATE CLIENT \n" +
                    "[2] CREATE ACCOUNT \n" +
                    "[3] CREATE SAVINGS ACCOUNT \n" +
                    "[4] DEPOSIT \n" +
                    "[5] BALANCE CONSULT \n" +
                    "[6] TRANSFER \n" +
                    "[7] INTEREST INCOMES \n" +
                    "[8] EXIT");
            accountManager.line();

            System.out.print("Select an option: ");
            int choice = in.nextInt();
            in.nextLine();
            while (choice > 8 || choice < 1) {
                System.out.print("Invalid option. Try again!: ");
                choice = in.nextInt();
                in.nextLine();
            }

            if (choice == 1) {
                System.out.print("Name: ");
                String name = in.nextLine();

                System.out.print("CPF: ");
                String cpf = in.nextLine();

                accountManager.createClient(name, cpf);
                accountManager.line();

            } else if (choice == 2) {
                System.out.print("Number: ");
                String number = in.nextLine();

                System.out.print("Client's CPF: ");
                String cpf = in.nextLine();

                Client client = accountManager.getClientByCpf(cpf);

                if (client == null) {
                    System.out.println("Client doesn't exists.");
                } else {
                    accountManager.createAccount(number, client);
                }
                accountManager.line();

            } else if (choice == 3) {
                System.out.print("Number: ");
                String number = in.nextLine();

                System.out.print("Client's CPF: ");
                String cpf = in.nextLine();

                Client client = accountManager.getClientByCpf(cpf);

                if (client == null) {
                    System.out.println("Client doesn't exists.");
                } else {
                    accountManager.createSavingsAccount(number, client);
                }
                accountManager.line();

            } else if (choice == 4) {
                System.out.print("Number: ");
                String number = in.nextLine();

                System.out.print("Value: R$");
                double value = in.nextDouble();
                in.nextLine();

                accountManager.deposit(number, value);
                accountManager.line();

            } else if (choice == 5) {
                System.out.print("Account's number: ");
                String number = in.nextLine();

                System.out.println(accountManager.balanceConsultAccount(number));
                accountManager.line();

            } else if (choice == 6) {
                System.out.print("Origin account number: ");
                String originAccountNumber = in.nextLine();

                System.out.print("Recipient account number: ");
                String recipientAccountNumber= in.nextLine();

                System.out.print("Value: R$ ");
                double value = in.nextDouble();
                in.nextLine();

                accountManager.transfer(originAccountNumber, recipientAccountNumber, value);
                accountManager.line();

            } else if (choice == 7) {
                System.out.print("Savings account number: ");
                String number = in.nextLine();

                accountManager.interestIncome(number);
                accountManager.line();
            } else {
                break;
            }
        }
    }
}

