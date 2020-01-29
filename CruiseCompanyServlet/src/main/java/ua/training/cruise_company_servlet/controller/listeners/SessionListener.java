package ua.training.cruise_company_servlet.controller.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.controller.constants.AttributesConstants;
import ua.training.cruise_company_servlet.controller.Authorization;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private static final Logger logger = LogManager.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        logger.info("New session " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        logger.info("session " + session.getId() + " is being destroyed");
        String user = (String) session.getAttribute(AttributesConstants.USER_NAME);
        Authorization.removeUserFromLoggedUsers(session.getServletContext(), user);
    }
}
