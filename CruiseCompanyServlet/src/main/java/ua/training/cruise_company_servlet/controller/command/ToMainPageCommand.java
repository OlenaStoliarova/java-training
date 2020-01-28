package ua.training.cruise_company_servlet.controller.command;

import ua.training.cruise_company_servlet.model.entity.UserRole;

import javax.servlet.http.HttpServletRequest;

public class ToMainPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        UserRole curUserRole = UserRole.valueOf( (String) request.getSession().getAttribute("user_role"));

        if( curUserRole.equals( UserRole.ROLE_ADMIN ))
            return "/WEB-INF/admin/admin_main.jsp";
        if( curUserRole.equals( UserRole.ROLE_TRAVEL_AGENT))
            return "/WEB-INF/travel_agent/travel_agent_main.jsp";
        if( curUserRole.equals( UserRole.ROLE_TOURIST))
            return "/WEB-INF/tourist/tourist_main.jsp";

         return "redirect:/";
    }
}
