package ua.training.cruise_company_servlet.controller.command;

import javax.servlet.http.HttpServletRequest;

public class TouristCruisesCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/tourist/cruises.jsp";
    }
}