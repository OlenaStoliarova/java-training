package ua.training.cruise_company_servlet.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.controller.constants.AttributesConstants;

import javax.servlet.ServletContext;
import java.util.HashSet;
import java.util.Set;

public class Authorization {
    private static final Logger logger = LogManager.getLogger(Authorization.class);

    public static boolean addUserToLoggedUsers(ServletContext context, String login){
        Set<String> loggedUsers =  (HashSet<String>) context.getAttribute(AttributesConstants.LOGGED_USERS);
        if(loggedUsers == null) {
            loggedUsers = new HashSet<>();
        }
        logger.info("Logged users: " + loggedUsers);
        if( !loggedUsers.add(login)){
            logger.warn("User '" + login + "' is already logged in.");
            return false;
        }
        context.setAttribute(AttributesConstants.LOGGED_USERS, loggedUsers);
        logger.info("User '" + login + "' was added to loggedUsers list");
        return true;
    }

    public static void removeUserFromLoggedUsers(ServletContext context, String login){
        Set<String> loggedUsers = (HashSet<String>) context.getAttribute(AttributesConstants.LOGGED_USERS);
        if(loggedUsers != null) {
            logger.info("Logged users: " + loggedUsers);
            loggedUsers.remove(login);
            context.setAttribute(AttributesConstants.LOGGED_USERS, loggedUsers);
            logger.info("User '" + login + "' was removed from loggedUsers list");
        }
    }

}
