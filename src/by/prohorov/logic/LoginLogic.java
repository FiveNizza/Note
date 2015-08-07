package by.prohorov.logic;

import by.prohorov.connectDB.OpenDBUserPassword;
import by.prohorov.subject.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginLogic {
    private static ArrayList<User> listOfUser = new ArrayList<>();
    static boolean flag = false;

    public static boolean checkLogin(String enterLogin, String enterPass) throws SQLException {
        listOfUser = OpenDBUserPassword.openUser(listOfUser);
        for(User user : listOfUser) {
            if(user.getLogin().equals(enterLogin) && user.getPassword().equals(enterPass)){
                flag = true;
            }
        }
        return flag;
    }
}