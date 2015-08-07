package by.prohorov.command;

import by.prohorov.connectDB.ConnectionDB;
import by.prohorov.connectDB.OpenDBNotes;
import by.prohorov.resource.ConfigurationManager;
import by.prohorov.subject.Note;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DeleteNoteCommand implements ActionCommand {
    private String page = null;
    private static final String query = "DELETE FROM \"user\".\"notes\" WHERE id_note=2;";

    @Override
    public String execute(HttpServletRequest request) {
        ArrayList<Note> note = new ArrayList<>();
        ArrayList<Note> noteList = new ArrayList<>();

        String idString = request.getParameter("id");
//        Integer id = Integer.parseInt(idString);

        try {
            note = OpenDBNotes.openNote(note);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        for(Note note1 : note) {
//            if(note1.getId() == id){
                try {
                    Connection connection = ConnectionDB.getConnection();
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                } catch (SQLException e){
                    e.printStackTrace();
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
