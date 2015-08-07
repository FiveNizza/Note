package by.prohorov.connectDB;

import by.prohorov.resource.DataBaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        String url = DataBaseManager.getProperty("db.url");
        String user = DataBaseManager.getProperty("db.user");
        String password = DataBaseManager.getProperty("db.password");

        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}
