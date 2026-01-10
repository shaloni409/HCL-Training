package SecondAssigment;
import java.util.Scanner;
public class BankAccount {
	public static void main(String[]args) {
		System.out.println("YOUR WELCOME IN OUR NEW BANK! :)");
		Scanner sc=new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

		Account account=new Account( accNo, name,address,balance);

		int choice;
		do {
			System.out.println();
			System.out.println("Which operation you what to do perfrom\n"+
		"1.Display Customer details\n"+
		"2.Deposite money\n"+
		"3.Withdraw money\n"+
		"4.balance Inquery\n"+
		 "5. Update address\n" +
		"6. Exit\n"+
		 "Enter your choice\n");
         choice =sc.nextInt();
         try {
         switch(choice) {
         case 1:
        	 account.DispalyCustomer();
        	 break;
         case 2:
        	 System.out.print("Enter amount to deposit: ");
             double depAmount = sc.nextDouble();
             account.deposit(depAmount);
             break;
         case 3:
        	 System.out.print("Enter amount to withdraw: ");
             double withAmount = sc.nextDouble();
             account.withdraw(withAmount);
             break;
         case 5:
        	 sc.nextLine();
             System.out.print("Enter new address: ");
             String newAddress = sc.nextLine();
             account.updateAddress(newAddress);
             break;
	
         case 4:
        	 System.out.println("Current Balance: " + account.balance());
             break;
         
         case 6:
        	 System.out.println("Thank you for using the Bank System!");
             break;

         default:
             System.out.println("Invalid Choice! Try again.");
         }
         }catch(InvalidAmountException | InsufficientBalanceException e) {
             System.out.println("Error: " + e.getMessage());

         }
		}while(choice!=6);
		
		
	}

}
interface BankingOperation{
	 void deposit(double amount)throws InvalidAmountException;
	 void withdraw(double amount)throws InvalidAmountException,InsufficientBalanceException;
	 double balance();
	 }
interface CustomerOpearation{
	void DispalyCustomer();
	void updateAddress(String newAddress);
}
class InvalidAmountException extends Exception{
	public InvalidAmountException(String message) {
		super(message);
	}
}
class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

class Account implements BankingOperation,CustomerOpearation{
	private int accountNumber;
    private String customerName;
    private String address;
    private double balance;

	public Account(int accountNumber, String customerName, String address, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.address = address;
        this.balance = balance;
	}

	@Override
	public void deposit(double amount) throws InvalidAmountException {
		if(amount<=0) {
			throw new InvalidAmountException("Deposite amount must be greter than 0");
		}
		balance+=amount;
		System.out.println("Amount Deposite: "+amount);
	}

	@Override
	public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
		if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance -= amount;
        System.out.println("Amount Withdrawn: " + amount);
	}

	@Override
	public double balance() {
		return balance;
	}
	

	@Override
	public void DispalyCustomer() {
		  System.out.println("\n--- Customer Details ---");
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Customer Name: " + customerName);
	        System.out.println("Address: " + address);
	}

	@Override
	public void updateAddress(String newAddress) {
		   address = newAddress;
	        System.out.println("Address Updated Successfully");
	}
}
	

 