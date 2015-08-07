package by.prohorov.connectDB;

import by.prohorov.resource.DataBaseManager;
import by.prohorov.subject.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OpenDBUserPassword {

    private static final String selectUser = "SELECT * FROM \"user\".\"user\";";
    private static Connection connection = null;


    public static ArrayList openUser(ArrayList<User> list) throws SQLException {
        try {//1
            Class.forName(DataBaseManager.getProperty("db.forName"));
            try {//2
                connection = ConnectionDB.getConnection();
                Statement statement = null;
                try {//3
                    statement = connection.createStatement();
                    ResultSet resultSet = null;
                    try {//4s
                        resultSet = statement.executeQuery(selectUser);

                        while(resultSet.next()) {
                            String name = resultSet.getString(1);
                            String password = resultSet.getString(2);
                            int id = resultSet.getInt(3);
                            list.add(new User(id, name, password));
                        }
                    }
                    finally {//4
                        if (resultSet != null) {
                            resultSet.close();
                        } else {
                            System.err.println("ResultSet exception close in " + Class.class.getName());
                        }
                    }
                }
                finally {//3
                    if (statement != null) {
                        statement.close();
                    } else {
                        System.err.println("Statement exception close in " + Class.class.getName());
                    }
                }
            } finally {//2
                if (connection != null) {
                    connection.close();
                } else {
                    System.err.println("Connection exception close in " + Class.class.getName());
                }
            }
        } catch (ClassNotFoundException e) {//1
            e.printStackTrace();
        }
        return list;
    }

}
