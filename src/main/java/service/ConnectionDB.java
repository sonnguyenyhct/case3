package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/facebook?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "sonyhct";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Load Driver
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword); // connect
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
