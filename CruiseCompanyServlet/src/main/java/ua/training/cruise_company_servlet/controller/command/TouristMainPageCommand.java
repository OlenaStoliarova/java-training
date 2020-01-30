package ua.training.cruise_company_servlet.controller.command;

import ua.training.cruise_company_servlet.controller.constants.PathConstants;

import javax.servlet.http.HttpServletRequest;

public class TouristMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PathConstants.TOURIST_MAIN_JSP;
    }
}
