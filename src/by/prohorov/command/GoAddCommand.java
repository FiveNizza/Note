package by.prohorov.command;

import by.prohorov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class GoAddCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        request.setAttribute("login", login);
        String page = ConfigurationManager.getProperty("path.page.addNote");
        return page;
    }
}
