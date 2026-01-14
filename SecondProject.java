package Allprojects;

import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {

    /* ===================== EMPLOYEE CLASS ===================== */
    static class Employee implements Serializable {
        int id;
        String name;
        double salary;
        String department;

        Employee(int id, String name, double salary, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public String toString() {
            return "ID: " + id +
                   ", Name: " + name +
                   ", Salary: " + salary +
                   ", Department: " + department;
        }
    }

    /* ===================== LOGIN SYSTEM ===================== */
    static class Login {
        private final String USERNAME = "admin";
        private final String PASSWORD = "admin123";

        boolean authenticate(Scanner sc) {
            System.out.print("Username: ");
            String user = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();

            if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                System.out.println("Login Successful!\n");
                return true;
            } else {
                System.out.println("Invalid Username or Password!");
                return false;
            }
        }
    }

    /* ===================== EMPLOYEE MANAGER ===================== */
    static class EmployeeManager {
        private Map<Integer, Employee> employees = new HashMap<>();
        private final String FILE_NAME = "employees.dat";

        EmployeeManager() {
            loadFromFile();
        }

        // Add Employee
        void addEmployee(Employee emp) {
            if (employees.containsKey(emp.id))
                throw new RuntimeException("Employee ID must be unique!");

            if (emp.salary <= 0)
                throw new RuntimeException("Salary must be positive!");

            if (emp.department.isEmpty())
                throw new RuntimeException("Department cannot be empty!");

            employees.put(emp.id, emp);
            saveToFile();
        }

        // Display All
        void displayAll() {
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }
            employees.values().forEach(System.out::println);
        }

        // Search Employee
        void searchEmployee(int id) {
            if (!employees.containsKey(id))
                throw new RuntimeException("Employee not found!");

            System.out.println(employees.get(id));
        }

        // Update Salary
        void updateSalary(int id, double salary) {
            if (salary <= 0)
                throw new RuntimeException("Salary must be positive!");

            Employee emp = employees.get(id);
            if (emp == null)
                throw new RuntimeException("Employee not found!");

            emp.salary = salary;
            saveToFile();
        }

        // Delete Employee
        void deleteEmployee(int id) {
            if (!employees.containsKey(id))
                throw new RuntimeException("Employee not found!");

            employees.remove(id);
            saveToFile();
        }

        // Sorted Employees
        void displaySortedEmployees() {
            List<Employee> list = new ArrayList<>(employees.values());
            list.sort(Comparator.comparingDouble(e -> e.salary));
            list.forEach(System.out::println);
        }

        // Display Departments
        void displayDepartments() {
            Set<String> departments = new HashSet<>();
            for (Employee e : employees.values()) {
                departments.add(e.department);
            }
            System.out.println("Departments: " + departments);
        }

        // Save to File
        private void saveToFile() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(employees);
            } catch (IOException e) {
                System.out.println("Error saving file!");
            }
        }

        // Load from File
        @SuppressWarnings("unchecked")
        private void loadFromFile() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                employees = (Map<Integer, Employee>) ois.readObject();
            } catch (Exception e) {
                employees = new HashMap<>();
            }
        }
    }

    /* ===================== MAIN METHOD ===================== */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        if (!login.authenticate(sc)) return;

        EmployeeManager manager = new EmployeeManager();

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Department: ");
                        String dept = sc.nextLine();

                        manager.addEmployee(new Employee(id, name, salary, dept));
                        System.out.println("Employee Added Successfully!");
                        break;

                    case 2:
                        manager.displayAll();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        manager.searchEmployee(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        int uid = sc.nextInt();
                        System.out.print("New Salary: ");
                        double sal = sc.nextDouble();
                        manager.updateSalary(uid, sal);
                        System.out.println("Salary Updated!");
                        break;

                    case 5:
                        System.out.print("Enter ID: ");
                        manager.deleteEmployee(sc.nextInt());
                        System.out.println("Employee Deleted!");
                        break;

                    case 6:
                        manager.displaySortedEmployees();
                        break;

                    case 7:
                        manager.displayDepartments();
                        break;

                    case 8:
                        System.out.println("Thank you! Exiting...");
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

