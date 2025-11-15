import java.util.*;

public class EmployeeService {

    Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        try {
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Father Name: ");
            String fname = sc.nextLine();

            System.out.print("DOB (dd-mm-yyyy): ");
            String dob = sc.nextLine();

            System.out.print("Salary: ");
            int salary = sc.nextInt();
            sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Education: ");
            String education = sc.nextLine();

            System.out.print("Designation: ");
            String designation = sc.nextLine();

            System.out.print("Aadhar: ");
            String aadhar = sc.nextLine();

            String empId = "EMP" + new Random().nextInt(999999);

            Employee emp = new Employee(name, fname, dob, address, phone, email,
                    education, designation, aadhar, salary, empId);

            EmployeeDAO.addEmployee(emp);
            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public void viewEmployees() {
        try {
            var list = EmployeeDAO.getAllEmployees();
            for (Employee emp : list) {
                System.out.println(emp.empId + " - " + emp.name + " - " + emp.phone);
            }
        } catch (Exception e) {
            System.out.println("Error fetching employees.");
        }
    }

    public void updateEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();

            System.out.print("New Phone: ");
            String phone = sc.nextLine();

            System.out.print("New Email: ");
            String email = sc.nextLine();

            System.out.print("New Salary: ");
            int salary = sc.nextInt();
            sc.nextLine();

            System.out.print("New Address: ");
            String address = sc.nextLine();

            EmployeeDAO.updateEmployee(id, phone, email, salary, address);
            System.out.println("Employee Updated Successfully!");

        } catch (Exception e) {
            System.out.println("Error updating employee.");
        }
    }

    public void deleteEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();

            EmployeeDAO.deleteEmployee(id);
            System.out.println("Employee Deleted!");
        } catch (Exception e) {
            System.out.println("Error deleting employee.");
        }
    }
}
