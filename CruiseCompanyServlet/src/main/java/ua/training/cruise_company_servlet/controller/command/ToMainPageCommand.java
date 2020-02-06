package ua.training.cruise_company_servlet.controller.command;

import ua.training.cruise_company_servlet.controller.constants.AttributesConstants;
import ua.training.cruise_company_servlet.controller.constants.PathConstants;
import ua.training.cruise_company_servlet.model.enums.UserRole;

import javax.servlet.http.HttpServletRequest;

public class ToMainPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        UserRole curUserRole = (UserRole) request.getSession().getAttribute(AttributesConstants.USER_ROLE);

        if(curUserRole == null)
            return "redirect:/" + PathConstants.INDEX_PAGE_COMMAND;

        if( curUserRole.equals( UserRole.ROLE_ADMIN ))
            return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.ADMIN_MAIN_COMMAND;
        if( curUserRole.equals( UserRole.ROLE_TRAVEL_AGENT))
            return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.TRAVEL_AGENT_MAIN_COMMAND;
        if( curUserRole.equals( UserRole.ROLE_TOURIST))
            return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.TOURIST_MAIN_COMMAND;

         return "redirect:/" + PathConstants.INDEX_PAGE_COMMAND;
    }
}
