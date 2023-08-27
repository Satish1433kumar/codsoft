import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM() {
        account = new BankAccount(1000); // Initial balance of $1000
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean continueUsing = true;

        while (continueUsing) {
            System.out.println("\nATM Options:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.print("Select an option (1/2/3): ");

            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option number.");
                scanner.next(); // Clear the input buffer
            }

            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to perform another transaction? (yes/no): ");
                String continueInput = scanner.next().toLowerCase();
                if (continueInput.equals("yes")) {
                    validInput = true;
                } else if (continueInput.equals("no")) {
                    validInput = true;
                    continueUsing = false;
                } else {
                    System.out.println("Please enter only 'yes' or 'no'.");
                }
            }
        }

        System.out.println("Thank you for using the ATM.");
        scanner.close();
    }

    private void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Your current balance is $" + balance);
    }

    private void deposit() {
        try {
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear the input buffer
        }
    }

    private void withdraw() {
        try {
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear the input buffer
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
