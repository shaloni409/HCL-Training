package Assigment.first;
import java.util.Scanner;

// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class Account {
    private int accountNumber;
    private String accountHolder;
    private String accountType;
    private double balance;

    public Account(int accNo, String name, String type, double bal) {
        accountNumber = accNo;
        accountHolder = name;
        accountType = type;
        balance = bal;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : " + balance);
    }
}

// Main Class
public class bankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;
        int choice;

        do {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Account Type: ");
                        String type = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();

                        account = new Account(accNo, name, type, bal);
                        System.out.println("Account created successfully.");
                        break;

                    case 2:
                        if (account == null) {
                            System.out.println("Create account first.");
                            break;
                        }
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;

                    case 3:
                        if (account == null) {
                            System.out.println("Create account first.");
                            break;
                        }
                        System.out.print("Enter withdrawal amount: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                        break;

                    case 4:
                        if (account == null) {
                            System.out.println("Create account first.");
                            break;
                        }
                        account.checkBalance();
                        break;

                    case 5:
                        if (account == null) {
                            System.out.println("Create account first.");
                            break;
                        }
                        account.displayDetails();
                        break;

                    case 6:
                        System.out.println("Thank you for using Bank Management System.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.nextLine();
            }

        } while (choice != 6);

        sc.close();
    }
}
