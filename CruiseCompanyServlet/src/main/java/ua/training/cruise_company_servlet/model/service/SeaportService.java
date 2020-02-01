package ua.training.cruise_company_servlet.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.DataSourceConnectionException;
import ua.training.cruise_company_servlet.model.dao.SeaportDao;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.util.List;

public class SeaportService {
    private static final Logger logger = LogManager.getLogger(SeaportService.class);

    private SeaportDao seaportDao;

    public SeaportService(){
        try {
            this.seaportDao = DaoFactory.getInstance().createSeaportDao();
        } catch (DataSourceConnectionException e){
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public List<Seaport> getAllSeaports() {
        return seaportDao.findAll();
    }

    public boolean savePort(Seaport seaport) {
        return seaportDao.create(seaport);
    }
}
