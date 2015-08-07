//package by.prohorov.command;
//
//import by.prohorov.connectDB.OpenDBNotes;
//import by.prohorov.resource.ConfigurationManager;
//import by.prohorov.subject.Note;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class EditNoteCommand implements ActionCommand{
//    private String page;
//
//
//    @Override
//    public String execute(HttpServletRequest request) {
//    ArrayList<Note> noteList = new ArrayList<>();
//
//        try {
//            noteList = OpenDBNotes.openNote(noteList);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if(!noteList.isEmpty()) {
//            request.setAttribute("list", noteList);
//        }
//
//        request.getSession().invalidate();
//        page = ConfigurationManager.getProperty("path.page.main");
//        return page;
//    }
//}
