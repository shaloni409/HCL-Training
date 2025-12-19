package Assigment.first;

import java.util.Scanner;

public class Calculater {
    public static void main(String args[]) {
        System.out.println("Welcome to my calculator");
        System.out.println("Please enter your  first number");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Please enter your second number");
        int b = sc.nextInt();
        System.out.println("Please enter your choice what you want to do\n" +
                "if you want Addition enter 1\n" +
                "if you want substraction enter 2\n" +
                "if you want Multiplication enter 3\n" +
                " if you want divide enter 4");
        int num=sc.nextInt();
        switch(num) {
            case 1:
                System.out.println("The sum of number is " + (a+b));
                break;

            case 2:
                System.out.println("The subtraction of number is " + (a-b));
                break;
                case 3:
                System.out.println("The multiplication of  number is " + (a * b));
                break;
                case 4:
                System.out.println("The divide of  number is " + (a / b));
                break;
                default:
                    System.out.println("Invalid input");
        }
    }
}
