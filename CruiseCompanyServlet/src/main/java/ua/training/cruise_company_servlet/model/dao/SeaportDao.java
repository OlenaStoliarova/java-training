package ua.training.cruise_company_servlet.model.dao;

import ua.training.cruise_company_servlet.model.dto.SeaportDTO;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.util.List;
import java.util.Optional;

public interface SeaportDao extends GenericDao<Seaport> {
    Optional<Seaport> findByNameEn(String  nameEn);

    List<SeaportDTO> findAllLocalizedSortedByName();
}
