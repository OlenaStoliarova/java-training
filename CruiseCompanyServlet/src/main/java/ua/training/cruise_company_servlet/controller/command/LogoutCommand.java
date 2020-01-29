package ua.training.cruise_company_servlet.controller.command;

import ua.training.cruise_company_servlet.controller.Authorization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user_name");
        Authorization.removeUserFromLoggedUsers(request.getServletContext(), user);
        session.removeAttribute("user_name");
        session.removeAttribute("user_role");
        return "redirect:/";
    }
}
