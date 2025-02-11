package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Update the connection URL, username, and password
                String url = "jdbc:mysql://localhost:3306/expense_record";
                String username = "root"; // Default username for XAMPP MySQL
                String password = ""; // Default password for XAMPP MySQL is empty
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}