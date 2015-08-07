package by.prohorov.command;

import by.prohorov.connectDB.ConnectionDB;
import by.prohorov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vaio on 05.08.15.
 */
public class AddNoteCommand implements ActionCommand{
    private static final String query = "INSERT INTO \"user\".\"note\" (name_note, note) VALUES (?,?);";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String noteName = request.getParameter("note_name");
        String noteText = request.getParameter("note");

        try {
            Connection connection = ConnectionDB.getConnection();
            try{
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query);
                preparedStatement.setString(1, noteName);
                preparedStatement.setString(2, noteText);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page = ConfigurationManager.getProperty("path.page.Main");
        return page;
    }
}
