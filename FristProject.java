package Allprojects;

import java.io.*;
import java.util.Scanner;

/* ================= ABSTRACT CLASS ================= */
abstract class Account implements Serializable {

    protected int accountNumber;
    protected String name;
    protected double balance;

   
    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    abstract void accountType();
    abstract void withdraw(double amount);

   
    public double getBalance() {
        return balance;
    }

    
    public void deposit(double amount) {
        balance += amount;
    }

    public void deposit(double amount, String note) {
        balance += amount;
        System.out.println("Note: " + note);
    }

    public void displayDetails() {
        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Account Holder : " + name);
        System.out.println("Balance        : " + balance);
    }
}

/* ================= SAVINGS ACCOUNT ================= */
class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    void accountType() {
        System.out.println("Account Type: Savings Account");
    }

    
    @Override
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful");
        }
    }
}

/* ================= CURRENT ACCOUNT ================= */
class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    void accountType() {
        System.out.println("Account Type: Current Account");
    }

    // Method Overriding (Overdraft allowed)
    @Override
    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawal Successful");
    }
}

/* ================= FILE HANDLING ================= */
class BankFile {

    private static final String FILE_NAME = "bankdata.txt";

    public static void save(Account acc) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(acc);
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    public static Account load() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Account) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}

/* ================= MAIN CLASS ================= */
public class FristProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account account = null;
        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    int type = sc.nextInt();

                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    if (type == 1)
                        account = new SavingsAccount(accNo, name, bal);
                    else
                        account = new CurrentAccount(accNo, name, bal);

                    BankFile.save(account);
                    System.out.println("Account Created Successfully");
                    break;

                case 2:
                    account = BankFile.load();
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    BankFile.save(account);
                    break;

                case 3:
                    account = BankFile.load();
                    System.out.print("Enter withdraw amount: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    BankFile.save(account);
                    break;

                case 4:
                    account = BankFile.load();
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 5:
                    account = BankFile.load();
                    account.accountType();  
                    account.displayDetails();
                    break;

                case 6:
                    System.out.println("Thank you for using Bank System");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
