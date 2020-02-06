package ua.training.cruise_company_servlet.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.controller.constants.PathConstants;
import ua.training.cruise_company_servlet.model.service.SeaportService;

import javax.servlet.http.HttpServletRequest;

public class AdminManageSeaportsCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AdminManageSeaportsCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        SeaportService seaportService = new SeaportService();
        request.setAttribute("all_ports", seaportService.getAllSeaports());
        return PathConstants.ADMIN_SEAPORTS_JSP;
    }
}