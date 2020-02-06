package ua.training.cruise_company_servlet.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.controller.authentication.AlreadyLoggedInException;
import ua.training.cruise_company_servlet.controller.authentication.Authentication;
import ua.training.cruise_company_servlet.controller.constants.AttributesConstants;
import ua.training.cruise_company_servlet.controller.constants.PathConstants;
import ua.training.cruise_company_servlet.model.enums.UserRole;
import ua.training.cruise_company_servlet.model.service.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(AttributesConstants.LOGIN);
        String password = request.getParameter(AttributesConstants.PASSWORD);
        Authentication authentication = new Authentication(request.getSession());

        if( login == null || login.equals("") || password == null || password.equals("")  ){
            authentication.doLogout();
            return PathConstants.LOGIN_JSP;
        }
        logger.info( login + ", " + password);

        UserRole userRole;
        try {
            userRole = authentication.doLogin(login,password);
        }
        catch (UserNotFoundException e) {
            request.setAttribute(AttributesConstants.ERROR_UNKNOWN_USER, true);
            return PathConstants.LOGIN_JSP;
        } catch (AlreadyLoggedInException e) {
            request.setAttribute(AttributesConstants.ERROR_ALREADY_LOGGED_IN, true);
            return PathConstants.LOGIN_JSP;
        }

        if( userRole.equals( UserRole.ROLE_ADMIN ))
            return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.ADMIN_MAIN_COMMAND;
        if( userRole.equals( UserRole.ROLE_TRAVEL_AGENT))
            return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.TRAVEL_AGENT_MAIN_COMMAND;
        if( userRole.equals( UserRole.ROLE_TOURIST))
            return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.TOURIST_MAIN_COMMAND;

        return "redirect:/" + PathConstants.INDEX_PAGE_COMMAND;
    }
}
