package ua.training.cruise_company_servlet.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
            return "redirect:/";
        }

        if( curUserRole.equals( UserRole.ROLE_ADMIN ))
            return "/WEB-INF/admin/adminMain.jsp";
        if( curUserRole.equals( UserRole.ROLE_TRAVEL_AGENT))
            return "/WEB-INF/travel_agent/travelAgentMain.jsp";
        if( curUserRole.equals( UserRole.ROLE_TOURIST))
            return "/WEB-INF/tourist/touristMain.jsp";

         return "redirect:/";
    }
}
