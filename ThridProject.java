package Allprojects;
import java.util.*;

public class ThridProject  {

	    /* ================= STUDENT CLASS ================= */
	    static class Student {
	        int eno;
	        String name;
	        String branch;
	        String sem;
	        double percentage;

	        Student(int eno, String name, String branch, String sem, double percentage) {
	            this.eno = eno;
	            this.name = name;
	            this.branch = branch;
	            this.sem = sem;
	            this.percentage = percentage;
	        }

	        public String toString() {
	            return "Eno: " + eno +
	                    ", Name: " + name +
	                    ", Branch: " + branch +
	                    ", Sem: " + sem +
	                    ", Percentage: " + percentage;
	        }
	    }

	    /* ================= USER LOGIN SYSTEM ================= */
	    static class UserLogin {
	        String username;
	        String password;

	        void register(Scanner sc) {
	            System.out.print("Create Username: ");
	            username = sc.nextLine();

	            System.out.print("Create Password: ");
	            password = sc.nextLine();

	            System.out.println("Registration Successful!\n");
	        }

	        boolean login(Scanner sc) {
	            System.out.print("Enter Username: ");
	            String u = sc.nextLine();

	            System.out.print("Enter Password: ");
	            String p = sc.nextLine();

	            if (u.equals(username) && p.equals(password)) {
	                System.out.println("Login Successful!\n");
	                return true;
	            } else {
	                System.out.println("Invalid Credentials!");
	                return false;
	            }
	        }
	    }

	    /* ================= STUDENT MANAGER ================= */
	    static class StudentManager {
	        Map<Integer, Student> students = new HashMap<>();

	        void addStudent(Student s) {
	            if (students.containsKey(s.eno))
	                throw new RuntimeException("Student Eno must be unique!");

	            if (s.percentage <= 0)
	                throw new RuntimeException("Percentage must be positive!");

	            if (s.sem.isEmpty() || s.branch.isEmpty())
	                throw new RuntimeException("Semester and Branch cannot be empty!");

	            students.put(s.eno, s);
	        }

	        void displayAll() {
	            if (students.isEmpty()) {
	                System.out.println("No students available!");
	                return;
	            }
	            students.values().forEach(System.out::println);
	        }

	        void search(int eno) {
	            Student s = students.get(eno);
	            if (s == null)
	                throw new RuntimeException("Student not found!");
	            System.out.println(s);
	        }

	        void updateBranch(int eno, String branch) {
	            if (branch.isEmpty())
	                throw new RuntimeException("Branch cannot be empty!");

	            Student s = students.get(eno);
	            if (s == null)
	                throw new RuntimeException("Student not found!");

	            s.branch = branch;
	        }

	        void delete(int eno) {
	            if (!students.containsKey(eno))
	                throw new RuntimeException("Student not found!");
	            students.remove(eno);
	        }

	        void displaySorted() {
	            List<Student> list = new ArrayList<>(students.values());
	            list.sort(Comparator.comparingDouble(st -> st.percentage));
	            list.forEach(System.out::println);
	        }
	    }

	    /* ================= MAIN METHOD ================= */
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        UserLogin user = new UserLogin();
	        System.out.println("=== USER REGISTRATION ===");
	        user.register(sc);

	        System.out.println("=== USER LOGIN ===");
	        if (!user.login(sc)) return;

	        StudentManager manager = new StudentManager();

	        while (true) {
	            System.out.println("\n--- Student Management System ---");
	            System.out.println("1. Add Student");
	            System.out.println("2. Display All Students");
	            System.out.println("3. Search Student by Eno");
	            System.out.println("4. Update Student Branch");
	            System.out.println("5. Delete Student by Eno");
	            System.out.println("6. Display Sorted Students");
	            System.out.println("7. Exit");
	            System.out.print("Enter choice: ");

	            int choice = sc.nextInt();

	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.print("Eno: ");
	                        int eno = sc.nextInt();
	                        sc.nextLine();

	                        System.out.print("Name: ");
	                        String name = sc.nextLine();

	                        System.out.print("Branch: ");
	                        String branch = sc.nextLine();

	                        System.out.print("Semester: ");
	                        String sem = sc.nextLine();

	                        System.out.print("Percentage: ");
	                        double per = sc.nextDouble();

	                        manager.addStudent(new Student(eno, name, branch, sem, per));
	                        System.out.println("Student Added!");
	                        break;

	                    case 2:
	                        manager.displayAll();
	                        break;

	                    case 3:
	                        System.out.print("Enter Eno: ");
	                        manager.search(sc.nextInt());
	                        break;

	                    case 4:
	                        System.out.print("Enter Eno: ");
	                        int ueno = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("New Branch: ");
	                        String newBranch = sc.nextLine();
	                        manager.updateBranch(ueno, newBranch);
	                        System.out.println("Branch Updated!");
	                        break;

	                    case 5:
	                        System.out.print("Enter Eno: ");
	                        manager.delete(sc.nextInt());
	                        System.out.println("Student Deleted!");
	                        break;

	                    case 6:
	                        manager.displaySorted();
	                        break;

	                    case 7:
	                        System.out.println("Thank You! Program Ended.");
	                        return;

	                    default:
	                        System.out.println("Invalid choice!");
	                }
	            } catch (Exception e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	    }
	}
