import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/librarydb";
    private static final String USER = "root";
    private static final String PASS = "yourpassword";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
