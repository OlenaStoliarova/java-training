package ua.training.cruise_company_servlet.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.controller.constants.PathConstants;
import ua.training.cruise_company_servlet.model.entity.UserRole;

import javax.servlet.http.HttpServletRequest;

public class ToMainPageCommand implements Command{
    private static final Logger logger = LogManager.getLogger(ToMainPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        UserRole curUserRole;
        try {
            curUserRole = UserRole.valueOf( (String) request.getSession().getAttribute("user_role") );
        } catch (Exception e) {
            logger.warn("Accessing main with no role set");
            logger.warn(e.getMessage());
            return "redirect:/" + PathConstants.INDEX_PAGE_COMMAND;
        }

        if( curUserRole.equals( UserRole.ROLE_ADMIN ))
            return PathConstants.ADMIN_MAIN_JSP;
        if( curUserRole.equals( UserRole.ROLE_TRAVEL_AGENT))
            return PathConstants.TRAVEL_AGENT_MAIN_JSP;
        if( curUserRole.equals( UserRole.ROLE_TOURIST))
            return PathConstants.TOURIST_MAIN_JSP;

         return "redirect:/" + PathConstants.INDEX_PAGE_COMMAND;
    }
}
