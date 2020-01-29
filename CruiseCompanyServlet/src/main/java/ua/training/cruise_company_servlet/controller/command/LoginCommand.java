package ua.training.cruise_company_servlet.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.controller.constants.AttributesConstants;
import ua.training.cruise_company_servlet.controller.Authorization;
import ua.training.cruise_company_servlet.controller.constants.PathConstants;
import ua.training.cruise_company_servlet.model.entity.UserRole;
import ua.training.cruise_company_servlet.model.service.UserNotFoundException;
import ua.training.cruise_company_servlet.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(AttributesConstants.LOGIN);
        String password = request.getParameter(AttributesConstants.PASSWORD);

        if( login == null || login.equals("") || password == null || password.equals("")  ){
            return PathConstants.LOGIN_JSP;
        }
        logger.info( login + ", " + password);

        UserRole userRole;
        try {
            UserService userService = new UserService();
            userRole = userService.checkUserOnLogin(login,password);
        } catch (SQLException e) {
            return String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (UserNotFoundException e) {
            request.setAttribute(AttributesConstants.ERROR_UNKNOWN_USER, true);
            return PathConstants.LOGIN_JSP;
        }

        if( !Authorization.addUserToLoggedUsers(request.getServletContext(), login)){
            request.setAttribute(AttributesConstants.ERROR_ALREADY_LOGGED_IN, true);
            return PathConstants.LOGIN_JSP;
        }
        request.getSession().setAttribute(AttributesConstants.USER_ROLE, userRole.toString());
        request.getSession().setAttribute(AttributesConstants.USER_NAME, login);
        return "redirect:/app/main";
    }
}
