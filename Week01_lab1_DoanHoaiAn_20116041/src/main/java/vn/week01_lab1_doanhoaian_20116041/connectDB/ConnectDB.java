package vn.week01_lab1_doanhoaian_20116041.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static ConnectDB instance;
    private Connection connection;

    private ConnectDB() {

        try {
            System.out.println("Connecting to the database...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb",
                    "root", "123456");
            System.out.println("Connection valid: " + connection.isValid(5));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static ConnectDB getInstance() {
        if (instance == null)
            instance = new ConnectDB();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}