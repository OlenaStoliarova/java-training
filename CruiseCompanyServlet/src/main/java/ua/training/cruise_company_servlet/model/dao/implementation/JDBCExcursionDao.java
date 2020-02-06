package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DAOLevelException;
import ua.training.cruise_company_servlet.model.dao.ExcursionDao;
import ua.training.cruise_company_servlet.model.dao.mapper.ExcursionMapper;
import ua.training.cruise_company_servlet.model.dao.mapper.SeaportMapper;
import ua.training.cruise_company_servlet.model.entity.Excursion;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCExcursionDao implements ExcursionDao {
    private static final Logger LOG = LogManager.getLogger(JDBCExcursionDao.class);

    private static final String SELECT_ALL_EXCURSIONS = "SELECT e.*, " +
            "s.id AS port_id, " +
            "s.name_en AS port_name_en, " +
            "s.name_ukr AS port_name_ukr, " +
            "s.country_en AS port_country_en, " +
            "s.country_ukr AS port_country_ukr " +
            "FROM excursion AS e " +
            "LEFT JOIN seaport AS s " +
            "ON e.seaport_id = s.id";

    private static final String SELECT_ALL_EXCURSIONS_IN_SEAPORT = "SELECT e.*, " +
            "s.id AS port_id, " +
            "s.name_en AS port_name_en, " +
            "s.name_ukr AS port_name_ukr, " +
            "s.country_en AS port_country_en, " +
            "s.country_ukr AS port_country_ukr " +
            "FROM excursion AS e " +
            "LEFT JOIN seaport AS s " +
            "ON e.seaport_id = s.id " +
            "WHERE e.seaport_id = ?";


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
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_EXCURSIONS);
            while (resultSet.next()) {
                Excursion excursion = new ExcursionMapper().extractFromResultSet(resultSet);
                Seaport seaport = new SeaportMapper().extractFromResultSet(resultSet, "port_");
                excursion.setSeaport(seaport);
                resultList.add(excursion);
            }
        }catch (SQLException e){
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return resultList;
    }

    @Override
    public List<Excursion> findBySeaportId(long seaportId) {
        List<Excursion> resultList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EXCURSIONS_IN_SEAPORT);
            statement.setLong(1, seaportId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Excursion excursion = new ExcursionMapper().extractFromResultSet(resultSet);
                Seaport seaport = new SeaportMapper().extractFromResultSet(resultSet, "port_");
                excursion.setSeaport(seaport);
                resultList.add(excursion);
            }
        }catch (SQLException e){
            LOG.error(e.getMessage(), e);
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
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }
}
