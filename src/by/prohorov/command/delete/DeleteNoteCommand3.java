package by.prohorov.command.delete;

import by.prohorov.command.ActionCommand;
import by.prohorov.connectDB.ConnectionDB;
import by.prohorov.connectDB.OpenDBNotes;
import by.prohorov.resource.ConfigurationManager;
import by.prohorov.subject.Note;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteNoteCommand3 implements ActionCommand {
    private String page = null;
    private static final String query = "DELETE \"user\".\"notes\" WHERE id_note = ?;";

    @Override
    public String execute(HttpServletRequest request) {
        ArrayList<Note> noteList = new ArrayList<>();

        try {
            noteList = OpenDBNotes.openNote(noteList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int id = noteList.get(2).getId();

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(!noteList.isEmpty()) {
            request.setAttribute("list", noteList);
        }

        page = ConfigurationManager.getProperty("path.page.main");
        return page;
    }
}