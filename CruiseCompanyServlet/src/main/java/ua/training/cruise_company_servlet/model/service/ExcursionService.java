package ua.training.cruise_company_servlet.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.ExcursionDao;
import ua.training.cruise_company_servlet.model.dto.ExcursionForTravelAgentDTO;
import ua.training.cruise_company_servlet.model.dto.converter.ExcursionDTOConverter;
import ua.training.cruise_company_servlet.model.entity.Excursion;

import java.util.List;
import java.util.stream.Collectors;

public class ExcursionService {
    private static final Logger LOG = LogManager.getLogger(ExcursionService.class);

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public List<ExcursionForTravelAgentDTO> getAllExcursionsForTravelAgent() {
        List<Excursion> excursions;
        try(ExcursionDao excursionDao = daoFactory.createExcursionDao()) {
            excursions = excursionDao.findAll();
        }
        return excursions.stream()
                .map(ExcursionDTOConverter::convertToDTOForTravelAgent)
                .collect(Collectors.toList());
    }

    public List<ExcursionForTravelAgentDTO> getAllExcursionsInSeaportForTravelAgent(long seaportId) {
        List<Excursion> excursions;
        try(ExcursionDao excursionDao = daoFactory.createExcursionDao()) {
            excursions = excursionDao.findBySeaportId(seaportId);
        }
        return excursions.stream()
                .map(ExcursionDTOConverter::convertToDTOForTravelAgent)
                .collect(Collectors.toList());
    }
}
