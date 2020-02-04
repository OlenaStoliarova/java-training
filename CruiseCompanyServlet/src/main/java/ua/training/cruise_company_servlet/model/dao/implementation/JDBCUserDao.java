package ua.training.cruise_company_servlet.model.dao.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.cruise_company_servlet.model.dao.DAOLevelException;
import ua.training.cruise_company_servlet.model.dao.UserDao;
import ua.training.cruise_company_servlet.model.entity.User;
import ua.training.cruise_company_servlet.model.entity.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private static final Logger logger = LogManager.getLogger(JDBCUserDao.class);

    private final Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

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
        String selectUserByEmail = "SELECT * FROM users WHERE email=?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectUserByEmail);
            preparedStatement.setString(1, email);

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
    public List<User> findAll(){
        String selectAllUsers = "SELECT * FROM users";
        List<User> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllUsers);
            while (resultSet.next()) {
                User user = extractFromResultSet(resultSet);
                resultList.add(user);
            }
        }catch (SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }

        return resultList;
    }

    public boolean updateUserRole(String email, UserRole newRole){
        String updateUserRole = "UPDATE users SET role=? WHERE email=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateUserRole);
            preparedStatement.setString(1, newRole.toString());
            preparedStatement.setString(2, email);

            return preparedStatement.executeUpdate() > 0 ;
        }catch (SQLException e){
            logger.error(e.getMessage(), e);
            throw new DAOLevelException(e);
        }
    }

    @Override
    public void update(User entity) {

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

    private User extractFromResultSet(ResultSet rs) throws SQLException {
        User result = new User();

        result.setId( rs.getLong("id") );
        result.setEmail( rs.getString("email") );
        result.setPassword( rs.getString("password"));
        result.setFirstNameEn( rs.getString("first_name_en") );
        result.setLastNameEn( rs.getString("last_name_en") );
        result.setFirstNameNative( rs.getString("first_name_native") );
        result.setLastNameNative( rs.getString("last_name_native") );
        result.setRole( UserRole.valueOf( rs.getString("role") ));

        return result;
    }
}
