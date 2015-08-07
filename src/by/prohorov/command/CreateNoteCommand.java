package by.prohorov.command;

import by.prohorov.connectDB.ConnectionDB;
import by.prohorov.connectDB.OpenDBNotes;
import by.prohorov.resource.ConfigurationManager;
import by.prohorov.subject.Note;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateNoteCommand implements ActionCommand{
    private static final String query = "INSERT INTO \"user\".\"note\" (note_name, note_text) VALUES (?, ?)" ;

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public String execute(HttpServletRequest request) {
        ArrayList<Note> noteList = new ArrayList<>();

        String page = null;
        String nameNote = request.getParameter("note_name");
        String textNote = request.getParameter("note");

        try{
            connection = ConnectionDB.getConnection();
            try{
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, nameNote);
                preparedStatement.setString(2, textNote);
                preparedStatement.execute();
            } finally {
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {}
        }

        try {
            noteList = OpenDBNotes.openNote(noteList);
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
