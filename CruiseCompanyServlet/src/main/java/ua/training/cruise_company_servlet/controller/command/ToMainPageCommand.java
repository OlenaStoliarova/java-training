package ua.training.cruise_company_servlet.controller.command;

import javax.servlet.http.HttpServletRequest;

public class ToMainPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        return "/tourist/tourist_main.jsp";
    }
}
