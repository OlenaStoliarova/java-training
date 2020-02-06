package ua.training.cruise_company_servlet.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DaoFactory;
import ua.training.cruise_company_servlet.model.dao.SeaportDao;
import ua.training.cruise_company_servlet.model.dto.SeaportDTO;
import ua.training.cruise_company_servlet.model.dto.converter.SeaportDTOConverter;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.text.Collator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class SeaportService {
    private static final Logger LOG = LogManager.getLogger(SeaportService.class);

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public boolean savePort(Seaport seaport) {
        LOG.info("Saving port " + seaport);
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
        List<Seaport> seaports;
        try(SeaportDao seaportDao = daoFactory.createSeaportDao()) {
            seaports = seaportDao.findAll();
        }

        Collator currentLocaleCollator = Collator.getInstance(Locale.getDefault());
        return seaports.stream()
                .map(SeaportDTOConverter::convertToDTO)
                .sorted(comparing(SeaportDTO::getName, currentLocaleCollator))
                .collect(Collectors.toList());
    }
}
