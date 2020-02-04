package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DAOLevelException;
import ua.training.cruise_company_servlet.model.dao.SeaportDao;
import ua.training.cruise_company_servlet.model.entity.Seaport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCSeaportDao implements SeaportDao {
    private static final Logger logger = LogManager.getLogger(JDBCSeaportDao.class);

    private final Connection connection;

    public JDBCSeaportDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Seaport entity) {
        String addNewPort = "INSERT INTO seaport (name_en, country_en, name_ukr, country_ukr) " +
                            "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addNewPort);
            preparedStatement.setString(1, entity.getNameEn());
            preparedStatement.setString(2, entity.getCountryEn());
            preparedStatement.setString(3, entity.getNameUkr());
            preparedStatement.setString(4, entity.getCountryUkr());

            return 1 == preparedStatement.executeUpdate(); //one row was inserted
        }catch (SQLIntegrityConstraintViolationException ex){
            logger.error(ex.getMessage(), ex);
            return false;
        }catch (SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    @Override
    public Seaport findById(int id) {
        return null;
    }

    @Override
    public Optional<Seaport> findByNameEn(String  nameEn) {
        String selectPortByNameEn = "SELECT * FROM seaport WHERE name_en=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectPortByNameEn);
            preparedStatement.setString(1, nameEn);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(extractFromResultSet(resultSet));
            }
            return Optional.empty();

        } catch(SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    @Override
    public List<Seaport> findAll() {
        String selectAllSeaports = "SELECT * FROM seaport";
        List<Seaport> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllSeaports);
            while (resultSet.next()) {
                Seaport seaport = extractFromResultSet(resultSet);
                resultList.add(seaport);
            }
        }catch (SQLException e){
            logger.error(e.getMessage(), e);
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
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    private Seaport extractFromResultSet(ResultSet rs) throws SQLException {
        Seaport result = new Seaport();

        result.setId( rs.getLong("id") );
        result.setNameEn( rs.getString("name_en") );
        result.setCountryEn( rs.getString("country_en"));
        result.setNameUkr( rs.getString("name_ukr") );
        result.setCountryUkr( rs.getString("country_ukr") );

        return result;
    }
}
