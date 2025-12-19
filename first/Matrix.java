package Assigment.first;
import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) {
        System.out.println("Enter the value of n for square matrix:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char ch;
        do {
            System.out.println("please entre which operation perform to matrix 1\n" +
                    "1->addtion\n" +
                    "2->subtraction\n" +
                    "3->multiplication\n" +
                    "4->transpose\n" +
                    "5->check diagonal\n" +
                    "6->check matrix is identity\n"

            );
            int choice = sc.nextInt();
            int[][] arr = new int[n][n];
            int[][] brr = new int[n][n];
            int[][] crr = new int[n][n];
            boolean flag = true;

            switch (choice) {
                case 1:

                    System.out.println("Enter the elements of your first matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    System.out.println("Enter the elements of your second matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            brr[i][j] = sc.nextInt();
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            crr[i][j] = arr[i][j] + brr[i][j];
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(crr[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:

                    System.out.println("Enter the elements of your first matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    System.out.println("Enter the elements of your second matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            brr[i][j] = sc.nextInt();
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            crr[i][j] = arr[i][j] - brr[i][j];
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(crr[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:

                    System.out.println("Enter the elements of your first matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    System.out.println("Enter the elements of your second matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            brr[i][j] = sc.nextInt();
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            int sum = 0;
                            for (int k = 0; k < n; k++) {
                                sum = sum + arr[i][k] * brr[k][j];
                            }
                            crr[i][j] = sum;
                        }

                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(crr[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Enter the elements of your  matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            brr[i][j] = arr[j][i];
                            System.out.print(brr[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Enter the elements of your  matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            arr[i][j] = sc.nextInt();
                        }
                    }

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i != j) {
                                if (arr[i][j] != 0) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (flag) {
                        System.out.println("matrix is  Diagonal ");
                    } else {
                        System.out.println("matrix is not Diagonal ");
                    }
                    break;
                case 6:
                    System.out.println("Enter the elements of your matrix:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    flag = true;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i == j && arr[i][j] != 1) flag = false;
                            if (i != j && arr[i][j] != 0) flag = false;
                        }
                    }


                    if (flag) {
                        System.out.println("matrix is  identity ");
                    } else {
                        System.out.println("matrix is not identity ");
                    }
                default:
                    System.out.println("Invalid choice");


            }

            System.out.print("Do you want to continue? (y/n): ");
            ch = sc.next().charAt(0);

        } while (ch == 'y' || ch == 'Y');

        System.out.println("Program stopped. Thank you!");
        sc.close();

    }
}
