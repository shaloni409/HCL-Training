package Assigment.first;
import java.util.Scanner;

public class stringOperation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        System.out.print("Enter another String: ");
        String str2 = sc.nextLine();

        // length()
        System.out.println("Length: " + str.length());

        // isEmpty()
        System.out.println("Is Empty: " + str.isEmpty());

        // charAt()
        if (str.length() > 0) {
            System.out.println("Char at index 0: " + str.charAt(0));
        }

        // toString()
        System.out.println("To String: " + str.toString());

        // equals()
        System.out.println("Equals: " + str.equals(str2));

        // compareTo()
        System.out.println("Compare To: " + str.compareTo(str2));

        // contains()
        System.out.println("Contains second string: " + str.contains(str2));

        // indexOf()
        System.out.println("Index Of second string: " + str.indexOf(str2));

        // lastIndexOf()
        System.out.println("Last Index Of 'a': " + str.lastIndexOf('a'));

        // startsWith()
        System.out.print("Enter prefix to check: ");
        String prefix = sc.nextLine();
        System.out.println("Starts With: " + str.startsWith(prefix));

        // endsWith()
        System.out.print("Enter suffix to check: ");
        String suffix = sc.nextLine();
        System.out.println("Ends With: " + str.endsWith(suffix));

        // matches()
        System.out.println("Matches only alphabets: " + str.matches("[A-Za-z ]+"));

        // substring()
        if (str.length() >= 3) {
            System.out.println("Substring (0 to 3): " + str.substring(0, 3));
        }

        // toLowerCase()
        System.out.println("Lower Case: " + str.toLowerCase());

        // trim()
        System.out.println("Trimmed String: '" + str.trim() + "'");

        // replace()
        System.out.print("Enter word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();
        System.out.println("After Replace: " + str.replace(oldWord, newWord));

        // split()
        String[] words = str.trim().split(" ");
        System.out.println("Split Words:");
        for (String w : words) {
            System.out.println(w);
        }

        // join()
        String joined = String.join("-", words);
        System.out.println("Joined String: " + joined);

        // valueOf()
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        String numStr = String.valueOf(num);
        System.out.println("Number converted to String: " + numStr);

        sc.close();
    }
}
