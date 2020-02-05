package ua.training.cruise_company_servlet.controller.command;

import ua.training.cruise_company_servlet.controller.constants.PathConstants;

import javax.servlet.http.HttpServletRequest;

public class TravelAgentAddExcursionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PathConstants.TRAVEL_AGENT_ADD_EXCURSION_JSP;
    }
}
