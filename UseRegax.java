package SecondAssigment;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseRegax {

	public static void main(String[] args) {
		// TODO Auto9-generated method stub
		String s;
		do {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your phone number");
		String num=sc.nextLine();
		System.out.println("Enter your name");
		String name=sc.nextLine();
		System.out.println("Enter your email");
		String mail=sc.nextLine();

		System.out.println("Enter your Username");
		String username=sc.nextLine();
		System.out.println("Enter your Password");
		String password=sc.nextLine();
		Regax rx=new Regax();
		try {
			rx.validusername(username);
            rx.validPassword(password);
            rx.validnum(num);
            rx.validname(name);
            rx.validmail(mail);
			System.out.println("\n All validation successful!");
		}catch(Exception e) {
			System.out.println("Validation failed!!\n"+e.getMessage());
			System.out.println("do you wnat re-enter information y/n");
			
		}
		s=sc.nextLine();

		}while(s=="y"||s=="Y");
		

	}
}
 class Regax{
	public void validnum(String num) throws InvalidPhoneNumberException {
		Pattern p=Pattern.compile("\\d{10}");
		Matcher m=p.matcher(num);
		if(m.matches()) {
			 System.out.println("Valid Phone Number ");
		}
		else {
			throw new InvalidPhoneNumberException("Must be enter valid Number!");
		}
		
	}
	public void validname(String name) throws InvalidnameException {
		Pattern p=Pattern.compile("[A-Za-z]+[A-Za-z]{2,}");
		Matcher m=p.matcher(name);
		if(m.matches()) {
			 System.out.println("Valid name");
		}
		else {
			throw new InvalidnameException("Name must be contain only letters!");
		}
		
	}
	public void validusername(String username) throws InvalidnameException {
		Pattern p=Pattern.compile("[a-zA-Z0-9]+");
		Matcher m=p.matcher(username);
		if(m.matches()) {
			 System.out.println("Valid Username");
		}
		else {
			throw new InvalidnameException("Must be enter valid username!");
		}

		
	}
	public void validPassword(String password) throws InvalidPasswordException {
		Pattern p=Pattern.compile("[0-9a-zA-Z]{8,}");
		Matcher m=p.matcher(password);
		if(m.matches()) {
			 System.out.println("Valid Passowrd");
		}
		else {
			throw new InvalidPasswordException("Must be enter valid password!");
		}
		
		
	}
	public void validmail(String email) throws InvalidmailException{
		Pattern p=Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[A-Za-z]{2,}$");
		Matcher m=p.matcher(email);
		if(m.matches()) {
			System.out.println("valid email");
		}
		else {
			throw new InvalidmailException("Must be enter valid maii");
		}
	}
 }
	class InvalidPhoneNumberException extends Exception{
		public  InvalidPhoneNumberException (String message) {
			super(message);
		}
	}
		class InvalidPasswordException extends Exception{
			public InvalidPasswordException(String message) {
				// TODO Auto-generated constructor stub
				super(message);

			}
		}
			class InvalidnameException extends Exception{
				public  InvalidnameException (String message) {
					super(message);
				}
			}
    class InvalidmailException extends Exception{
    	public InvalidmailException(String message) {
    		super(message);
    	}
    }
