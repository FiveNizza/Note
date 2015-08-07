package by.prohorov.logic;


import by.prohorov.connectDB.OpenDBUser;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vaio on 04.08.15.
 */
public class UniqueLogin {
    private static ArrayList<String> listOfLogin = new ArrayList<>();
    static boolean flag = true;

    public static boolean checkEnterLogin(String login) throws SQLException {
        listOfLogin = OpenDBUser.openUser(listOfLogin);

        for(String user : listOfLogin)
            if(user.equals(login)){
                flag = false;
            }
        return flag;
    }
}
