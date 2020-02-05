package ua.training.cruise_company_servlet.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.ExcursionDao;
import ua.training.cruise_company_servlet.model.dto.ExcursionForTravelAgentDTO;

import java.util.List;

public class ExcursionService {
    private static final Logger logger = LogManager.getLogger(ExcursionService.class);

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public List<ExcursionForTravelAgentDTO> getAllExcursions() {
        try(ExcursionDao excursionDao = daoFactory.createExcursionDao()) {
            return excursionDao.findAllForTravelAgent();
        }
    }

    public List<ExcursionForTravelAgentDTO> getAllExcursionsInSeaport(long seaportId) {
        try(ExcursionDao excursionDao = daoFactory.createExcursionDao()) {
            return excursionDao.findForTravelAgentBySeaportId(seaportId);
        }
    }
}
