package ua.training.cruise_company_servlet.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.SeaportDao;
import ua.training.cruise_company_servlet.model.dto.SeaportDTO;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.util.List;

public class SeaportService {
    private static final Logger logger = LogManager.getLogger(SeaportService.class);

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public boolean savePort(Seaport seaport) {
        try(SeaportDao seaportDao = daoFactory.createSeaportDao()) {
            return seaportDao.create(seaport);
        }
    }

    public List<Seaport> getAllSeaports() {
        try(SeaportDao seaportDao = daoFactory.createSeaportDao()) {
            return seaportDao.findAll();
        }
    }

    public List<SeaportDTO> getAllSeaportsLocalizedSorted() {
        try(SeaportDao seaportDao = daoFactory.createSeaportDao()) {
            return seaportDao.findAllLocalizedSortedByName();
        }
    }
}
