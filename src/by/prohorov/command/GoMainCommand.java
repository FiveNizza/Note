package by.prohorov.command;

import by.prohorov.connectDB.OpenDBNotes;
import by.prohorov.resource.ConfigurationManager;
import by.prohorov.subject.Note;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vaio on 06.08.15.
 */
public class GoMainCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        ArrayList<Note> noteList = new ArrayList<>();

        String page = null;
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

