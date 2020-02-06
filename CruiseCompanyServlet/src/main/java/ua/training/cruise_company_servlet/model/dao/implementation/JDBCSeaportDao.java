 package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DAOLevelException;
import ua.training.cruise_company_servlet.model.dao.SeaportDao;
import ua.training.cruise_company_servlet.model.dao.mapper.SeaportMapper;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCSeaportDao implements SeaportDao {
    private static final Logger LOG = LogManager.getLogger(JDBCSeaportDao.class);

    private static final String INSERT_NEW_PORT ="INSERT INTO seaport (name_en, country_en, name_ukr, country_ukr) VALUES (?, ?, ?, ?)";
    private static final String SELECT_PORT_BY_NAME_EN = "SELECT * FROM seaport WHERE name_en=?";
    private static final String SELECT_ALL_PORTS = "SELECT * FROM seaport";

    private final Connection connection;

    public JDBCSeaportDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Seaport entity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PORT);
            preparedStatement.setString(1, entity.getNameEn());
            preparedStatement.setString(2, entity.getCountryEn());
            preparedStatement.setString(3, entity.getNameUkr());
            preparedStatement.setString(4, entity.getCountryUkr());

            return 1 == preparedStatement.executeUpdate(); //one row was inserted
        }catch (SQLIntegrityConstraintViolationException ex){
            LOG.error(ex.getMessage(), ex);
            return false;
        }catch (SQLException e){
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    @Override
    public Seaport findById(int id) {
        return null;
    }

    @Override
    public Optional<Seaport> findByNameEn(String  nameEn) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PORT_BY_NAME_EN);
            preparedStatement.setString(1, nameEn);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new SeaportMapper().extractFromResultSet(resultSet));
            }
            return Optional.empty();

        } catch(SQLException e){
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    @Override
    public List<Seaport> findAll() {
        List<Seaport> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PORTS);
            while (resultSet.next()) {
                Seaport seaport = new SeaportMapper().extractFromResultSet(resultSet);
                resultList.add(seaport);
            }
        }catch (SQLException e){
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return resultList;
    }

    @Override
    public void update(Seaport entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }
}
