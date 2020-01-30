package ua.training.cruise_company_servlet.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import ua.training.cruise_company_servlet.controller.command.*;
import ua.training.cruise_company_servlet.controller.constants.PathConstants;

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
        commands.put(PathConstants.LOGIN_COMMAND, new LoginCommand());
        commands.put(PathConstants.LOGOUT_COMMAND, new LogoutCommand());
        commands.put(PathConstants.MAIN_COMMAND, new ToMainPageCommand());
        commands.put(PathConstants.ADMIN_MAIN_COMMAND, new AdminMainPageCommand());
        commands.put(PathConstants.TRAVEL_AGENT_MAIN_COMMAND, new TravelAgentMainPageCommand());
        commands.put(PathConstants.TOURIST_MAIN_COMMAND, new TouristMainPageCommand());
        commands.put(PathConstants.TOURIST_CRUISES_COMMAND, new TouristCruisesCommand());
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
        Command command = commands.get(path);
        if(command == null){
            logger.warn("non existing page request (" + path + ")");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        logger.info(command.getClass().getName());

        String page = command.execute(request);

        if( page.startsWith("redirect:")){
            page = page.replaceFirst("redirect:", "");
            response.sendRedirect(page);
        }
        else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
