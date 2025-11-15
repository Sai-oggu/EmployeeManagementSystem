
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    public static void addEmployee(Employee emp) throws Exception {
        Connection con = DB.getConnection();
        String q = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, emp.name);
        ps.setString(2, emp.fname);
        ps.setString(3, emp.dob);
        ps.setInt(4, emp.salary);
        ps.setString(5, emp.address);
        ps.setString(6, emp.phone);
        ps.setString(7, emp.email);
        ps.setString(8, emp.education);
        ps.setString(9, emp.designation);
        ps.setString(10, emp.aadhar);
        ps.setString(11, emp.empId);

        ps.executeUpdate();
        con.close();
    }

    public static ArrayList<Employee> getAllEmployees() throws Exception {
        Connection con = DB.getConnection();
        ResultSet rs = con.prepareStatement("SELECT * FROM employee").executeQuery();

        ArrayList<Employee> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Employee(
                    rs.getString("name"),
                    rs.getString("fname"),
                    rs.getString("dob"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("education"),
                    rs.getString("designation"),
                    rs.getString("aadhar"),
                    rs.getInt("salary"),
                    rs.getString("empId")
            ));
        }
        con.close();
        return list;
    }

    public static Employee getEmployee(String empId) throws Exception {
        Connection con = DB.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE empId=?");
        ps.setString(1, empId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Employee(
                    rs.getString("name"),
                    rs.getString("fname"),
                    rs.getString("dob"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("education"),
                    rs.getString("designation"),
                    rs.getString("aadhar"),
                    rs.getInt("salary"),
                    rs.getString("empId")
            );
        }
        return null;
    }

    public static void updateEmployee(String empId, String phone, String email, int salary, String address) throws Exception {
        Connection con = DB.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "UPDATE employee SET phone=?, email=?, salary=?, address=? WHERE empId=?"
        );
        ps.setString(1, phone);
        ps.setString(2, email);
        ps.setInt(3, salary);
        ps.setString(4, address);
        ps.setString(5, empId);

        ps.executeUpdate();
        con.close();
    }

    public static void deleteEmployee(String empId) throws Exception {
        Connection con = DB.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE empId=?");
        ps.setString(1, empId);
        ps.executeUpdate();
        con.close();
    }
}
