import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    public static boolean checkLogin(String username, String password) throws Exception {

        String sql = "SELECT password FROM login WHERE username = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    String storedPassword = rs.getString("password");

                    // TEMP: plain text match (because your DB has plain text)
                    return password.equals(storedPassword);

                } else {
                    return false;
                }
            }
        }
    }
}
