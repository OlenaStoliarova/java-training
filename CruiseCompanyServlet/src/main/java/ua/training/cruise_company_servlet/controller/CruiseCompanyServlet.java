package ua.training.cruise_company_servlet.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import ua.training.cruise_company_servlet.controller.command.Command;
import ua.training.cruise_company_servlet.controller.command.ToMainPageCommand;
import ua.training.cruise_company_servlet.controller.command.TouristCruisesCommand;

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
        path = path.replaceFirst("/" , "");
        Command command = commands.getOrDefault(path , (r)->"/index.jsp");
        logger.info(command.getClass().getName());
        String page = command.execute(request);
        //request.getRequestDispatcher(page).forward(request,response);
        request.getServletContext().getRequestDispatcher("/WEB-INF" + page).forward(request, response);
    }
}
