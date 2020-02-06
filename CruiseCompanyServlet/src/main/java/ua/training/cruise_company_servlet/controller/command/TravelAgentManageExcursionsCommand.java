package ua.training.cruise_company_servlet.controller.command;

import ua.training.cruise_company_servlet.controller.constants.PathConstants;
import ua.training.cruise_company_servlet.model.service.ExcursionService;
import ua.training.cruise_company_servlet.model.service.SeaportService;

import javax.servlet.http.HttpServletRequest;

public class TravelAgentManageExcursionsCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        SeaportService seaportService = new SeaportService();
        ExcursionService excursionService = new ExcursionService();
        request.setAttribute("all_seaports", seaportService.getAllSeaportsLocalizedSorted());

        String strSeaportId = request.getParameter("seaportId");
        if(strSeaportId != null){
            long seaportId = Long.parseLong(strSeaportId);
            request.setAttribute("all_excursions", excursionService.getAllExcursionsInSeaportForTravelAgent(seaportId));
        }
        else {
            request.setAttribute("all_excursions", excursionService.getAllExcursionsForTravelAgent());
        }

        return PathConstants.TRAVEL_AGENT_EXCURSIONS_JSP;
    }
}
