package by.prohorov.command;

import by.prohorov.connectDB.OpenDBNotes;
import by.prohorov.connectDB.OpenDBUserPassword;
import by.prohorov.logic.LoginLogic;
import by.prohorov.resource.ConfigurationManager;
import by.prohorov.resource.MessageManager;
import by.prohorov.subject.Note;
import by.prohorov.subject.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginCommand implements ActionCommand {

    private int id;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        ArrayList<Note> noteList = new ArrayList<>();
        ArrayList<User> user = new ArrayList<>();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            if(LoginLogic.checkLogin(login, password)) {
                try {
                    noteList = OpenDBNotes.openNote(noteList);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    user = OpenDBUserPassword.openUser(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                for(User user1 : user) {
                    if(user1.getLogin().equals(login)){
                        id = user1.getId();
                    }
                }

                request.setAttribute("id", id);
                request.setAttribute("user", login);

                if(!noteList.isEmpty()){
                    request.setAttribute("list", noteList);
                }
                page = ConfigurationManager.getProperty("path.page.main");
            } else {
                request.setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("message.loginError"));
                page = ConfigurationManager.getProperty("path.page.error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
}
