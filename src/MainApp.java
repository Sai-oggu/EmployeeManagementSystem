import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Employee Management Console ====");
        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!LoginService.checkLogin(user, pass)) {
            System.out.println("Invalid Login!");
            return;
        }

        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.addEmployee();
                case 2 -> service.viewEmployees();
                case 3 -> service.updateEmployee();
                case 4 -> service.deleteEmployee();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
