package SecondAssigment;
import java.util.*;
import java.util.regex.*;

public class StudentRecord {

    interface StudentOperations {
        void addStudent();
        void displayStudents();
        void removeStudent(int roll);
        void searchStudent(int roll);
    }

    static class Student {
        int roll;
        String name;
        String branch;

        Student(int roll, String name, String branch) {
            this.roll = roll;
            this.name = name;
            this.branch = branch;
        }

        public String toString() {
            return roll + " " + name + " " + branch;
        }
    }

    static class StudentManager implements StudentOperations {

        List<Student> list = new ArrayList<>();
        Vector<Student> vector = new Vector<>();
        Scanner sc = new Scanner(System.in);

        public void addStudent() {
            try {
                System.out.print("Enter Roll: ");
                int roll = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                if (!Pattern.matches("[A-Za-z ]+", name))
                    throw new Exception();

                System.out.print("Enter Branch: ");
                String branch = sc.nextLine();

                Student s = new Student(roll, name, branch);
                list.add(s);
                vector.add(s);
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }

        public void displayStudents() {
            for (Student s : list)
                System.out.println(s);
        }

        public void removeStudent(int roll) {
            list.removeIf(s -> s.roll == roll);
            vector.removeIf(s -> s.roll == roll);
        }

        public void searchStudent(int roll) {
            for (Student s : list) {
                if (s.roll == roll) {
                    System.out.println(s);
                    return;
                }
            }
            System.out.println("Student Not Found");
        }
    }

    public static void main(String[] args) {

        StudentOperations sm = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice\n"+
        "1. Add\n"+
         "2.Display\n"+
        "3.Remove\n"+
         "4.Search\n"+
        "5.Exit");
            try {
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        sm.addStudent();
                        break;
                    case 2:
                        sm.displayStudents();
                        break;
                    case 3:
                        System.out.print("Enter Roll: ");
                        sm.removeStudent(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Enter Roll: ");
                        sm.searchStudent(sc.nextInt());
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
    }
}
