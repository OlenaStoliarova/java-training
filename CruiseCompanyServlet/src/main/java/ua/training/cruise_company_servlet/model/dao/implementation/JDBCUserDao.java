package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DAOLevelException;
import ua.training.cruise_company_servlet.model.dao.UserDao;
import ua.training.cruise_company_servlet.model.dao.mapper.UserMapper;
import ua.training.cruise_company_servlet.model.entity.User;
import ua.training.cruise_company_servlet.model.enums.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private static final Logger LOG = LogManager.getLogger(JDBCUserDao.class);

    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String UPDATE_USER_ROLE = "UPDATE users SET role=? WHERE email=?";

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email){
        Optional<User> foundUser = Optional.empty();

        try(Connection connection = ConnectionPoolHolder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {

            preparedStatement.setString(1, email);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    foundUser = Optional.of(new UserMapper().extractFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return foundUser;
    }


    @Override
    public List<User> findAll(){
        List<User> resultList = new ArrayList<>();

        try(Connection connection = ConnectionPoolHolder.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS)) {

            while (resultSet.next()) {
                User user = new UserMapper().extractFromResultSet(resultSet);
                resultList.add(user);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return resultList;
    }

    public boolean updateUserRole(String email, UserRole newRole){

        try(Connection connection = ConnectionPoolHolder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_ROLE)) {

            preparedStatement.setString(1, newRole.toString());
            preparedStatement.setString(2, email);

            return preparedStatement.executeUpdate() > 0 ;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }
}
