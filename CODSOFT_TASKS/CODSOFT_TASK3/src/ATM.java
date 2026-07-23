import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }



    public void start() {

        int choice;

        do {

            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    private void deposit() {

        System.out.print("Enter deposit amount: ₹");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit Successful.");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    private void withdraw() {

        System.out.print("Enter withdrawal amount: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal Successful.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}