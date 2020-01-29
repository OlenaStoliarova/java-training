package ua.training.cruise_company_servlet.controller.command;

import ua.training.cruise_company_servlet.controller.constants.AttributesConstants;
import ua.training.cruise_company_servlet.controller.Authorization;
import ua.training.cruise_company_servlet.controller.constants.PathConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute(AttributesConstants.USER_NAME);
        Authorization.removeUserFromLoggedUsers(request.getServletContext(), user);
        session.removeAttribute(AttributesConstants.USER_NAME);
        session.removeAttribute(AttributesConstants.USER_ROLE);
        return "redirect:/" + PathConstants.INDEX_PAGE_COMMAND;
    }
}
