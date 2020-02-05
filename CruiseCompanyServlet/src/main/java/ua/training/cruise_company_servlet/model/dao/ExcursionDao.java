package ua.training.cruise_company_servlet.model.dao;

import ua.training.cruise_company_servlet.model.dto.ExcursionForTravelAgentDTO;
import ua.training.cruise_company_servlet.model.entity.Excursion;

import java.util.List;

public interface ExcursionDao extends GenericDao<Excursion> {
    List<ExcursionForTravelAgentDTO> findAllForTravelAgent();
    List<ExcursionForTravelAgentDTO> findForTravelAgentBySeaportId(long seaportId);
}
