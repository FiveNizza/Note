package by.prohorov.command;

import by.prohorov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class DoRegisterCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        page = ConfigurationManager.getProperty("path.page.register");
        return page;
    }
}
