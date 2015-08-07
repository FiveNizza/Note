package by.prohorov.command;
//Команда на регистрацию.
//Переход на страницу регистрации.

import by.prohorov.connectDB.ConnectionDB;
import by.prohorov.logic.RegisterLogic;
import by.prohorov.logic.UniqueLogin;
import by.prohorov.resource.ConfigurationManager;
import by.prohorov.resource.DataBaseManager;
import by.prohorov.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterCommand implements ActionCommand{

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;

    @Override
    public String execute (HttpServletRequest request) {
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        //Проверка на уникальность пароля
        if (RegisterLogic.checkPassword(password, repeatPassword)) {
            //Проверка на уникальность логина
            try {
                if(UniqueLogin.checkEnterLogin(login)){
                //Запись в базу нового юзера
                    try {
                        Class.forName(DataBaseManager.getProperty("db.forName"));
                        try{
                            connection = ConnectionDB.getConnection();
                            try{
                                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"user\".\"user\" (name, password) VALUES (?,?);");
                                preparedStatement.setString(1, login);
                                preparedStatement.setString(2, password);
                                preparedStatement.execute();
                            } finally {
                                if(preparedStatement != null) {
                                    preparedStatement.close();
                                }
                            }
                        } finally {
                            if(connection != null) {
                                connection.close();
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }

                    page = ConfigurationManager.getProperty("path.page.login");
                    request.getSession().setAttribute("registerIsOk",
                            MessageManager.getProperty("message.registerOk"));
                } else {
                    request.setAttribute("loginIsOccupied", MessageManager.getProperty("message.loginOccupied"));
                    page = ConfigurationManager.getProperty("path.page.register");
                    request.getSession(false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            request.setAttribute("passwordMismatch", MessageManager.getProperty("message.password"));
            page = ConfigurationManager.getProperty("path.page.register");
        }
        return page;
    }
}
