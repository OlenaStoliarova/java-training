package ua.training.cruise_company_servlet.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import ua.training.cruise_company_servlet.controller.command.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CruiseCompanyServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(CruiseCompanyServlet.class);

    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig){
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("main", new ToMainPageCommand());
        commands.put("tourist/cruises", new TouristCruisesCommand());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/app/" , "");
        Command command = commands.getOrDefault(path , (r)->"/index.jsp");
        logger.info(command.getClass().getName());
        String page = command.execute(request);

        if( page.equals( String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR))){
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        if( page.startsWith("redirect:")){
            page = page.replaceFirst("redirect:", "");
            response.sendRedirect(page);
        }
        else {
            request.getRequestDispatcher(page).forward(request, response);
            //request.getServletContext().getRequestDispatcher(page).forward(request, response);
        }
    }
}
