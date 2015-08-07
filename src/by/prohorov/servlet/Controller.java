package by.prohorov.servlet;

import by.prohorov.command.ActionCommand;
import by.prohorov.command.factory.ActionFactory;
import by.prohorov.resource.ConfigurationManager;
import by.prohorov.resource.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                         throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                          throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
                                throws ServletException, IOException {
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        //Передача параметров классу-обработчику.
        page = command.execute(request);
        if(page != null) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
            request.getSession().invalidate();
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullPage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}