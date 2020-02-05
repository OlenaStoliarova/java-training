package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DAOLevelException;
import ua.training.cruise_company_servlet.model.dao.ExcursionDao;
import ua.training.cruise_company_servlet.model.dao.mapper.ExcursionForTravelAgentDTOMapper;
import ua.training.cruise_company_servlet.model.dao.mapper.ExcursionMapper;
import ua.training.cruise_company_servlet.model.dao.mapper.SeaportDTOMapper;
import ua.training.cruise_company_servlet.model.dao.mapper.SeaportMapper;
import ua.training.cruise_company_servlet.model.dto.ExcursionForTravelAgentDTO;
import ua.training.cruise_company_servlet.model.dto.SeaportDTO;
import ua.training.cruise_company_servlet.model.entity.Excursion;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JDBCExcursionDao implements ExcursionDao {
    private static final Logger logger = LogManager.getLogger(JDBCExcursionDao.class);

    private final Connection connection;

    public JDBCExcursionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Excursion entity) {
        return false;
    }

    @Override
    public Excursion findById(int id) {
        return null;
    }

    @Override
    public List<Excursion> findAll() {
        List<Excursion> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(MySQLExcursionsQueries.SELECT_ALL_EXCURSIONS);
            while (resultSet.next()) {
                Excursion excursion = new ExcursionMapper().extractFromResultSet(resultSet);
                Seaport seaport = new SeaportMapper().extractFromResultSet(resultSet, "port_");
                excursion.setSeaport(seaport);
                resultList.add(excursion);
            }
        }catch (SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return resultList;
    }

    @Override
    public List<ExcursionForTravelAgentDTO> findAllForTravelAgent() {
        Locale currentLocale = Locale.getDefault();
        String selectAllExcursionsForTravelAgent = MySQLExcursionsQueries.SELECT_ALL_EXCURSIONS_FOR_TRAVEL_AGENT_DTO_EN;
        if(currentLocale.getLanguage().equalsIgnoreCase("uk"))
            selectAllExcursionsForTravelAgent = MySQLExcursionsQueries.SELECT_ALL_EXCURSIONS_FOR_TRAVEL_AGENT_DTO_UKR;

        List<ExcursionForTravelAgentDTO> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllExcursionsForTravelAgent);
            while (resultSet.next()) {
                ExcursionForTravelAgentDTO excursion = new ExcursionForTravelAgentDTOMapper().extractFromResultSet(resultSet);
                SeaportDTO seaport = new SeaportDTOMapper().extractFromResultSet(resultSet, "port_");
                excursion.setSeaport(seaport);
                resultList.add(excursion);
            }
        }catch (SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return resultList;
    }

    @Override
    public List<ExcursionForTravelAgentDTO> findForTravelAgentBySeaportId(long seaportId) {
        Locale currentLocale = Locale.getDefault();
        String selectExcursionsInSeaportForTravelAgent = MySQLExcursionsQueries.SELECT_ALL_EXCURSIONS_IN_SEAPORT_FOR_TRAVEL_AGENT_DTO_EN;
        if(currentLocale.getLanguage().equalsIgnoreCase("uk"))
            selectExcursionsInSeaportForTravelAgent = MySQLExcursionsQueries.SELECT_ALL_EXCURSIONS_IN_SEAPORT_FOR_TRAVEL_AGENT_DTO_UKR;

        List<ExcursionForTravelAgentDTO> resultList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(selectExcursionsInSeaportForTravelAgent);
            statement.setLong(1, seaportId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ExcursionForTravelAgentDTO excursion = new ExcursionForTravelAgentDTOMapper().extractFromResultSet(resultSet);
                SeaportDTO seaport = new SeaportDTOMapper().extractFromResultSet(resultSet, "port_");
                excursion.setSeaport(seaport);
                resultList.add(excursion);
            }
        }catch (SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return resultList;
    }

    @Override
    public void update(Excursion entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }
}
