package by.prohorov.connectDB;

import by.prohorov.resource.DataBaseManager;
import by.prohorov.subject.Note;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OpenDBNotes {
    private static Connection connection = null;
    private static final String query = "SELECT * FROM \"user\".\"note\"";

    public static ArrayList<Note> openNote(ArrayList<Note> list) throws SQLException {
        try {//1
            Class.forName(DataBaseManager.getProperty("db.forName"));
            try {//2
                connection = ConnectionDB.getConnection();
                Statement statement = null;
                try {//3
                    statement = connection.createStatement();
                    ResultSet resultSet = null;
                    try {//4
                        resultSet = statement.executeQuery(query);

                        while(resultSet.next()) {
                            int id = resultSet.getInt(4);
                            String nameNote = resultSet.getString(1);
                            String note = resultSet.getString(2);
                            list.add(new Note(id, nameNote, note));
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
