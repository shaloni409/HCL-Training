package Assigment.first;
import java.util.Scanner;
public class MenuDriven {
    public static void main(String[] args) {

        System.out.println("Welcome to Menu Driven :)");
        System.out.println("Please enter the array size");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int capacity = size + 10;
        int[] arr = new int[capacity];
        System.out.println("Please enter the array elements");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        char ch;
        do {

            System.out.println("please entre what you want to do with array 1\n" +
                    "1->insertion\n" +
                    "2->deletion\n" +
                    "3->search\n" +
                    "4->exit"
            );
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please enter index number");
                    int index = sc.nextInt();
                    System.out.println("Please enter the number you want to be inserted");
                    int num = sc.nextInt();
                    if (index < 0 || index > size) {
                        System.out.println("Invalid index");
                        break;
                    } else {
                        for (int i = size; i > index; i--) {
                            arr[i] = arr[i - 1];
                        }
                        arr[index] = num;
                        size++;

                        System.out.println("After insertion our array");
                        for (int i = 0; i < size; i++) {
                            System.out.print(arr[i] + " ");
                        }
                    }

                    break;
                case 2:
                    System.out.println("Please enter index number");
                    int index2 = sc.nextInt();
                    if (index2 < 0 || index2 > size) {
                        System.out.println("Invalid index number");
                    } else {
                        for (int i = index2; i < size - 1; i++) {
                            arr[i] = arr[i + 1];
                        }

                    }
                    size--;

                    System.out.println("Array after deletion");
                    for (int i = 0; i < size; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("which type of search you want\n" +
                            "1->Linear Search\n" +
                            "2->Binary Search\n");
                    int search = sc.nextInt();
                    System.out.print("Enter element to be searched: ");
                    int searchValue = sc.nextInt();
                    int flask = 0;

                    switch (search) {
                        case 1:
                            for (int i = 0; i < size; i++) {
                                if (arr[i] == searchValue) {
                                    flask = 1;
                                    System.out.println("Yes element is present in the array at index of" + i);
                                    break;
                                }
                            }
                            if (flask == 0) System.out.println("No element is not  present in the array");
                            break;
                        case 2:
                            int start = 0, end = size - 1;
                            int mid = start + (end - start) / 2;
                            while (start <= end) {

                                if (arr[mid] == searchValue) {
                                    flask = 1;
                                    System.out.println("Yes element is present in the array at index of" + mid);
                                    break;
                                } else if (arr[mid] > searchValue) {
                                    end = mid - 1;

                                } else {
                                    start = mid + 1;
                                }
                                mid = start + (end - start) / 2;
                            }
                            if (flask == 0) System.out.println("No element is not present in the array");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Exit the program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.print("Do you want to continue? (y/n): ");
            ch = sc.next().charAt(0);

        }while (ch == 'y' || ch == 'Y') ;

            System.out.println("Program stopped. Thank you!");
            sc.close();

    }
}
