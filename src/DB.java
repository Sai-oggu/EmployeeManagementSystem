
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeemanagement",
                    "root",
                    "root"
            );
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
