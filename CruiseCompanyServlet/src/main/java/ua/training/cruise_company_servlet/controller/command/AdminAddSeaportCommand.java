package ua.training.cruise_company_servlet.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.controller.constant.AttributesConstants;
import ua.training.cruise_company_servlet.controller.constant.PathConstants;
import ua.training.cruise_company_servlet.model.entity.Seaport;
import ua.training.cruise_company_servlet.model.service.SeaportService;

import javax.servlet.http.HttpServletRequest;

public class AdminAddSeaportCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AdminAddSeaportCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String portNameEn = request.getParameter(AttributesConstants.PORT_NAME_EN);
        String portCountryEn = request.getParameter(AttributesConstants.PORT_COUNTRY_EN);
        String portNameUkr = request.getParameter(AttributesConstants.PORT_NAME_UKR);
        String portCountryUkr = request.getParameter(AttributesConstants.PORT_COUNTRY_UKR);
        if( portNameEn == null || portNameEn.equals("") || portCountryEn == null || portCountryEn.equals("") ||
            portNameUkr == null || portNameUkr.equals("") || portCountryUkr == null || portCountryUkr.equals("")){
            return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.ADMIN_MANAGE_SEAPORTS_COMMAND;
        }
        logger.info( "portNameEn: " + portNameEn + "; portCountryEn: " + portCountryEn + ";");
        logger.info( "portNameUkr: " + portNameUkr + "; portCountryUkr: " + portCountryUkr + ";");

        Seaport addedSeaport = new Seaport();
        addedSeaport.setNameEn(portNameEn);
        addedSeaport.setNameUkr(portNameUkr);
        addedSeaport.setCountryEn(portCountryEn);
        addedSeaport.setCountryUkr(portCountryUkr);

        SeaportService seaportService = new SeaportService();
        boolean wasCreated = seaportService.savePort(addedSeaport);
        if( !wasCreated)
            return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.ADMIN_MANAGE_SEAPORTS_COMMAND + "?error=true";
        logger.info("Seaport was added successfully.");
        return "redirect:" + PathConstants.SERVLET_PATH + PathConstants.ADMIN_MANAGE_SEAPORTS_COMMAND;
    }
}
