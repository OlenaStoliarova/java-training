package ua.training.cruise_company_servlet.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.entity.UserRole;
import ua.training.cruise_company_servlet.model.service.UserNotFoundException;
import ua.training.cruise_company_servlet.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    private static final String LOGIN_JSP = "/login.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("username");
        String password = request.getParameter("password");

        if( login == null || login.equals("") || password == null || password.equals("")  ){
            return LOGIN_JSP;
        }
        logger.info( login + ", " + password);

        UserRole userRole;
        try {
            UserService userService = new UserService();
            userRole = userService.checkUserOnLogin(login,password);
        } catch (SQLException e) {
            return String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (UserNotFoundException e) {
            request.setAttribute("unknown_user", true);
            return LOGIN_JSP;
        }

        request.getSession().setAttribute("user_role", userRole.toString());

        return "redirect:/app/main";
    }
}
